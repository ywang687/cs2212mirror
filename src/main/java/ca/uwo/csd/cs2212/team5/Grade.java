package ca.uwo.csd.cs2212.team5;

/**
 * A class that represents a Grade in a gradebook application
 */
public class Grade {
	
	double grade;

	/**
	 * Constructs a new Grade object
	 * @param x the grade value
	 */
	public Grade(double x){
		this.grade=x;
	}
	
	/**
	 * Sets the value of a grade
	 * @param x the new value for the grade
	 */
	private void setGrade(double x){
		this.grade = x;
	}

}
