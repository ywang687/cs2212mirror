package ca.uwo.csd.cs2212.team5;

import java.util.*;

/**
 *A class that represents a student in a gradebook application
 *
 */
public class Student {
	private String firstName;//the students first name
	private String lastName;//the students last name
	private String number;//the students id number
	private String emailAddress;//the students email address
	private ArrayList<Course> courses;//the courses a student is enrolled in

	public static void main (String[] args) {

	}

	/**
	 * Constructs a new Student object
	 * @param firstName the first name of the student
	 * @param lastName the last name of the student
	 * @param number the student number of the student
	 * @param emailAddress the email address of the student
	 */
	public Student(String firstName, String lastName, String number, String emailAddress){
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.emailAddress = emailAddress;
		this.courses=null;
	}

	/**
	 * Returns the first name of a student
	 * @return the first name of the student
	 */
	public String getFirstName(){
		return firstName;
	}

	/**
	 * Returns the last name of a student
	 * @return the last name of the student
	 */
	public String getLastName(){
		return lastName;
	}

	/**
	 * Returns the student number of a student
	 * @return the student number of a student
	 */
	public String getNumber(){
		return number;
	}

	/**
	 * Returns the email address of a student
	 * @return the email address of the student
	 */
	public String getEmailAddress(){
		return emailAddress;
	}

	/**
	 * Sets the first name of a student
	 * @param firstName the first name of the student
	 */
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	/**
	 * Sets the last name of a student
	 * @param lastName the last name of the student
	 */
	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	/**
	 * Sets the student number of a student
	 * @param number the student number of the student
	 */
	public void setNumber(String number){
		this.number = number;
	}

	/**
	 * Sets the email address of a student
	 * @param emailAddress the email address of the student
	 */
	public void setEmailAddress(String emailAddress){
		this.emailAddress = emailAddress;
	}
	
	/**
	 * Adds a course to the list of courses a student is enrolled in
	 * @param c the course to be added
	 */
	public void addToCourse(Course c){
		this.courses.add(c);
	}
}
