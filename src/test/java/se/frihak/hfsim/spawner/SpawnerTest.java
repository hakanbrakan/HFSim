package se.frihak.hfsim.spawner;

import static org.junit.Assert.assertEquals;

import java.awt.Rectangle;

import org.junit.Before;
import org.junit.Test;

import se.frihak.hfsim.Handler;

public class SpawnerTest {
	
	@Before
	public void initiera() {
	}
	@Test
	public void jamforBaraKoplats() {
		
		Spawner test = new Spawner(new Handler(), null, null, new HardkodadeSpawnerObjects());
		test.tick();
		test.tick();
//		assertEquals(zonstorlek, enZon.getBounds());
	}


}
