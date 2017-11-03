package se.frihak.hfsim.spawner;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Rectangle;

import org.junit.Test;

public class RectangleTest {
	@Test
	public void intersects() {
		Rectangle rect1 = new Rectangle(10,20,10,20);
		Rectangle rect2 = new Rectangle(19,22,10,10);
		
		assertTrue(rect1.intersects(rect2));
	}
	
	@Test
	public void intersects2() {
		Rectangle rect1 = new Rectangle(10,20,10,20);
		Rectangle rect2 = new Rectangle(15,22,3,10);
		
		assertTrue(rect1.intersects(rect2));
	}
	
	@Test
	public void contains() {
		Rectangle rect1 = new Rectangle(10,20,10,20);
		Rectangle rect2 = new Rectangle(15,22,3,10);
		
		assertTrue(rect1.contains(rect2));
	}
	
	@Test
	public void contains2() {
		Rectangle rect1 = new Rectangle(10,20,10,20);
		Rectangle rect2 = new Rectangle(19,22,10,10);
		
		assertFalse(rect1.contains(rect2));
	}
	
}
