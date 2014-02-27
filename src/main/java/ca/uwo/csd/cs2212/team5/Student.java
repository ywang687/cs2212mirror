package cs2212;

/**
 * 
 * @author yuwei
 *
 */
public class Student {
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
