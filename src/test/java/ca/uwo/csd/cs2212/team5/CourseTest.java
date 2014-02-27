package ca.uwo.csd.cs2212.team5;

import static org.junit.Assert.*;

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

}
