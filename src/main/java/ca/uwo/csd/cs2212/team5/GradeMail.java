package ca.uwo.csd.cs2212.team5;

import java.io.*;
import javax.activation.*;
import java.net.URL;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.apache.velocity.tools.generic.NumberTool;

public class GradeMail {

  private static String loadTemplate (String filename) {

    VelocityEngine ve = new VelocityEngine();
  	ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
  	ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

  	Template template = ve.getTemplate(filename);

  	StringWriter out = new StringWriter();
  	return out.toString();
  }

  private static Session getSession(final Properties properties) {
    Session session = Session.getInstance(properties,
        new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
            	String username = properties.getProperty("smtp.username");
            	String password = properties.getProperty("smtp.password");

                return new PasswordAuthentication(username, password);
            }
        }
    );

    return session;
  }

  private static void sendMessage(Session session, Properties properties, String[] recipients) throws Exception {

    Message msg = new MimeMessage(session);
    String senderName = properties.getProperty("sender.name");
    String senderEmail = properties.getProperty("sender.email");

    Address sender = new InternetAddress(senderEmail, senderName);
    msg.setFrom(sender);

    for (String address : recipients)
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(address));

    msg.setSubject(properties.getProperty("message.subject"));

    Multipart multiPart = new MimeMultipart();

	MimeBodyPart textPart = new MimeBodyPart();
	textPart.setText("Hello Student,\n\tWe are emailing you a report about your current status in this course.\nPlease see the enclosed pdf to view your grades.", "utf-8");

	MimeBodyPart htmlPart = new MimeBodyPart();
	htmlPart.setContent(loadTemplate("email.html.vm"), "text/html; charset=utf-8") ;

	MimeBodyPart fileAttachmentPart = new MimeBodyPart ();

	URL attachmentUrl = GradeMail.class.getClassLoader().getResource("Report.pdf");
	DataSource source = new URLDataSource ( attachmentUrl );
	fileAttachmentPart.setDataHandler ( new DataHandler ( source ));
	fileAttachmentPart.setFileName ("Report.pdf");

	multiPart.addBodyPart(textPart);
	multiPart.addBodyPart(htmlPart);
	multiPart.addBodyPart(fileAttachmentPart);

	msg.setContent(multiPart);

    Transport.send(msg);
  }

  public static void sendEmail (String[] addresses) throws Exception {

    if (addresses.length == 0) {
        System.out.println("Please specify a space-separated list of email addresses as arguments.");
        System.exit(-1);
    }
	Properties properties = loadProperties();
    Session session = getSession(properties);
    sendMessage(session, properties, addresses);

  }

  private static Properties loadProperties() throws Exception{
  	Properties properties = new Properties();
  	InputStream stream = GradeMail.class.getClassLoader().getResourceAsStream("mail.properties");
  	properties.load(stream);
  	return properties;
  }

}