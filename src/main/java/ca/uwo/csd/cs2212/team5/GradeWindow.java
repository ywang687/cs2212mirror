package ca.uwo.csd.cs2212.team5;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
 
public class GradeWindow extends JFrame {
 
    private JButton btnGetSelection;
    private JTable tblStudents;
    private JTextArea txtOutput;
    private ArrayList < Student > studentList;
    private Course activeCourse;
  
 
    public GradeWindow(Course activeCourse) {
        this.studentList=activeCourse.getStudents();
        this.activeCourse=activeCourse;
    	initComponents();
        initTable();
    }
    
    private Iterator<Student> getStudents(){
    	return this.studentList.iterator();
    }
                         
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
   
    private void initTable(){
        initModel();
        setColumnWidths();
        tblStudents.setAutoCreateRowSorter(true);
        tblStudents.setCellSelectionEnabled(true);
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
