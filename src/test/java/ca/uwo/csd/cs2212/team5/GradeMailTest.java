package ca.uwo.csd.cs2212.team5;

import static org.junit.Assert.*;

import org.junit.runner.JUnitCore;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

import ca.uwo.csd.cs2212.team5.GradeMail;


public class GradeMailTest {

	@Test
	public void emptyEmailTest() throws Exception {
		String [] empty = new String [0];
		Boolean b = GradeMail.sendEmail(empty);
		Assert.assertEquals(false,b);
	}

	@Test
	public void oneEmailTest()throws Exception {
		String [] one = {"gradebookteam5@example.com"};
		Boolean b = GradeMail.sendEmail(one);
		Assert.assertEquals(true,b);
	}

	@Test
	public void severalEmailTest()throws Exception {
		String [] several = {"gradebookteam5@example.com","gradebookteam5@example.com","gradebookteam5@example.com","gradebookteam5@example.com","gradebookteam5@example.com","gradebookteam5@example.com"};
		Boolean b = GradeMail.sendEmail(several);
		Assert.assertEquals(true,b);
	}


}