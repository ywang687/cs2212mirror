package ca.uwo.csd.cs2212.team5;

/**
 * MainWindow is the class that manages the graphical user interface of the program
 * @author Bradley Hamelin
 *
 */

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.ListIterator;

public class MainWindow extends JFrame implements ActionListener{

  //Create the arrayList that holds the courses.
  ArrayList<Course> courses = new ArrayList<Course>();

  //Create a pointer to the active course in the arrayList of courses
  Course activeCourse;

  //Add buttons to the frame
  private JButton cmdAddCourse = new JButton ("Add a course");
  private JButton cmdAddStudent = new JButton ("Add a student");

  //Add a drop down box to select current course
  private JComboBox cboCourseList = new JComboBox();

  //Add text fields for naming students or courses
  private JTextField txtCourseName = new JTextField();
  private JTextField txtCourseCode = new JTextField();
  private JTextField txtCourseTerm = new JTextField();

  private JTextField txtFirstName = new JTextField();
  private JTextField txtLastName = new JTextField();
  private JTextField txtNumber = new JTextField();
  private JTextField txtEmail = new JTextField();

  //Add labels for the students or courses
  private JLabel lblCourseName = new JLabel("Course Name:");
  private JLabel lblCourseCode = new JLabel("Course Code:");
  private JLabel lblCourseTerm = new JLabel("Course Term:");

  private JLabel lblFirstName = new JLabel("First Name:");
  private JLabel lblLastName = new JLabel("Last Name:");
  private JLabel lblNumber = new JLabel("Student Number:");
  private JLabel lblEmail = new JLabel("Student Email:");

  //Add a label for greeting the user
  private JLabel lblGreeting = new JLabel("Welcome to Gradebook!");

  //Add a label for telling the user to select a course
  private JLabel lblSelect = new JLabel("Select a course:");

  private final String ICON_EXIT = "exit.png";

  private void initUI() {
    this.setTitle("GradeBoook");
    this.setSize(800, 600);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setJMenuBar(this.createMenubar());
  }

  //Create an instance of the layout manager
  SpringLayout layout = new SpringLayout();

  //Construct the frame with its components
  public MainWindow() {
    this.initUI();

    //Add the components to the window
    add(cmdAddCourse);
    add(cmdAddStudent);

    add(cboCourseList);

    add(txtCourseName);
    add(txtCourseCode);
    add(txtCourseTerm);
    add(txtFirstName);
    add(txtLastName);
    add(txtNumber);
    add(txtEmail);

    add(lblCourseName);
    add(lblCourseCode);
    add(lblCourseTerm);
    add(lblFirstName);
    add(lblLastName);
    add(lblNumber);
    add(lblEmail);

    add(lblGreeting);
    add(lblSelect);

    //Format the components
    cmdAddCourse.setPreferredSize(new Dimension(120,25));
    cmdAddStudent.setPreferredSize(new Dimension(120,25));

    cboCourseList.setPreferredSize(new Dimension(160,25));

    txtCourseName.setPreferredSize(new Dimension(200,25));
    txtCourseCode.setPreferredSize(new Dimension(200,25));
    txtCourseTerm.setPreferredSize(new Dimension(200,25));

    txtFirstName.setPreferredSize(new Dimension(200,25));
    txtLastName.setPreferredSize(new Dimension(200,25));
    txtNumber.setPreferredSize(new Dimension(200,25));
    txtEmail.setPreferredSize(new Dimension(200,25));

    //Name the buttons
    cmdAddCourse.setActionCommand("addCourse");
    cmdAddStudent.setActionCommand("addStudent");
    cboCourseList.setActionCommand("courseList");

    //Add the action listener to the active objects
    cmdAddCourse.addActionListener(this);
    cmdAddStudent.addActionListener(this);
    cboCourseList.addActionListener(this);

    //Set the layout for the frame
	this.getContentPane().setLayout(layout);

	//Set the north and west positions for the components
	layout.putConstraint(SpringLayout.WEST, cmdAddCourse, 170, SpringLayout.WEST, getContentPane());
	layout.putConstraint(SpringLayout.NORTH, cmdAddCourse, 30, SpringLayout.NORTH, getContentPane());

	layout.putConstraint(SpringLayout.WEST, cmdAddStudent, 170, SpringLayout.WEST, getContentPane());
	layout.putConstraint(SpringLayout.NORTH, cmdAddStudent, 150, SpringLayout.NORTH, getContentPane());

	layout.putConstraint(SpringLayout.WEST, cboCourseList, 0, SpringLayout.WEST, getContentPane());
	layout.putConstraint(SpringLayout.NORTH, cboCourseList, 30, SpringLayout.NORTH, getContentPane());

	//Position the text boxes
	layout.putConstraint(SpringLayout.WEST, txtCourseName, 290, SpringLayout.WEST, getContentPane());
	layout.putConstraint(SpringLayout.NORTH, txtCourseName, 60, SpringLayout.NORTH, getContentPane());

	layout.putConstraint(SpringLayout.WEST, txtCourseCode, 290, SpringLayout.WEST, getContentPane());
	layout.putConstraint(SpringLayout.NORTH, txtCourseCode, 90, SpringLayout.NORTH, getContentPane());

	layout.putConstraint(SpringLayout.WEST, txtCourseTerm, 290, SpringLayout.WEST, getContentPane());
	layout.putConstraint(SpringLayout.NORTH, txtCourseTerm, 120, SpringLayout.NORTH, getContentPane());

	layout.putConstraint(SpringLayout.WEST, txtFirstName, 290, SpringLayout.WEST, getContentPane());
	layout.putConstraint(SpringLayout.NORTH, txtFirstName, 180, SpringLayout.NORTH, getContentPane());

	layout.putConstraint(SpringLayout.WEST, txtLastName, 290, SpringLayout.WEST, getContentPane());
	layout.putConstraint(SpringLayout.NORTH, txtLastName, 210, SpringLayout.NORTH, getContentPane());

	layout.putConstraint(SpringLayout.WEST, txtNumber, 290, SpringLayout.WEST, getContentPane());
	layout.putConstraint(SpringLayout.NORTH, txtNumber, 240, SpringLayout.NORTH, getContentPane());

	layout.putConstraint(SpringLayout.WEST, txtEmail, 290, SpringLayout.WEST, getContentPane());
	layout.putConstraint(SpringLayout.NORTH, txtEmail, 270, SpringLayout.NORTH, getContentPane());

	//Position the labels
	layout.putConstraint(SpringLayout.WEST, lblCourseName, 170, SpringLayout.WEST, getContentPane());
	layout.putConstraint(SpringLayout.NORTH, lblCourseName, 60, SpringLayout.NORTH, getContentPane());

	layout.putConstraint(SpringLayout.WEST, lblCourseCode, 170, SpringLayout.WEST, getContentPane());
	layout.putConstraint(SpringLayout.NORTH, lblCourseCode, 90, SpringLayout.NORTH, getContentPane());

	layout.putConstraint(SpringLayout.WEST, lblCourseTerm, 170, SpringLayout.WEST, getContentPane());
	layout.putConstraint(SpringLayout.NORTH, lblCourseTerm, 120, SpringLayout.NORTH, getContentPane());

	layout.putConstraint(SpringLayout.WEST, lblFirstName, 170, SpringLayout.WEST, getContentPane());
	layout.putConstraint(SpringLayout.NORTH, lblFirstName, 180, SpringLayout.NORTH, getContentPane());

	layout.putConstraint(SpringLayout.WEST, lblLastName, 170, SpringLayout.WEST, getContentPane());
	layout.putConstraint(SpringLayout.NORTH, lblLastName, 210, SpringLayout.NORTH, getContentPane());

	layout.putConstraint(SpringLayout.WEST, lblNumber, 170, SpringLayout.WEST, getContentPane());
	layout.putConstraint(SpringLayout.NORTH, lblNumber, 240, SpringLayout.NORTH, getContentPane());

	layout.putConstraint(SpringLayout.WEST, lblEmail, 170, SpringLayout.WEST, getContentPane());
	layout.putConstraint(SpringLayout.NORTH, lblEmail, 270, SpringLayout.NORTH, getContentPane());

	layout.putConstraint(SpringLayout.WEST, lblGreeting, 280, SpringLayout.WEST, getContentPane());
	layout.putConstraint(SpringLayout.NORTH, lblGreeting, 0, SpringLayout.NORTH, getContentPane());

	layout.putConstraint(SpringLayout.WEST, lblSelect, 0, SpringLayout.WEST, getContentPane());
	layout.putConstraint(SpringLayout.NORTH, lblSelect, 0, SpringLayout.NORTH, getContentPane());
  }

  //Creates the menu bar through which the user is able to exit the program
  private JMenuBar createMenubar() {

    JMenuBar menubar = new JMenuBar();

    JMenu mnuFile = new JMenu("File");
    mnuFile.setMnemonic(KeyEvent.VK_F);
	JMenuItem mniFileExit = new JMenuItem("Exit", loadIcon(ICON_EXIT));
    mniFileExit.setMnemonic(KeyEvent.VK_E);
    mniFileExit.setToolTipText("Exit application");
    mniFileExit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        System.exit(0);
      }
    });

    mnuFile.add(mniFileExit);
    menubar.add(mnuFile);

    return menubar;
  }

  private ImageIcon loadIcon(String filename) {

    try {
      InputStream in = MainWindow.class.getClassLoader().getResourceAsStream(filename);
      return new ImageIcon(ImageIO.read(in));
    }
    catch (Exception ex) {
      return null;
    }
  }

  //Methods called upon button presses
  public void addCourse(){
  	//Check to make sure the text fields are filled out fully
  	if(!txtCourseName.getText().equals("")&&!txtCourseCode.getText().equals("")&&!txtCourseTerm.getText().equals("")){
		lblGreeting.setText("Course successfully added!");
		courses.add(new Course(txtCourseName.getText(),txtCourseCode.getText(),txtCourseTerm.getText(),true));

		//Add this to the combo box
		String title = (txtCourseName.getText() + " - " + txtCourseCode.getText() + " - " + txtCourseTerm.getText());
		cboCourseList.addItem(title);

		txtCourseName.setText("");
		txtCourseCode.setText("");
		txtCourseTerm.setText("");
  	}
  	else
  		lblGreeting.setText("Error. Please enter a proper course name, code and term.");


  }

  //Creates a student object for the currently selected class
  public void addStudent(){
  	lblGreeting.setText("Student successfully added!");
  }

  //Changes the selected course
  public void courseList(){
  	Object selection = cboCourseList.getSelectedItem();
  	String currentCourse = selection.toString();
  	lblGreeting.setText("Changed active course to " + currentCourse + ".");

  	//Find the selected course in the arrayList
  	for(ListIterator<Course> iterator = courses.listIterator(); iterator.hasNext();) {
		Course x = iterator.next();
		if (currentCourse.equals(x.getTitle() + " - " + x.getCode() + " - " + x.getTerm())){
			activeCourse = x;
			lblGreeting.setText("Changed active course to " + currentCourse + " successfully.");
		}
	}

  }

  //Create actions
  public void actionPerformed(ActionEvent evt)
  {
  	//Make actions for class buttons
		if (evt.getActionCommand().equals("addCourse"))
			addCourse();
		else if (evt.getActionCommand().equals("addStudent"))
			addStudent();
		else if (evt.getActionCommand().equals("courseList"))
			courseList();
  }

}