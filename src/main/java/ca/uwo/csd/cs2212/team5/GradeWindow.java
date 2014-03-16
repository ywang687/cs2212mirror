package ca.uwo.csd.cs2212.team5;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
 
/**
 *Grade Window class represents a window with a spreadsheet for viewing and editing student grades
 *for the active course in a grade book application
 */
public class GradeWindow extends JFrame {
 
    private JButton btnGetSelection; //button to get selected student info
    private JTable tblStudents; //spreadsheet showing student grades
    private JTextArea txtOutput;//output box for viewing info of selected students
    private ArrayList < Student > studentList; //list of students
    private Course activeCourse; //active course
  
 /*
  * Constructor
  */
    public GradeWindow(Course activeCourse) {
        this.studentList=activeCourse.getStudents();
        this.activeCourse=activeCourse;
    	initComponents();
        initTable();
    }
    
    /**
     * Returns an iterator of the student list
     * @return an iterator of the list of students
     */
    private Iterator<Student> getStudents(){
    	return this.studentList.iterator();
    }
             
    /**
     * Initializes components in the window
     */
    private void initComponents() {
 
        JPanel pnlOutput = new JPanel();
        JScrollPane scrOutput = new JScrollPane();
        JPanel pnlTable = new JPanel();
        JScrollPane scrTable = new JScrollPane();
        JToolBar toolBar = new JToolBar();
 
        btnGetSelection = new JButton();
        tblStudents = new JTable();
        txtOutput = new JTextArea();
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
 
        pnlOutput.setBorder(BorderFactory.createTitledBorder("Output"));
        pnlOutput.setLayout(new BorderLayout());
 
        txtOutput.setColumns(20);
        txtOutput.setRows(8);
        scrOutput.setViewportView(txtOutput);
 
        pnlOutput.add(scrOutput, BorderLayout.CENTER);
 
        getContentPane().add(pnlOutput, BorderLayout.SOUTH);
        pnlOutput.getAccessibleContext().setAccessibleDescription("");
 
        pnlTable.setBorder(BorderFactory.createTitledBorder("Student Data"));
        pnlTable.setLayout(new BorderLayout());
 
        scrTable.setViewportView(tblStudents);
 
        pnlTable.add(scrTable, BorderLayout.CENTER);
 
        getContentPane().add(pnlTable, BorderLayout.CENTER);
 
        toolBar.setRollover(true);
 
        btnGetSelection.setText("Get Selection");
        btnGetSelection.setFocusable(false);
        btnGetSelection.setHorizontalTextPosition(SwingConstants.CENTER);
        btnGetSelection.setVerticalTextPosition(SwingConstants.BOTTOM);
 
        toolBar.add(btnGetSelection);
 
        getContentPane().add(toolBar, BorderLayout.NORTH);
 
        pack();
    }        
   
    /**
     * Initializes the grade spreadsheet
     */
    private void initTable(){
        initModel();
        setColumnWidths();
        tblStudents.setAutoCreateRowSorter(true);
        tblStudents.setCellSelectionEnabled(true);
        tblStudents.setDefaultRenderer(Double.class, new DoubleCellRenderer());
        tblStudents.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "startEditing");

        this.btnGetSelection.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                        StringBuilder sb = new StringBuilder();
                        int[] selectedRows = tblStudents.getSelectedRows();

                        sb.append("Selected students:\n");

                        for (int row : selectedRows) {
                             String firstName = tblStudents.getModel().getValueAt(row, 0).toString();
                             String lastName = tblStudents.getModel().getValueAt(row, 1).toString();
                             sb.append(firstName).append(" ").append(lastName).append("\n");
                        }
                      txtOutput.setText(txtOutput.getText() + "\n" + sb.toString()); }
        });
    }
    
    /**
     * Initializes the student table model
     */
    private void initModel(){
       Iterator<Student> iter=this.getStudents();
       Student s;
       StudentTableModel model=new StudentTableModel(this.activeCourse);
       while(iter.hasNext()){
    	   s=iter.next();
    	   System.out.println(s.getFirstName());
    	   model.addStudent(s);
       }
    	
   tblStudents.setModel(model);
}

  /**
   * Sets column widths    
   */
   private void setColumnWidths(){
	   while(tblStudents.getColumnModel().getColumnCount()<(this.activeCourse.getNumDeliverables()+2)){
		  tblStudents.addColumn(new TableColumn()); 
	   }
       tblStudents.getColumnModel().getColumn(0).setPreferredWidth(40);
       tblStudents.getColumnModel().getColumn(1).setPreferredWidth(40);
       
       for(int i=2;i<(activeCourse.getNumDeliverables()+2);i++){
           tblStudents.getColumnModel().getColumn(i).setPreferredWidth(50);
        }
   }
}
