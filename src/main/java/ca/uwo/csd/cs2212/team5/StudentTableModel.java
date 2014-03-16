package ca.uwo.csd.cs2212.team5;
 
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
 
public class StudentTableModel extends AbstractTableModel {
 
    private final static int IDX_FIRST_NAME = 0;
    private final static int IDX_LAST_NAME = 1;
     
    private final List<Student> students;
    private Course activeCourse;
 
    /*
     * Constructor
     */
    public StudentTableModel(Course activeCourse) {
        students = new ArrayList<Student>();
        this.activeCourse=activeCourse;
    }
    
    /**
     * Adds a student to the table model
     * @param c the student to add to the table model
     */
    public void addStudent(Student c){
        this.students.add(c);
        
    }
    
    /**
     * Returns the list of students in the table model
     * @return the list of students
     */
    public List<Student> getStudents() {
        return students;
    }
    
    @Override
    public int getRowCount() {
        return students.size();
    }
 
    @Override
    public int getColumnCount() {
    	
           int a=this.activeCourse.getNumDeliverables();
           return a+2;
    	
    }
    
    @Override
    public String getColumnName(int columnIndex) {
    	 if ((columnIndex < 0))
             return null;
         else{
         	 if(columnIndex==IDX_FIRST_NAME) {
                  return "First Name";}
         	 else if(columnIndex==IDX_LAST_NAME){
                  return "Last Name";}
         	 else if(columnIndex>IDX_LAST_NAME){
         	
         		 return this.activeCourse.getDeliverables().get(columnIndex-2).getName();
         	 }
         	 else{
                  return null; 
              }
          }
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex==0 || columnIndex==1){
        	return String.class;
        }
        else{
        	return Double.class;
        }
    }
    
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if ((rowIndex < 0) || (rowIndex >= students.size()))
            return null;
        else{
        	Student s=this.activeCourse.getStudents().get(rowIndex);
        	 if(columnIndex==IDX_FIRST_NAME) {
                 return s.getFirstName();}
        	 else if(columnIndex==IDX_LAST_NAME){
                 return s.getLastName();}
        	 else if(columnIndex>IDX_LAST_NAME){
        		 try{
        		 Double d = s.getGrade(columnIndex-2);
        	     return d.toString();
        		 }
        		 catch(NullPointerException e){
        			 return " ";
        		 }
    	 }
        	 else
        		 return " ";
         }
    }
   
   @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
       //if the column Index represents a student's first or last name
	   if ((rowIndex < 0) || (rowIndex >= students.size()))
            return;

       else{
            Student c=this.activeCourse.getStudents().get(rowIndex);
            //if the column index represents a deliverable
              if(columnIndex>1){
               //change the grade of the student who is represented in that row and update the cell
               Double d=Double.valueOf(aValue.toString());
               c.editGrade(d, columnIndex-2);
               fireTableCellUpdated(rowIndex, columnIndex); 
            
              }
        }
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
       //if the column represents grades for a deliverable set true
       if(columnIndex>1)return true;
       else return false;
    }
 
}