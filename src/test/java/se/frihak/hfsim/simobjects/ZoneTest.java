package se.frihak.hfsim.simobjects;

import static org.junit.Assert.assertEquals;

import java.awt.Rectangle;

import org.junit.Before;
import org.junit.Test;

public class ZoneTest {
	private Zone enZon;
	private Rectangle zonstorlek;
	
	@Before
	public void initera() {
		zonstorlek = new Rectangle(10,10,50,100);
		enZon = new Zone(zonstorlek.x, zonstorlek.y, zonstorlek.width, zonstorlek.height);
	}
	@Test
	public void jamforBaraKoplats() {
		assertEquals(zonstorlek, enZon.getBounds());
	}


}
