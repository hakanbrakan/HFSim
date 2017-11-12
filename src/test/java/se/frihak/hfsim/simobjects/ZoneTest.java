package se.frihak.hfsim.simobjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.awt.Rectangle;

import org.junit.Before;
import org.junit.Test;

public class ZoneTest {
	private Zone enZon;
	private Rectangle zonstorlek;
	
	@Before
	public void initera() {
		zonstorlek = new Rectangle(10,10,50,100);
		enZon = new Zone(zonstorlek.x, zonstorlek.y, zonstorlek.width, zonstorlek.height, "testnamn");
	}
	
	@Test
	public void jamforBaraKoplats() {
		assertEquals(zonstorlek, enZon.getBounds());
	}

	@Test
	public void narmastePunkt() {
		Point tillVanster = new Point(5, 55);
		assertEquals(10, enZon.nereast(tillVanster).getX(), 0d);
		assertEquals(55, enZon.nereast(tillVanster).getY(), 0d);
		
		Point uppeTillVanster = new Point(5, 5);
		assertEquals(10, enZon.nereast(uppeTillVanster).getX(), 0d);
		assertEquals(10, enZon.nereast(uppeTillVanster).getY(), 0d);
		
		Point tillHoger = new Point(70, 55);
		assertEquals(60, enZon.nereast(tillHoger).getX(), 0d);
		assertEquals(55, enZon.nereast(tillHoger).getY(), 0d);

		Point mittI = new Point(35, 88);
		assertEquals(35, enZon.nereast(mittI).getX(), 0d);
		assertEquals(88, enZon.nereast(mittI).getY(), 0d);

	}
	
	@Test
	public void avslutaSimulering() {
		assertTrue(enZon.isOKAttAvslutaSimulering());
	}

	@Test
	public void testToString() {
		assertEquals("Zone [name=testnamn]", enZon.toString());
	}
}
