package ca.uwo.csd.cs2212.team5;

/**
 *
 * @author yuwei
 *
 */
public class Student implements java.io.Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = -980046860904744892L;
	private String firstName;
	private String lastName;
	private String number;
	private String emailAddress;

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
	}

	/**
	 *returns a String representation of the Student's data
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
}
