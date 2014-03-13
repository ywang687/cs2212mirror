package ca.uwo.csd.cs2212.team5;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

public class DeliverableTest {

  private Deliverable deliverable;

  @Before
  public void createDeliverable(){
	this.deliverable = new Deliverable("testDeliverable","test",11.17);

  }

  @Test
  public void testSStringRepresentation(){
	Assert.assertEquals("testDeliverable - test - 11.17",deliverable.stringRepresentation());
  }

  @Test
  public void testGetName(){
	Assert.assertEquals("testDeliverable",deliverable.getName());
  }
  
  @Test
  public void testGetWeight(){
	Assert.assertEquals(11.17,deliverable.getWeight(),0.01);
  }

  @Test
  public void testGetType(){
	Assert.assertEquals("test",deliverable.getType());
  }

  @Test
  public void testSetName(){
	deliverable.setName("testSetName");
	Assert.assertEquals("testSetName",deliverable.getName());
  }

  @Test
  public void testSetWeight(){
	deliverable.setWeight(32.6);
	Assert.assertEquals(32.6,deliverable.getWeight(),0.01);
  }

  @Test
  public void testSetType(){
	deliverable.setType("testSetType");
	Assert.assertEquals("testSetType",deliverable.getType());
  }

  @Test
  public void testDelete(){
	deliverable.delete();
	Assert.assertNull(deliverable.getName());
	Assert.assertNull(deliverable.getType());
	Assert.assertNull(deliverable.getType());
  }

}
