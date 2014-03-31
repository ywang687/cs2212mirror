package ca.uwo.csd.cs2212.team5;

import static org.junit.Assert.*;

import org.junit.runner.JUnitCore; 
import java.util.ArrayList;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

import ca.uwo.csd.cs2212.team5.Course;
import ca.uwo.csd.cs2212.team5.Deliverable;
import ca.uwo.csd.cs2212.team5.Student;

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
	
	@Test
	public void testHasStudentNumber(){
		Student s=new Student("Jane","Doe","250555555","jdoe@uwo.ca");
		course.addStudent(s);
		Boolean b=course.hasStudentNumber("250555555");
		Assert.assertEquals(true, b);
	}
	
	@Test
	public void testHasStudentEmail(){
        Student s=new Student("Jane","Doe","250555555","jdoe1@uwo.ca");	
		course.addStudent(s);
		Boolean b=course.hasStudentEmail("jdoe1@uwo.ca");
		Assert.assertEquals(true, b);
	}
	
	@Test
	public void testDeleteStudent(){
		Student s=new Student("Jane","Doe","250555555","jdoe@uwo.ca");	
	    course.addStudent(s);
		course.deleteStudent(s);
		Boolean b=(course.getStudent("250555555")==null);
		Assert.assertEquals(true, b);
	}
	
	@Test
	public void testStringRepresentation(){
		String s = course.stringRepresentation();
		Boolean b = (s.equals("title - 1000 - 1"));
		Assert.assertEquals(true, b);
	}
	
	@Test
	public void testAddDeliverable(){
		Deliverable d= new Deliverable("test", "exam" , 0.5);
		course.addDeliverable(d);
	    Boolean b=(course.getDeliverable(0).getName().equals("test") && course.getNumDeliverables()==1);
	    Assert.assertEquals(true,b);
	}
	
	@Test
	public void testDeleteDeliverable(){
		Deliverable d= new Deliverable("test", "exam" , 0.5);
		course.addDeliverable(d);
		course.deleteDeliverable(d);
		Boolean b=(course.getDeliverable(0)==null);
		Assert.assertEquals(true, b);
	}
	
	@Test
	public void testOrder(){
		Student a=new Student("A","A","1","A@uwo.ca");
		Student b=new Student("B","B","2","B@uwo.ca");
		Student c=new Student("C","C","3","C@uwo.ca");
		Student d=new Student("D","D","4","D@uwo.ca");
		Deliverable e=new Deliverable("X","exam", 0.1);
		Deliverable f=new Deliverable("Y","exam", 0.1);
		Deliverable g=new Deliverable("Z","exam", 0.1);
		course.addStudent(d);
		course.addStudent(b);
		course.addStudent(c);
		course.addStudent(a);
		course.addDeliverable(f);
		course.addDeliverable(g);
		course.addDeliverable(e);
		course.order();
		ArrayList<Deliverable> listD=course.getDeliverables();
		ArrayList<Student> listS=course.getStudents();
		Boolean test=( listD.get(0).getName().equals("X") && listS.get(0).getFirstName().equals("A")
				&& listD.get(1).getName().equals("Y") && listS.get(1).getFirstName().equals("B")
				&& listD.get(2).getName().equals("Z") && listS.get(2).getFirstName().equals("C"));
		Assert.assertEquals(true,test);
	
	}
	
	@Test
	public void testCompareObject(){
		Course course2=new Course("title", "1000", "1", false);
		int a= course.compareTo(course2);
		Assert.assertEquals(0, a);
	}
	
	@Test
	public void testWeightedAverage(){
		Student a=new Student("A","A","1","A@uwo.ca");
		course.addStudent(s);
		s.addGrade(30.0);
		s.addGrade(60.0);
		s.addGrade(90.0);
		Double d=course.getWeightedAverage(s);
		Assert.assertEquals(60.0,d);
	}
	
	
	
}
