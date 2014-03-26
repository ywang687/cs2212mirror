package ca.uwo.csd.cs2212.team5;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

public class StudentTest {

  private Student student;

  @Before
  public void createStudent(){
	this.student = new Student("first","last","12345678","test@example.com");
  }

  @Test
  public void testGetFirstName() {
	Assert.assertEquals("first",student.getFirstName());
  }

  @Test
  public void testGetLastName() {
        Assert.assertEquals("last",student.getLastName());
  }

  @Test
  public void testGetNumber() {
	Assert.assertEquals("12345678",student.getNumber());
  }

  @Test
  public void testGetEmailAddress() {
	Assert.assertEquals("test@example.com",student.getEmailAddress());
  }

  @Test
  public void testSetFirstName() {
	student.setFirstName("testFirst");
	Assert.assertEquals("testFirst",student.getFirstName());
  }


  @Test
  public void testSetLasetName() {
	student.setLastName("testLast");
	Assert.assertEquals("testLast",student.getLastName());
  }

  @Test
  public void testSetNumber() {
	student.setNumber("87654321");
	Assert.assertEquals("87654321",student.getNumber());
  }

  @Test
  public void testSetEmailAddress() {
	student.setEmailAddress("example@test.com");
	Assert.assertEquals("example@test.com",student.getEmailAddress());
  }

  @Test
  public void testGetGrade() {
	Assert.assertNull(student.getGrade(0));
  }

  @Test
  public void testAddGradeWithoutExpanding() {
	student.addGrade(20.1);
	Assert.assertEquals((Double)20.1,(Double)student.getGrade(0));
  }
  
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


  @Test
  public void testEditGrade() {
	student.editGrade(30.1,0);
	Assert.assertEquals((Double)30.1,(Double)student.getGrade(0));
  }  

  @Test
  public void testTrueCompareTo() {
	Assert.assertEquals(0,student.compareTo(student));
  }

  @Test
  public void testFalseCompareTo() {
	Student comp = new Student("test","test","000","example@test.com");
	Assert.assertTrue(0!=student.compareTo(comp));
  }

  @Test
  public void testStringRepresentation() {
 	Assert.assertEquals("first last 12345678 test@example.com", student.stringRepresentation());
  }

  @Test
  public void testGetNumGrades() {
	Assert.assertEquals(0,student.getNumGrades());
  }

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

