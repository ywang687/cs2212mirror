
package ca.uwo.csd.cs2212.team5;

import java.util.*;
/**
 * Course is a class that will be used to add a course in a gradebook application
 * @author mgurnett
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
}

public void addStudent(Student newStudent){
	this.students.add(newStudent);
}

public Student getStudent(String studentNumber){
	Student found=NULL;
	Iterator<Student> iter=this.students.iterator();
	while(iter.hasNext()){
	   Student s=iter.next();
	   if(s.getNumber().equals(studentNumber)){
		   found=s;
	   }   
	}
	return found;
}

/************************************************************* * Accessor Methods *************************************************************/
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
}