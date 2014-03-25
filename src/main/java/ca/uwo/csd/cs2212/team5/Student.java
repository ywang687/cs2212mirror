package ca.uwo.csd.cs2212.team5;

/**
 *
 * @author yuwei
 *
 */
public class Student implements java.io.Serializable, Comparable{
	/**
	 *
	 */
	private static final long serialVersionUID = -980046860904744892L;
	private String firstName;
	private String lastName;
	private String number;
	private String emailAddress;
	private Double [] gradeList;
	private int numGrades;

	public static void main (String[] args) {

	}


	/**
	 * constructor method for student
	 * @param firstName
	 * @param lastName
	 * @param number
	 * @param emailAddress
	 */
	public Student(String firstName, String lastName, String number, String emailAddress){
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.emailAddress = emailAddress;
		numGrades = 0;
		gradeList = new Double [10];
	}

	/**
	 * Adds a grade to a students grade list
	 * @param grade the grade to add
	 */
	public void addGrade(Double grade){
		//Determine if there is room for the new grade and if not, expand the array
		System.out.println("Student Name: " + firstName + "Numgrades: " + numGrades + "Gradelist length " + gradeList.length);
		if (numGrades == gradeList.length)
			expandGradeList();

		//Insert the grade
		this.gradeList[numGrades] = grade;
		numGrades++;
	}

	/**
	 * returns the grade of a specific deliverable of this student
	 * @param deliverableNumber The deliverable selected to be retrieved
	 * @return gradeList[deliverableNumber]
	 */
	public Double getGrade(int deliverableNumber){
		return gradeList[deliverableNumber];
	}

	public int getNumGrades(){
		return this.numGrades;
	}
	/**
	 * Edits a selected deliverable's grade with the new data
	 * @param grade new grade for this deliverable
	 * @param deliverableNumber The deliverable whose grade will be edited
	 */
	public void editGrade(Double grade, int deliverableNumber){
		gradeList[deliverableNumber] = grade;
	}

	/**
	 *returns a String representation of the Student's data
	 *@return
	 */
	public String stringRepresentation(){
		return getFirstName() + " " + getLastName() + " " + getNumber() + " " + getEmailAddress();
	}

	/**
	 * gets first name
	 * @return
	 */
	public String getFirstName(){
		return firstName;
	}

	/**
	 * gets last name
	 * @return
	 */
	public String getLastName(){
		return lastName;
	}

	/**
	 * gets student number
	 * @return
	 */
	public String getNumber(){
		return number;
	}

	/**
	 * gets email address
	 * @return
	 */
	public String getEmailAddress(){
		return emailAddress;
	}

	/**
	 * sets first name
	 * @param firstName
	 */
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	/**
	 * sets last name
	 * @param lastName
	 */
	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	/**
	 * sets student number
	 * @param number
	 */
	public void setNumber(String number){
		this.number = number;
	}

	/**
	 * sets email address
	 * @param emailAddress
	 */
	public void setEmailAddress(String emailAddress){
		this.emailAddress = emailAddress;
	}

	/**
	 * A method that expands the gradeList to make room for more deliverables
	 */
	private void expandGradeList(){
		//Create an array with twice the capacity
		Double [] newList = new Double [gradeList.length*2];

		//Move all the information of the old array into the new one
		for(int x = 0; x < gradeList.length; x++)
			newList[x] = gradeList[x];

		//Point to the new array
		gradeList = newList;
	}
	
	@Override
	public int compareTo(Object o) {
		Student tmp = (Student)o;
		String compare1 = this.getLastName() + " " + this.getFirstName() + " " + this.getNumber() + " " + this.getEmailAddress();
		String compare2 = tmp.getLastName() + " " + tmp.getFirstName() + " " + tmp.getNumber() + " " + tmp.getEmailAddress();
		return compare1.compareTo(compare2);
	}
}
