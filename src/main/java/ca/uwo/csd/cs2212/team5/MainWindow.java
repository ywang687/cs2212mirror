package ca.uwo.csd.cs2212.team5;

/**
 * MainWindow is the class that manages the graphical user interface of the program.
 * @author Bradley Hamelin
 *
 */

import java.awt.*;

import javax.swing.*;

import java.io.*;
import java.awt.event.*;

import javax.imageio.ImageIO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class MainWindow extends JFrame implements ActionListener {
    /** Instance variables **/

    //Create the arrayList that holds the courses.
    ArrayList < Course > courses = new ArrayList < Course > ();

    ArrayList < Student > students = new ArrayList < Student > ();

    ArrayList < Deliverable > deliverables = new ArrayList < Deliverable > ();

    //Create a pointer to the active course in the arrayList of courses
    Course activeCourse;

    //Create a pointer to the active student in the arrayList of students
    Student activeStudent;

    //Create a pointer to the active deliverable in the arrayList of deliverables
    Deliverable activeDeliverable;

    //Add buttons to the frame
    private JButton cmdAddCourse = new JButton("Add course");
    private JButton cmdAddStudent = new JButton("Add student");
    private JButton cmdEditCourse = new JButton("Edit active course");
    private JButton cmdEditStudent = new JButton("Edit active student");
    private JButton cmdAddDeliverable = new JButton("Add deliverable");
    private JButton cmdEditDeliverable = new JButton("Edit active deliverable");
    private JButton cmdOpenGradeWindow = new JButton("Open grade spreadsheet");
    private JButton cmdDeleteStudent = new JButton("Delete active student");
    private JButton cmdDeleteCourse = new JButton("Delete active course");
    private JButton cmdDeleteDeliverable = new JButton("Delete active deliverable");

    //Add a drop down box to select current course
    private JComboBox cboCourseList = new JComboBox ();
    private JComboBox cboStudentList = new JComboBox ();
    private JComboBox cboDeliverableList = new JComboBox ();

    //Add text fields for naming students or courses
    private JTextField txtCourseName = new JTextField();
    private JTextField txtCourseCode = new JTextField();
    private JTextField txtCourseTerm = new JTextField();

    private JTextField txtFirstName = new JTextField();
    private JTextField txtLastName = new JTextField();
    private JTextField txtNumber = new JTextField();
    private JTextField txtEmail = new JTextField();

    private JTextField txtDeliverName = new JTextField();
    private JTextField txtDeliverType = new JTextField();
    private JTextField txtDeliverWeight = new JTextField();

    //Add labels for the students or courses
    private JLabel lblCourseName = new JLabel("Course Name:");
    private JLabel lblCourseCode = new JLabel("Course Code:");
    private JLabel lblCourseTerm = new JLabel("Course Term:");

    private JLabel lblFirstName = new JLabel("First Name:");
    private JLabel lblLastName = new JLabel("Last Name:");
    private JLabel lblNumber = new JLabel("Student Number:");
    private JLabel lblEmail = new JLabel("Student Email:");

    private JLabel lblDeliverName = new JLabel("Deliverable Name:");
    private JLabel lblDeliverType = new JLabel("Deliverable Type:");
    private JLabel lblDeliverWeight = new JLabel("<html>Deliverable Weight<br>Enter a double (0.0)</html>");

    //Add a label for greeting the user
    private JLabel lblGreeting2 = new JLabel("Welcome to Gradebook!");
    private JLabel lblGreeting = new JLabel("");

    //Add a label for telling the user to select a course
    private JLabel lblSelect = new JLabel("Select a course:");
    private JLabel lblStudentSelect = new JLabel("Select a student:");
    private JLabel lblDeliverableSelect = new JLabel("Select a deliverable:");

    private static final String save_path_course = System.getProperty("user.dir") + System.getProperty("file.separator") + "course.ser";
    private static final String save_path_student = System.getProperty("user.dir") + System.getProperty("file.separator") + "student.ser";

    private final String ICON_EXIT = "exit.png";

    private void initUI() {
        this.setTitle("GradeBook");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setJMenuBar(this.createMenubar());

        try{
        	load();
        	for (int i = 0; i < courses.size(); i++) {
        		Course tmp = courses.get(i);
        		cboCourseList.addItem(tmp.getTitle() + " - "+tmp.getCode()+" - "+tmp.getTerm());
        	}
        	rebuildStudents();
        	System.out.println(courses.size());

        	//make the active course the first course in the list
        	if(courses.size()!=0){
        		this.activeCourse=courses.get(0);
        		rebuildStudents();
        		rebuildDeliverables();
        	}
        }catch (Exception e){
        	e.printStackTrace();
        	courses.add(new Course("Computer Science", "CS2212","B",true));
        	System.out.println("New file!");
        }

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {

             try {
                save();
             } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
             }

                System.out.println("In shutdown hook");

            }
        }, "Shutdown-thread"));
    }

    //Create an instance of the layout manager
    SpringLayout layout = new SpringLayout();

    //Construct the frame with its components
    public MainWindow() {
        this.initUI();
        //Add the components to the window
        add(cmdAddCourse);
        add(cmdAddStudent);
        add(cmdEditCourse);
        add(cmdEditStudent);
        add(cmdAddDeliverable);
        add(cmdEditDeliverable);
        add(cmdOpenGradeWindow);
        add(cmdDeleteCourse);
        add(cmdDeleteStudent);
        add(cmdDeleteDeliverable);

        add(cboCourseList);
        add(cboStudentList);
        add(cboDeliverableList);

        add(txtCourseName);
        add(txtCourseCode);
        add(txtCourseTerm);
        add(txtFirstName);
        add(txtLastName);
        add(txtNumber);
        add(txtEmail);
        add(txtDeliverName);
        add(txtDeliverType);
        add(txtDeliverWeight);

        add(lblCourseName);
        add(lblCourseCode);
        add(lblCourseTerm);
        add(lblFirstName);
        add(lblLastName);
        add(lblNumber);
        add(lblEmail);
        add(lblDeliverName);
        add(lblDeliverType);
        add(lblDeliverWeight);

        add(lblGreeting);
        add(lblGreeting2);
        add(lblSelect);
        add(lblStudentSelect);
        add(lblDeliverableSelect);

        //Format the components
        cmdAddCourse.setPreferredSize(new Dimension(130, 25));
        cmdAddStudent.setPreferredSize(new Dimension(130, 25));
        cmdAddDeliverable.setPreferredSize(new Dimension(130, 25));
        cmdEditCourse.setPreferredSize(new Dimension(200, 25));
        cmdEditStudent.setPreferredSize(new Dimension(200, 25));
        cmdEditDeliverable.setPreferredSize(new Dimension(200, 25));
        cmdOpenGradeWindow.setPreferredSize(new Dimension(200, 25));
        cmdDeleteCourse.setPreferredSize(new Dimension(200, 25));
        cmdDeleteStudent.setPreferredSize(new Dimension(200, 25));
        cmdDeleteDeliverable.setPreferredSize(new Dimension(200, 25));

        cboCourseList.setPreferredSize(new Dimension(160, 25));
        cboStudentList.setPreferredSize(new Dimension(160, 25));
        cboDeliverableList.setPreferredSize(new Dimension(160, 25));

        txtCourseName.setPreferredSize(new Dimension(200, 25));
        txtCourseCode.setPreferredSize(new Dimension(200, 25));
        txtCourseTerm.setPreferredSize(new Dimension(200, 25));

        txtFirstName.setPreferredSize(new Dimension(200, 25));
        txtLastName.setPreferredSize(new Dimension(200, 25));
        txtNumber.setPreferredSize(new Dimension(200, 25));
        txtEmail.setPreferredSize(new Dimension(200, 25));

        txtDeliverName.setPreferredSize(new Dimension(200, 25));
        txtDeliverType.setPreferredSize(new Dimension(200, 25));
        txtDeliverWeight.setPreferredSize(new Dimension(200, 25));

        //Name the buttons
        cmdAddCourse.setActionCommand("addCourse");
        cmdAddStudent.setActionCommand("addStudent");
        cmdAddDeliverable.setActionCommand("addDeliverable");
        cmdEditCourse.setActionCommand("editCourse");
        cmdEditStudent.setActionCommand("editStudent");
        cmdEditDeliverable.setActionCommand("editDeliverable");
        cmdOpenGradeWindow.setActionCommand("openGradeWindow");
        cmdDeleteCourse.setActionCommand("deleteCourse");
        cmdDeleteStudent.setActionCommand("deleteStudent");
        cmdDeleteDeliverable.setActionCommand("deleteDeliverable");

        cboCourseList.setActionCommand("courseList");
        cboStudentList.setActionCommand("studentList");
        cboDeliverableList.setActionCommand("deliverableList");

        //Add the action listener to the active objects
        cmdAddCourse.addActionListener(this);
        cmdAddStudent.addActionListener(this);
        cmdAddDeliverable.addActionListener(this);
        cmdEditCourse.addActionListener(this);
        cmdEditStudent.addActionListener(this);
        cmdEditDeliverable.addActionListener(this);
        cmdOpenGradeWindow.addActionListener(this);
        cmdDeleteCourse.addActionListener(this);
        cmdDeleteStudent.addActionListener(this);
        cmdDeleteDeliverable.addActionListener(this);

        cboCourseList.addActionListener(this);
        cboStudentList.addActionListener(this);
        cboDeliverableList.addActionListener(this);

        //Set the layout for the frame
        this.getContentPane().setLayout(layout);

        //Set the north and west positions for the command buttons
        layout.putConstraint(SpringLayout.WEST, cmdAddCourse, 170, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, cmdAddCourse, 30, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, cmdAddStudent, 170, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, cmdAddStudent, 150, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, cmdAddDeliverable, 170, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, cmdAddDeliverable, 300, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, cmdEditCourse, 300, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, cmdEditCourse, 30, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, cmdEditStudent, 300, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, cmdEditStudent, 150, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, cmdEditDeliverable, 300, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, cmdEditDeliverable, 300, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, cmdOpenGradeWindow, 300, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, cmdOpenGradeWindow, 430, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, cmdDeleteCourse, 500, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, cmdDeleteCourse, 30, SpringLayout.NORTH, getContentPane());
        
        layout.putConstraint(SpringLayout.WEST, cmdDeleteStudent, 500, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, cmdDeleteStudent, 150, SpringLayout.NORTH, getContentPane());
        
        layout.putConstraint(SpringLayout.WEST, cmdDeleteDeliverable, 500, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, cmdDeleteDeliverable, 300, SpringLayout.NORTH, getContentPane());

        //Position the comboboxes
        layout.putConstraint(SpringLayout.WEST, cboCourseList, 0, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, cboCourseList, 30, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, cboStudentList, 0, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, cboStudentList, 90, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, cboDeliverableList, 0, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, cboDeliverableList, 150, SpringLayout.NORTH, getContentPane());

        //Position the text boxes
        layout.putConstraint(SpringLayout.WEST, txtCourseName, 300, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, txtCourseName, 60, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, txtCourseCode, 300, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, txtCourseCode, 90, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, txtCourseTerm, 300, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, txtCourseTerm, 120, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, txtFirstName, 300, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, txtFirstName, 180, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, txtLastName, 300, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, txtLastName, 210, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, txtNumber, 300, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, txtNumber, 240, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, txtEmail, 300, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, txtEmail, 270, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, txtDeliverName, 300, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, txtDeliverName, 330, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, txtDeliverType, 300, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, txtDeliverType, 360, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, txtDeliverWeight, 300, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, txtDeliverWeight, 390, SpringLayout.NORTH, getContentPane());

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

        layout.putConstraint(SpringLayout.WEST, lblDeliverName, 170, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, lblDeliverName, 330, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, lblDeliverType, 170, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, lblDeliverType, 360, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, lblDeliverWeight, 170, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, lblDeliverWeight, 390, SpringLayout.NORTH, getContentPane());


        layout.putConstraint(SpringLayout.WEST, lblGreeting2, 320, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, lblGreeting2, 0, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, lblGreeting, 220, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, lblGreeting, 490, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, lblSelect, 0, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, lblSelect, 0, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, lblStudentSelect, 0, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, lblStudentSelect, 60, SpringLayout.NORTH, getContentPane());

        layout.putConstraint(SpringLayout.WEST, lblDeliverableSelect, 0, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, lblDeliverableSelect, 120, SpringLayout.NORTH, getContentPane());
    }

    //Creates the menu bar through which the user is able to exit the program
    private JMenuBar createMenubar() {

        JMenuBar menubar = new JMenuBar();

        JMenu mnuFile = new JMenu("File");
        mnuFile.setMnemonic(KeyEvent.VK_F);
        JMenuItem mniFileExit = new JMenuItem("Exit", loadIcon(ICON_EXIT));
        mniFileExit.setMnemonic(KeyEvent.VK_E);
        mniFileExit.setToolTipText("Exit application");
        mniFileExit.addActionListener(new ActionListener() {@
            Override
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
            return new ImageIcon(ImageIO.read( in ));
        } catch (Exception ex) {
            return null;
        }
    }

    //Methods called upon button presses
    private void addCourse() {
        //Check to make sure the text fields are filled out fully
        if (!txtCourseName.getText().equals("") && !txtCourseCode.getText().equals("") && !txtCourseTerm.getText().equals("")) {
            lblGreeting.setText("Success! Course successfully added!");
            courses.add(new Course(txtCourseName.getText(), txtCourseCode.getText(), txtCourseTerm.getText(), true));

            //Add this to the combo box
            String title = (txtCourseName.getText() + " - " + txtCourseCode.getText() + " - " + txtCourseTerm.getText());
            cboCourseList.addItem(title);

            //Clear the text boxes for new data
            txtCourseName.setText("");
            txtCourseCode.setText("");
            txtCourseTerm.setText("");
        }

      //print an error message if one or more of the fields are left empty
        else if(txtCourseName.getText().equals("")){
            lblGreeting.setText("Error: Invalid course name. Course name cannot be empty.");}
        else if(txtCourseCode.getText().equals("")){
            lblGreeting.setText("Error: Invalid course code. Course code cannot be empty.");}
        else if(txtCourseTerm.getText().equals("")){
            lblGreeting.setText("Error: Invalid course term. Course term cannot be empty.");}
    }

    //Method to edit the active course's data
    private void editCourse() {
        if (!txtCourseName.getText().equals("") && !txtCourseCode.getText().equals("") && !txtCourseTerm.getText().equals("")) {
        	if (activeCourse != null) {

        	lblGreeting.setText("Success! Active course has been modified.");

            String oldCourse = activeCourse.stringRepresentation();

            activeCourse.setTitle(txtCourseName.getText());
            activeCourse.setCode(txtCourseCode.getText());
            activeCourse.setTerm(txtCourseTerm.getText());

            //Remove the old course and replace with the new one
            cboCourseList.addItem(activeCourse.stringRepresentation());
            cboCourseList.removeItem(oldCourse);


        //Clear the text boxes for new data
        txtCourseName.setText("");
        txtCourseCode.setText("");
        txtCourseTerm.setText("");

        } else
            lblGreeting.setText("Error: Please select an active course to edit.");
        //Reload the students and reload the deliverables
        System.out.println("Number of students this changed course has:" + activeCourse.getStudents().size());
        }

      //print an error message if one or more of the fields are not filled in
        else if(txtFirstName.getText().equals("")){
            lblGreeting.setText("Error: Invalid first name. First name cannot be empty.");}
        else if(txtLastName.getText().equals("")){
            lblGreeting.setText("Error: Invalid last name. Last cannot be empty.");}
        else if(txtNumber.getText().equals("")){
            lblGreeting.setText("Error: Invalid student number. Student number cannot be empty.");}
        else if(txtEmail.getText().equals("")){
            lblGreeting.setText("Error: Invalid email. Student email address cannot be empty.");}
    }

    //Creates a student object for the currently selected class
    private void addStudent() {
        if (!txtFirstName.getText().equals("") && !txtLastName.getText().equals("") && !txtNumber.getText().equals("") && !txtEmail.getText().equals("")) {
           if(!activeCourse.hasStudentEmail(txtEmail.getText())&&!activeCourse.hasStudentNumber(txtNumber.getText())){

				//Create a new student object
				Student newStud = new Student(txtFirstName.getText(), txtLastName.getText(), txtNumber.getText(), txtEmail.getText());
                activeCourse.addStudent(newStud);
                lblGreeting.setText("Student " + txtFirstName.getText() + " " + txtLastName.getText() + " added successfully to " + activeCourse.getTitle() + ".");

                //Add the new student to the combo box
                cboStudentList.addItem(newStud.stringRepresentation());

                txtFirstName.setText("");
                txtLastName.setText("");
                txtNumber.setText("");
                txtEmail.setText("");

                //Initialize the student's deliverable grades
                for(int x = 0; x < activeCourse.getDeliverables().size(); x++){
					newStud.addGrade(0.0);
                }
           }
           else if(activeCourse.hasStudentEmail(txtEmail.getText())){
        	   lblGreeting.setText("Error:Invalid email. Email address already assigned to another student.");
           }
           else if(activeCourse.hasStudentNumber(txtNumber.getText())){
        	   lblGreeting.setText("Error:Invalid student number. Student number already assigned to another student.");
           }

        }
        //print an error message if one or more of the fields are not filled in
        else if(txtFirstName.getText().equals("")){
            lblGreeting.setText("Error: Invalid first name. First name cannot be empty.");}
        else if(txtLastName.getText().equals("")){
            lblGreeting.setText("Error: Invalid last name. Last cannot be empty.");}
        else if(txtNumber.getText().equals("")){
            lblGreeting.setText("Error: Invalid student number. Student number cannot be empty.");}
        else if(txtEmail.getText().equals("")){
            lblGreeting.setText("Error: Invalid email. Student email address cannot be empty.");}
    }

    //edits the student object currently selected
    private void editStudent() {
        if (!txtFirstName.getText().equals("") && !txtLastName.getText().equals("") && !txtNumber.getText().equals("") && !txtEmail.getText().equals("")) {
            if(activeStudent!=null){
        	    //checks to make sure student number or email doesn't already exist
            	if((!(!activeStudent.getEmailAddress().equals(txtEmail.getText()) && activeCourse.hasStudentEmail(txtEmail.getText())))  &&
        			   (!(!activeStudent.getNumber().equals(txtNumber.getText()) && activeCourse.hasStudentNumber(txtNumber.getText())))){

                lblGreeting.setText("Success! Active student has been modified");

                activeStudent.setFirstName(txtFirstName.getText());
                activeStudent.setLastName(txtLastName.getText());
                activeStudent.setNumber(txtNumber.getText());
                activeStudent.setEmailAddress(txtEmail.getText());

            rebuildStudents();

            //Clear the textboxes
            txtFirstName.setText("");
            txtLastName.setText("");
            txtNumber.setText("");
            txtEmail.setText("");
        	   }
        	   else if(!activeStudent.getEmailAddress().equals(txtEmail.getText()) && activeCourse.hasStudentEmail(txtEmail.getText())){
        		   lblGreeting.setText("Error: Invalid email. Email address already assigned to another student.");
        	   }
        	   else if((!activeStudent.getNumber().equals(txtNumber.getText()) && activeCourse.hasStudentNumber(txtNumber.getText()))){
        		   lblGreeting.setText("Error: Invalid student number. Student number already assigned to another student.");
        	   }

            }
            else{
                lblGreeting.setText("Error: Please select an existing student before editing.");
            }
        }

        //print an error message if one or more of the fields are not filled in
        else if(txtFirstName.getText().equals("")){
            lblGreeting.setText("Error: Invalid first name. First name cannot be empty.");}
        else if(txtLastName.getText().equals("")){
            lblGreeting.setText("Error: Invalid last name. Last cannot be empty.");}
        else if(txtNumber.getText().equals("")){
            lblGreeting.setText("Error: Invalid student number. Student number cannot be empty.");}
        else if(txtEmail.getText().equals("")){
            lblGreeting.setText("Error: Invalid email. Student email address cannot be empty.");}
    }

    //Adds a deliverable to the currently selected course
    private void addDeliverable() {
        if (!txtDeliverName.getText().equals("") && !txtDeliverType.getText().equals("") && !txtDeliverWeight.getText().equals("")) {
            if (activeCourse != null) {

				Deliverable newDeliver = new Deliverable(txtDeliverName.getText(), txtDeliverType.getText(), Double.parseDouble(txtDeliverWeight.getText()));
                activeCourse.addDeliverable(newDeliver);

                lblGreeting.setText("Deliverable " + txtDeliverName.getText() + " added successfully to " + activeCourse.getTitle() + ".");

                //Add the new student to the combo box
                cboDeliverableList.addItem(newDeliver.stringRepresentation());

                txtDeliverName.setText("");
                txtDeliverType.setText("");
                txtDeliverWeight.setText("");

                //Add a new deliverable to each student's grades

                for(int x = 0; x < activeCourse.getStudents().size(); x++){
                	activeCourse.getStudents().get(x).addGrade(0.0);
                }
            } else
                lblGreeting.setText("Error: Please select a course before adding a deliverable.");
        }

        //print an error message if one or more of the fields are left empty
        else if(txtDeliverName.getText().equals("")){
            lblGreeting.setText("Error: Invalid deliverable name. Deliverable name cannot be empty.");}
        else if(txtDeliverType.getText().equals("")){
            lblGreeting.setText("Error: Invalid deliverable type. Deliverable type cannot be empty.");}
        else if(txtDeliverWeight.getText().equals("")){
            lblGreeting.setText("Error: Invalid deliverable weight. Deliverable weight cannot be empty.");}
    }

    private void editDeliverable() {
        if (!txtDeliverName.getText().equals("") && !txtDeliverType.getText().equals("") && !txtDeliverWeight.getText().equals("")) {
            lblGreeting.setText("Success! Active deliverable has been modified.");

            activeDeliverable.setName(txtDeliverName.getText());
            activeDeliverable.setType(txtDeliverType.getText());
            activeDeliverable.setWeight(Double.parseDouble(txtDeliverWeight.getText()));

            rebuildDeliverables();

            //Clear the textboxes
            txtDeliverName.setText("");
            txtDeliverType.setText("");
            txtDeliverWeight.setText("");
        }
        else if(txtDeliverName.getText().equals("")){
            lblGreeting.setText("Error: Invalid deliverable name. Deliverable name cannot be empty.");}
        else if(txtDeliverType.getText().equals("")){
            lblGreeting.setText("Error: Invalid deliverable type. Deliverable type cannot be empty.");}
        else if(txtDeliverWeight.getText().equals("")){
            lblGreeting.setText("Error: Invalid deliverable weight. Deliverable weight cannot be empty.");}
    }
    
    private void rebuildCourses() {
    	
    	cboCourseList.removeAllItems();
    	
    	Object[] tmpList = courses.toArray();
    	Arrays.sort(tmpList);
    	courses = new ArrayList<Course>();
    	for (Object tmp: tmpList) {
    		courses.add((Course)tmp);
    	}
    	
    	for (ListIterator < Course > iterator = courses.listIterator(); iterator.hasNext();) {
            Course x = iterator.next();
            cboCourseList.addItem(new String(x.getTitle() + " - " + x.getCode() + " - " + x.getTerm()));
        }
    }

    //Rebuild the list of students when the course is changed
    private void rebuildStudents() {
        //Clear the combo box
    	if (activeCourse != null){
	        cboStudentList.removeAllItems();
	        
	        activeCourse.order();

	        //Iterate through the active course's students, adding each one to the combo box
	        for (ListIterator < Student > iterator = activeCourse.getStudents().listIterator(); iterator.hasNext();) {
	            Student x = iterator.next();
	            cboStudentList.addItem(new String(x.getFirstName() + " " + x.getLastName() + " " + x.getNumber() + " " + x.getEmailAddress()));
	        }
    	}
    }

    //Reconstructs the Deliverables combo box when a Course change happens

    //Rebuild the list of deliverables when the course is changed
    private void rebuildDeliverables() {
        //Clear the combo box
        cboDeliverableList.removeAllItems();
        
        activeCourse.order();

        //Iterate through the active course's deliverables, adding each one to the combo box
        for (ListIterator < Deliverable > iterator = activeCourse.getDeliverables().listIterator(); iterator.hasNext();) {
            Deliverable x = iterator.next();
            cboDeliverableList.addItem(new String(x.getName() + " - " + x.getType() + " - " + x.getWeight()));
        }
    }

    //Makes the selected course active

    //Changes the selected course
    public void courseList() {
    	if (courses.size() == 0 || cboCourseList.getItemCount() == 0)
    		return;
        activeStudent = null;
        String currentCourse = cboCourseList.getSelectedItem().toString();
        System.out.println("Trying");
        lblGreeting.setText("Changing active course to " + currentCourse + ".");

        //Find the selected course in the arrayList
        for (ListIterator < Course > iterator = courses.listIterator(); iterator.hasNext();) {
            Course x = iterator.next();
            if (currentCourse.equals(x.getTitle() + " - " + x.getCode() + " - " + x.getTerm())) {
                activeCourse = x;
                lblGreeting.setText("Success! Changed active course to " + currentCourse + " successfully.");
            }
        }

        //Update active student list
        rebuildStudents();

        //Update active deliverable list
        rebuildDeliverables();
    }

    //Changes the selected Student

    //Makes the selected student active
    public void studentList() {

        if (cboStudentList.getSelectedItem() != null) {
            String currentStudent = cboStudentList.getSelectedItem().toString();
            lblGreeting.setText("Attempting to change active student to " + currentStudent + ".");

            //Find the selected student in the arrayList
            for (ListIterator < Student > iterator = activeCourse.getStudents().listIterator(); iterator.hasNext();) {
                Student x = iterator.next();
                if (currentStudent.equals(x.getFirstName() + " " + x.getLastName() + " " + x.getNumber() + " " + x.getEmailAddress())) {
                    activeStudent = x;
                    lblGreeting.setText("Success! Changed active student to " + activeStudent.getFirstName() + ".");
                }
            }
        }
    }

    //Changes the selected Deliverable

    //Makes the selected deliverable active
    public void deliverableList() {
        if (cboDeliverableList.getSelectedItem() != null) {
        	if (activeCourse.getDeliverables().size() == 0)
        		return;
            String currentDeliverable = cboDeliverableList.getSelectedItem().toString();
            System.out.println("Current Deliverable: " + currentDeliverable);
            lblGreeting.setText("Attempting to change active deliverable to " + currentDeliverable + ".");

            //Find the selected student in the arrayList
            for (ListIterator < Deliverable > iterator = activeCourse.getDeliverables().listIterator(); iterator.hasNext();) {
                Deliverable x = iterator.next();
                System.out.println(x.getName());
                if (currentDeliverable.equals(x.getName() + " - " + x.getType() + " - " + x.getWeight())) {
                    activeDeliverable = x;
                    lblGreeting.setText("Success! Changed active deliverable to " + activeDeliverable.getName() + ".");
                }
            }
        }
    }

    private void save() throws IOException {
        FileOutputStream file_out_course = new FileOutputStream(save_path_course);
        FileOutputStream file_out_student = new FileOutputStream(save_path_student);
        ObjectOutputStream out_course = new ObjectOutputStream(file_out_course);
        ObjectOutputStream out_student = new ObjectOutputStream(file_out_student);

        out_course.writeObject(courses);
        out_student.writeObject(students);
        out_course.close();
        out_student.close();
        file_out_course.close();
        file_out_student.close();
//        System.out.printf("Serialized data is saved in " + save_pat);
      }

    //A method to load the course arrayList from a textfile
    private void load() throws IOException{
  	  try
        {
           FileInputStream fileIn = new FileInputStream(save_path_course);
           FileInputStream fileInStudent = new FileInputStream(save_path_student);
           ObjectInputStream in = new ObjectInputStream(fileIn);
           ObjectInputStream inStudent = new ObjectInputStream(fileInStudent);
           courses = (ArrayList<Course>) in.readObject();
           students = (ArrayList<Student>) inStudent.readObject();
           in.close();
           inStudent.close();
           fileIn.close();
           fileInStudent.close();

        }catch(ClassNotFoundException c)
        {
           System.out.println("School class not found.");
           c.printStackTrace();
           return;
        }
    }

    private void openGradeWindow(Course s){

    	GradeWindow g=new GradeWindow(s);

    	g.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    	g.pack();

    	g.setVisible(true);
    }
    
    private void deleteCourse() {
    	if (activeCourse != null) {
    		int pos = courses.indexOf(activeCourse);
    		Course removed = courses.remove(pos);
    		
    		if (courses.size() > 0) {
    			activeCourse = courses.get(Math.min(pos, courses.size() - 1));
    		}
    		else{
    			activeCourse = null;
    		}
    		
    		String nameToRemove = removed.getTitle() + " - " + removed.getCode() + " - " + removed.getTerm();
    		
    		cboCourseList.removeItem(nameToRemove);
    	}
    }
    
    private void deleteStudent() {
    	if (activeCourse != null && activeStudent != null) {
    		int pos = activeCourse.getStudents().indexOf(activeStudent);
    		Student removed = activeCourse.deleteStudent(activeStudent);
    		
    		if (activeCourse.getStudents().size() > 0){
    			activeStudent = activeCourse.getStudents().get(Math.min(pos, activeCourse.getStudents().size() - 1));
    		}
    		else {
    			activeStudent = null;
    		}
    		
    		rebuildStudents();
    		
//    		String nameToRemove = removed.getFirstName() + " " + removed.getLastName() + " " + removed.getNumber() + " " + removed.getEmailAddress();
//    		
//    		cboStudentList.removeItem(nameToRemove);
    	}
    }
    
    private void deleteDeliverable() {
    	if (activeCourse != null && activeDeliverable != null) {
    		int pos = activeCourse.getDeliverables().indexOf(activeDeliverable);
    		Deliverable removed = activeCourse.deleteDeliverable(activeDeliverable);
    		
    		if (activeCourse.getDeliverables().size() > 0){
    			activeDeliverable = activeCourse.getDeliverables().get(Math.min(pos, activeCourse.getDeliverables().size() - 1));
    		}
    		else {
    			activeDeliverable = null;
    		}
    		
    		rebuildDeliverables();
//    		String nameToRemove = removed.getName() + " - " + removed.getType() + " - " + removed.getWeight();
    		
//    		cboDeliverableList.removeItem(nameToRemove);
    	}
    }

    //Create actions
    public void actionPerformed(ActionEvent evt) {
        //Make actions for class buttons
        if (evt.getActionCommand().equals("addCourse")) {
            addCourse();
//            save();
        } else if (evt.getActionCommand().equals("addStudent")) {
            addStudent();
//            save();
        } else if (evt.getActionCommand().equals("addDeliverable")) {
            addDeliverable();
//            save();
        } else if (evt.getActionCommand().equals("editCourse")) {
            editCourse();
//            save();
        } else if (evt.getActionCommand().equals("editStudent")) {
            editStudent();
//            save();
        } else if (evt.getActionCommand().equals("editDeliverable")) {
            editDeliverable();
//            save();
        } else if (evt.getActionCommand().equals("courseList")) {
            courseList();
//            save();
        } else if (evt.getActionCommand().equals("studentList")) {
            studentList();
//            save();
        } else if (evt.getActionCommand().equals("deliverableList")) {
            deliverableList();
//            save();
            
        } else if (evt.getActionCommand().equals("deleteCourse")){
        	deleteCourse();
        } else if (evt.getActionCommand().equals("deleteStudent")){
        	deleteStudent();
        } else if (evt.getActionCommand().equals("deleteDeliverable")) {
        	deleteDeliverable();
        }
        else if (evt.getActionCommand().equals("openGradeWindow")) {
            openGradeWindow(activeCourse);
        }
  }
}