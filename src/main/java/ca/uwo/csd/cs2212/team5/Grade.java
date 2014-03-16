package ca.uwo.csd.cs2212.team5;

/**
 * Grade class represents a student's grade in a grade book application
 *
 */
public class Grade implements java.io.Serializable{
	
	private static final long serialVersionUID = 1963245831664970835L;
	Double grade;

	/**
	 * Sets the mark of a grade
	 * @param x the double to set the grade to
	 */
	private void setGrade(Double x){
		grade = x;
	}

}
