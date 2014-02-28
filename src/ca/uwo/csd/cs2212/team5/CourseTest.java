package ca.uwo.csd.cs2212.team5;

import static org.junit.Assert.*;
import ca.uwo.csd.cs2212.team5.Course;
import ca.uwo.csd.cs2212.team5.Student;

import org.junit.Test;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class CourseTest {
 
	private Course course;
	
	@Before
	public void createCourse(){
		this.course=new Course("title", "1000", "1", true);
	}
	
	@Test
	public void testModifyCourseTitle() {
		course.setTitle("new title");
		Boolean b=(course.getTitle()=="new title");
		Assert.assertEquals(true, b);
	}
	
	@Test
	public void testModifyCourseCode() {
		course.setCode("1000");
		Boolean b=(course.getCode()=="1000");
		Assert.assertEquals(true, b);
	}
	
	@Test
	public void testModifyCourseTerm() {
		course.setTerm("1");
		Boolean b=(course.getTerm()=="1");
		Assert.assertEquals(true, b);
	}
	@Test
	public void testSetActiveCourse() {
		course.setIsActive(false);
		Boolean b=(course.isActive()==false);
		Assert.assertEquals(true, b);
	}
	
	@Test
	public void testAddStudents(){
		Student s=new Student("Jane","Doe","250555555","jdoe@uwo.ca");
		Student t=new Student("John","Doe","250555556","jdoe1@uwo.ca");
		course.addStudent(s);
		course.addStudent(t);
		Boolean b=(course.getStudent("250555555")==null);
		Assert.assertEquals(false, b);
	}
}
