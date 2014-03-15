package ca.uwo.csd.cs2212.team5;
 
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
 
public class StudentTableModel extends AbstractTableModel {
 
    private final static int IDX_FIRST_NAME = 0;
    private final static int IDX_LAST_NAME = 1;
     
    private final List<Student> students;
    private Course activeCourse;
 
    public StudentTableModel(Course activeCourse) {
        students = new ArrayList<Student>();
        this.activeCourse=activeCourse;
    }
    
    public void addStudent(Student c){
        this.students.add(c);
        
    }
    
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
        	Student s=this.students.get(rowIndex);
        	 if(columnIndex==IDX_FIRST_NAME) {
                 return s.getFirstName();}
        	 else if(columnIndex==IDX_LAST_NAME){
                 return s.getLastName();}
        	 else if(columnIndex>IDX_LAST_NAME){
        		 try{
        		 Double d = s.getGrade(columnIndex);
        		 if(!d.equals(200.0))
        			 return d.toString();
        		 else
        			 return " ";
        		 }
        		 catch(NullPointerException e){
        			 return " ";
        		 }
        	  }
        	 else{
                 return null; 
             }
         }
    }
   
   @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if ((rowIndex < 0) || (rowIndex >= students.size()))
            return;

            else{
            Student c=students.get(rowIndex);
            if(columnIndex>1){
              try{
               Double d=Double.valueOf(aValue.toString());
               c.editGrade(d, columnIndex-2);
               fireTableCellUpdated(rowIndex, columnIndex);
              }
              catch(NullPointerException e){
            	  try{
            	  Double d=Double.valueOf(aValue.toString());
            	  c.addGrade(d);
                  fireTableCellUpdated(rowIndex, columnIndex);
            	  }
            	  catch(NullPointerException e2){
            		  System.out.println("Your program sucks...");
            	  }
              }
            }
        }
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
       if(columnIndex>1)return true;
       else return false;
    }
 
}