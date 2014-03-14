package ca.uwo.csd.cs2212.team5;
 
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
 
public class StudentTableModel extends AbstractTableModel {
 
    private final static int COLUMN_COUNT = 5;
    private final static int IDX_FIRST_NAME = 0;
    private final static int IDX_LAST_NAME = 1;
    private final static int DEL_1 = 2;
    private final static int DEL_2 = 3;
    private final static int DEL_3 = 4;
    
    private final List<Student> students;
 
    public void addStudent(Student c){
        this.students.add(c);
    }
    
    public StudentTableModel() {
        students = new ArrayList<Student>();
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
        return COLUMN_COUNT;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case IDX_FIRST_NAME:
                return "First Name";
            case IDX_LAST_NAME:
                return "Last Name";
            case DEL_1:
                return "Deliverable 1";
            case DEL_2:
                return "Deliverable 2";
            case DEL_3:
                return "Deliverable 3";
            default:
                return null;            
        }
    }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if ((rowIndex < 0) || (rowIndex >= students.size()))
            return null;
        else{
        	Student s=this.students.get(rowIndex);
        	 switch (columnIndex) {
        	 
             case IDX_FIRST_NAME:
                 return s.getFirstName();
             case IDX_LAST_NAME:
                 return s.getLastName();
             case DEL_1:
                 return "";
             case DEL_2:
                 return "";
             case DEL_3:
                 return "";
             default:
                 return null; 
             }
         }
    }
    
   /* @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if ((rowIndex < 0) || (rowIndex >= students.size()))
            return;

            else{
            Student c=students.get(rowIndex);
            if(columnIndex>1){
               fireTableCellUpdated(rowIndex, columnIndex);
            
            }
        }

     
    }*/
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
       return true;
    }
 
}