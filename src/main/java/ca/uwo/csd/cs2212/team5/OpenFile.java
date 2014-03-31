package ca.uwo.csd.cs2212.team5;

import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.filechooser.*;

public class OpenFile extends JPanel implements ActionListener{
	
	    static private final String newline = "\n";
	    JButton openButton, saveButton;
	    JTextArea log;
	    JFileChooser fc;

	    public OpenFile() {
	        super(new BorderLayout());

	        //Create the log first, because the action listeners
	        //need to refer to it.
	        log = new JTextArea(5,20);
	        log.setMargin(new Insets(5,5,5,5));
	        log.setEditable(false);
	        JScrollPane logScrollPane = new JScrollPane(log);

	        //Create a file chooser
	        fc = new JFileChooser();
	        fc.removeChoosableFileFilter(fc.getFileFilter());
	        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV file", "csv");
	        fc.addChoosableFileFilter(filter);


	        //Create the open button.  We use the image from the JLF
	        //Graphics Repository (but we extracted it from the jar).
	        openButton = new JButton("Open a File...");
	        openButton.addActionListener(this);

	        //Create the save button.  We use the image from the JLF
	        //Graphics Repository (but we extracted it from the jar).
	        saveButton = new JButton("Save a File...");
	        saveButton.addActionListener(this);

	        //For layout purposes, put the buttons in a separate panel
	        JPanel buttonPanel = new JPanel(); //use FlowLayout
	        buttonPanel.add(openButton);
	        buttonPanel.add(saveButton);

	        //Add the buttons and the log to this panel.
	        add(buttonPanel, BorderLayout.PAGE_START);
	        add(logScrollPane, BorderLayout.CENTER);
	    }

	    public void actionPerformed(ActionEvent e) {

	        //Handle open button action.
	        if (e.getSource() == openButton) {
	            int returnVal = fc.showOpenDialog(OpenFile.this);

	            if (returnVal == JFileChooser.APPROVE_OPTION) {
	                File file = fc.getSelectedFile();
	                
	                //This is where the application would open the file.
	                
	                log.append("Opening: " + file.getName() + "." + newline);
	                
	            } else {
	                log.append("Open command cancelled by user." + newline);
	            }
	            log.setCaretPosition(log.getDocument().getLength());
	            
	        //Handle save button action.
	        } else if (e.getSource() == saveButton) {
	            int returnVal = fc.showSaveDialog(OpenFile.this);
	            if (returnVal == JFileChooser.APPROVE_OPTION) {
	                File file = fc.getSelectedFile();
	                
	                //This is where the application would save the file.
	                
	                log.append("Saving: " + file.getName() + "." + newline);
	            } else {
	                log.append("Save command cancelled by user." + newline);
	            }
	            log.setCaretPosition(log.getDocument().getLength());
	        }
	    }

	    /**
	     * Create the GUI and show it.
	     */
	    static void createAndShowGUI() {
	        //Create and set up the window.
	        JFrame frame = new JFrame("Open/Save");
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	        //Add content to the window.
	        frame.add(new OpenFile());

	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	        frame.setLocationRelativeTo(null);
	    }
	}
