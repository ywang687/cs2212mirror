package ca.uwo.csd.cs2212.team5;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;


/*
 * the unit test for Student Class
 */
public class StudentTest {

  private Student student;

  //creat a test student object before each test
  @Before
  public void createStudent(){
	this.student = new Student("first","last","12345678","test@example.com");
  }

  //test whether the first name getter gets the correct first name or not
  @Test
  public void testGetFirstName() {
	Assert.assertEquals("first",student.getFirstName());
  }

  //test whether the last name getter gets the correct last name or not
  @Test
  public void testGetLastName() {
        Assert.assertEquals("last",student.getLastName());
  }

  //test whether the student number getter gets the correct student number or not
  @Test
  public void testGetNumber() {
	Assert.assertEquals("12345678",student.getNumber());
  }

  //test whether the email getter gets the correct email or not
  @Test
  public void testGetEmailAddress() {
	Assert.assertEquals("test@example.com",student.getEmailAddress());
  }

  //give the student a new first name and use the getter to test it
  @Test
  public void testSetFirstName() {
	student.setFirstName("testFirst");
	Assert.assertEquals("testFirst",student.getFirstName());
  }


  //give the student a new last name and use the getter to test it
  @Test
  public void testSetLasetName() {
	student.setLastName("testLast");
	Assert.assertEquals("testLast",student.getLastName());
  }

  //give the student a new student number and use the getter to test it
  @Test
  public void testSetNumber() {
	student.setNumber("87654321");
	Assert.assertEquals("87654321",student.getNumber());
  }
  
  //give the student a new email address and use the getter to test it
  @Test
  public void testSetEmailAddress() {
	student.setEmailAddress("example@test.com");
	Assert.assertEquals("example@test.com",student.getEmailAddress());
  }

  //test whether the grade getter gets the correct grade or not
  @Test
  public void testGetGrade() {
	Assert.assertNull(student.getGrade(0));
  }

  //add a new grade to the student and then use the getter to test it in case
  //of the grade list does not expand
  @Test
  public void testAddGradeWithoutExpanding() {
	student.addGrade(20.1);
	Assert.assertEquals((Double)20.1,(Double)student.getGrade(0));
  }
  
  //add new grades to the student so that the grade list expands
  //and then use the getter to test it in case
  @Test
  public void testAddGradeWithExpanding() {
	student.addGrade(20.1);
	student.addGrade(89.2);
	student.addGrade(78.9);
	student.addGrade(67.8);
	student.addGrade(54.5);
	student.addGrade(34.2);
	student.addGrade(12.4);
	student.addGrade(24.5);
	student.addGrade(22.3);
	student.addGrade(21.2);
	student.addGrade(33.3);
	Assert.assertEquals((Double)33.3,(Double)student.getGrade(10));
  }

  
  //edit the grade to the student and then use the getter to test it
  @Test
  public void testEditGrade() {
	student.editGrade(30.1,0);
	Assert.assertEquals((Double)30.1,(Double)student.getGrade(0));
  }  

  //use the same student to test the compareTo method
  //@return true
  @Test
  public void testTrueCompareTo() {
	Assert.assertEquals(0,student.compareTo(student));
  }

  //use different students to test the compareTo method
  //@return false
  @Test
  public void testFalseCompareTo() {
	Student comp = new Student("test","test","000","example@test.com");
	Assert.assertTrue(0!=student.compareTo(comp));
  }

  //use a given string to test the stringRepresentation method
  @Test
  public void testStringRepresentation() {
 	Assert.assertEquals("first last 12345678 test@example.com", student.stringRepresentation());
  }

  //use a student without any grades to test the getNumGrade method
  @Test
  public void testGetNumGrades() {
	Assert.assertEquals(0,student.getNumGrades());
  }

  //add many enough grades to the student to test the expandGradeList method
  @Test
  public void testExpandGradeList() {
	student.addGrade(20.1);
	student.addGrade(89.2);
	student.addGrade(78.9);
	student.addGrade(67.8);
	student.addGrade(54.5);
	student.addGrade(34.2);
	student.addGrade(12.4);
	student.addGrade(24.5);
	student.addGrade(22.3);
	student.addGrade(21.2);
	student.addGrade(33.3);
	Assert.assertEquals(11,student.getNumGrades());
  
  }

}

