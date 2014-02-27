package cs2212;

/**
 * 
 * @author yuwei
 *
 */
public class Student {
	private char firstName;
	private char lastName;
	private char number;
	private char emailAddress;
	
	public static void main (String[] args) {
		
	}
	
	
	/**
	 * constructor method for student
	 * @param firstName
	 * @param lastName
	 * @param number
	 * @param emailAddress
	 */
	public Student(char firstName, char lastName, char number, char emailAddress){
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.emailAddress = emailAddress;
	}
	
	/**
	 * gets first name
	 * @return
	 */
	public char getFirstName(){
		return firstName;
	}
	
	/**
	 * gets last name
	 * @return
	 */
	public char getLastName(){
		return lastName;
	}
	
	/**
	 * gets student number
	 * @return
	 */
	public char getNumber(){
		return number;
	}
	
	/**
	 * gets email address
	 * @return
	 */
	public char getEmailAddress(){
		return emailAddress;
	}
	
	/**
	 * sets first name 
	 * @param firstName
	 */
	public void setFirstName(char firstName){
		this.firstName = firstName;
	}
	
	/**
	 * sets last name
	 * @param lastName
	 */
	public void setLastName(char lastName){
		this.lastName = lastName;
	}
	
	/**
	 * sets student number
	 * @param number
	 */
	public void setNumber(char number){
		this.number = number;
	}
	
	/**
	 * sets email address
	 * @param emailAddress
	 */
	public void setEmailAddress(char emailAddress){
		this.emailAddress = emailAddress;
	}
}
