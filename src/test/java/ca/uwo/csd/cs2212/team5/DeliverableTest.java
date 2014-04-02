package ca.uwo.csd.cs2212.team5;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;


/*
 * the unit test for Deliverable Class
 */
public class DeliverableTest {

  private Deliverable deliverable;

   //creat a test deliberable object before each test
  @Before
  public void createDeliverable(){
	this.deliverable = new Deliverable("testDeliverable","test",11.17);

  }

  //use a given string to test the stringRepresentation method
  @Test
  public void testStringRepresentation(){
	Assert.assertEquals("testDeliverable - test - 11.17",deliverable.stringRepresentation());
  }

  //test whether the name getter gets the correct name or not
  @Test
  public void testGetName(){
	Assert.assertEquals("testDeliverable",deliverable.getName());
  }
  
  //test whether the weight getter gets the correct weight or not
  @Test
  public void testGetWeight(){
	Assert.assertEquals(11.17,deliverable.getWeight(),0.01);
  }

  //test whether the type getter gets the correct type or not
  @Test
  public void testGetType(){
	Assert.assertEquals("test",deliverable.getType());
  }

  //give the deliverable a new name and use the getter to test it
  @Test
  public void testSetName(){
	deliverable.setName("testSetName");
	Assert.assertEquals("testSetName",deliverable.getName());
  }

  //give the deliverable a new weight and use the getter to test it
  @Test
  public void testSetWeight(){
	deliverable.setWeight(32.6);
	Assert.assertEquals(32.6,deliverable.getWeight(),0.01);
  }

  //give the deliverable a new type and use the getter to test it
  @Test
  public void testSetType(){
	deliverable.setType("testSetType");
	Assert.assertEquals("testSetType",deliverable.getType());
  }

  //delete the deliverable to test whether all the properties are set to null
  @Test
  public void testDelete(){
	deliverable.delete();
	Assert.assertNull(deliverable.getName());
	Assert.assertNull(deliverable.getType());
	Assert.assertNull(deliverable.getType());
  }

  //use the same deliverable to test the compareTo method
  //@return true
  @Test
  public void testTrueCompareTo() {
	Assert.assertEquals(0,deliverable.compareTo(deliverable));
  }

  //use different deliverables to test the compareTo method
  //@return false
  @Test
  public void testFalseCompareTo(){
  	Deliverable comp = new Deliverable("compDeliverable","comp",15.2);
	Assert.assertTrue(0!=deliverable.compareTo(comp));
  }

}
