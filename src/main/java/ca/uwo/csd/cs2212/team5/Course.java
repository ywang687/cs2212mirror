
package ca.uwo.csd.cs2212.team5;

import java.util.*;
/**
 * Course is a class that will be used to add a course in a gradebook application
 *
 */
public class Course implements java.io.Serializable, Comparable
{

	private static final long serialVersionUID = -5938679076671064779L;
/************************************************************* * Instance Variables *************************************************************/
// The course title
private String title;
// The course code
private String code ;
// The course term
private String term;
// The course isActive label
private boolean isActive;
//The course list of students
private ArrayList<Student> students;
//The course list of deliverables
private ArrayList<Deliverable> deliverables;


/**
* Constructor.
* @param title Title
* @param c Code
* @param t Term
* @param act isActive
*/
public Course(String title, String c, String t, boolean act) {
	this.title=title;
	this.code=c;
	this.term=t;
	this.isActive=act;
	this.students=new ArrayList<Student>();
	this.deliverables= new ArrayList<Deliverable>();

}

public Double getWeightedAverage(Student s){
	Double d=0.0,c=0.0;
	for(int i=0;i<s.getNumGrades();i++){
		if(s.getGrade(i)!=null){
		   d+=(s.getGrade(i)*this.deliverables.get(i).getWeight());
		}
	}
	for(int j=0;j<s.getNumGrades();j++){
		if(s.getGrade(j)!=null){
		  c+=(this.deliverables.get(j).getWeight());
		}
	}
	return (d/c);
	
}

/**
 * returns true if a course contains a student with a student number equal to the passed string parameter
 * @param num the number you wish to check
 * @return true if a student exists in the course with that number
 */
public boolean hasStudentNumber(String num){
	Iterator<Student> iter=this.students.iterator();
	Boolean b=false;
	while(iter.hasNext()){
		Student s=iter.next();
		if(s.getNumber().equals(num)) b=true;
	}
	return b;
}

/**
 * returns true if a course contains a student with the given email address
 * @param email the email you wish to check
 * @return true if a student exists in the course with that number
 */
public boolean hasStudentEmail(String email){
	Iterator<Student> iter=this.students.iterator();
	Boolean b=false;
	while(iter.hasNext()){
		Student s=iter.next();
		if(s.getEmailAddress().equals(email)) b=true;
	}
	return b;
}


/**
 * Adds a new student to the list of students in a course
 * @param newStudent the new student to add
 */
public void addStudent(Student newStudent){
	this.students.add(newStudent);
}

/**
 * Deletes a given student from the course
 * @param student the student to be deleted
 * @return
 */
public Student deleteStudent(Student student) {
	this.students.remove(student);
	return student;
}

/**
 * Deletes a given deliverable from the course
 * @param deliverable the deliverable to be deleted
 * @return
 */
public Deliverable deleteDeliverable(Deliverable deliverable) {
	this.deliverables.remove(deliverable);
	return deliverable;
}

/**
 *Creates and returns a String representing this Course's data
 */
 public String stringRepresentation(){
 	return (new String(this.getTitle() + " - " + this.getCode() + " - " + this.getTerm()));
 }

/**
 * A method that returns an iterator containing all students
 * @return an iterator for the list of students
 */
public ArrayList<Student> getStudents(){
	return this.students;
}

/**
 * A method that adds a deliverable to a course
 * @param d the deliverable to add
 */
public void addDeliverable(Deliverable d){
	this.deliverables.add(d);
}

/**
 * Orders the deliverables and students in a course
 */
public void order() {
	Object[] tmpList = this.deliverables.toArray();
	Arrays.sort(tmpList);
	this.deliverables = new ArrayList<Deliverable>();
	for (Object tmp: tmpList) {
		this.deliverables.add((Deliverable)tmp);
	}
	
	tmpList = this.students.toArray();
	Arrays.sort(tmpList);
	this.students = new ArrayList<Student>();
	for (Object tmp: tmpList) {
		this.students.add((Student)tmp);
	}
	
}


//*******************************GETTER METHODS*************************************//
/**
 * Finds a student with a given student number
 * @param studentNumber the student to find
 * @return the student if it exists in the course
 */
 public Student getStudent(String studentNumber){
		Student found=null;
		Iterator<Student> iter=this.students.iterator();
		while(iter.hasNext()){
		   Student s=iter.next();
		   if(s.getNumber().equals(studentNumber)){
			   found=s;
		   }
		}
		return found;
	}

/**
 * A method that returns the deliverables for a course
 * @return an arrayList of the deliverables in the course so far
 */
public ArrayList<Deliverable> getDeliverables(){
	return this.deliverables;
}

/**
 * Returns a specific deliverable in a course
 * @param deliverableNumber the deliverable number to find
 * @return the deliverable object
 */
public Deliverable getDeliverable(int deliverableNumber){
	if(this.getNumDeliverables()>deliverableNumber){
	    return this.deliverables.get(deliverableNumber);
	}
	else{
		return null;
	}
}

/**
 * returns the current number of deliverables in the course
 * @return
 */
public int getNumDeliverables(){
	return this.deliverables.size();
}

/**
 * Gets the course title
 * @return the title of the course */
public String getTitle()
{
	return this.title;
}
/**
* Gets the course code
* @return the code of the course */
public String getCode()
{
	return this.code;
}
/**
* Gets the course term
* @return the term of the course */
public String getTerm()
{
	return this.term;
}
/**
* Returns true if the course is the active course
* @return true if the course is active */
public boolean isActive()
{
	return this.isActive;
}
/************************************************************* * Mutator Methods *************************************************************/
/**
* Sets the course title
* @param tle the new title of the course */
public void setTitle(String title)
{
	this.title=title;
}
/**
* Sets the course code
* @param c the code of the course */
public void setCode(String c)
{
    this.code=c;
}
/**
* Sets the course term
* @param t the term of the course */
public void setTerm(String t)
{
	this.term=t;
}
/**
* Sets the active course label
* @param act the active label for the course*/
public void setIsActive(boolean act)
{
	this.isActive=act;
}

@Override
public int compareTo(Object o) {
	Course tmp = (Course)o;
	String compare1 = this.getTitle() + " - " + this.getCode() + " - " + this.getTerm();
	String compare2 = tmp.getTitle() + " - " + tmp.getCode() + " - " + tmp.getTerm();
	return compare1.compareTo(compare2);
}


}