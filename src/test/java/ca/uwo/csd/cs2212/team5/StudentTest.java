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
}
