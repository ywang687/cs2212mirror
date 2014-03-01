
package ca.uwo.csd.cs2212.team5;

import java.util.*;
/**
 * Course is a class that will be used to add a course in a gradebook application
 *
 */
public class Course
{
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
* Constructs a new Course object.
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

/**
 * Adds a new student to the list of students in a course
 * @param newStudent the new student to add 
 */
public void addStudent(Student newStudent){
	this.students.add(newStudent);
}

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
 * Returns an iterator containing all students
 * @return an iterator for the list of students
 */
public ArrayList<Student> getStudents(){
	return this.students;
}

/**
 * Adds a deliverable to a course
 * @param d the deliverable to add
 */
public void addDeliverable(Deliverable d){
	this.deliverables.add(d);
}

/**
 * Returns an ArrayList containing the deliverables for a course
 * @return
 */
public ArrayList<Deliverable> getDeliverables(){
	return this.deliverables;
}

/** 
 * Returns the course title
 * @return the title of the course */
public String getTitle()
{
	return this.title;
}

/**
* Returns the course code
* @return the code of the course */
public String getCode()
{
	return this.code;
}

/**
* Returns the course term
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

}