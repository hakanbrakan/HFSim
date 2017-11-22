package se.frihak.hfsim.simobjects.commands;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import se.frihak.hfsim.simobjects.WalkingMan;
import se.frihak.hfsim.simobjects.Zone;

public class CommandGoToTest {
	private WalkingMan man = new WalkingMan(null, null);

	private Zone zon = new Zone(10, 20, 30, 40, "A");

	@Before
	public void initera() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void garTreStegX(){
		man.setX(5); 
		man.setY(25); 
		
		WalkingManCommand cmd = new CommandGoTo(zon);
		cmd.tick(man);
		cmd.tick(man);
		cmd.tick(man);
		
		assertEquals(8, man.getX(), 0.02f);
		assertEquals(25, man.getY(), 0.02f);
	}

	@Test
	public void garTvaStegY(){
		man.setX(20); 
		man.setY(10); 
		
		WalkingManCommand cmd = new CommandGoTo(zon);
		cmd.tick(man);
		cmd.tick(man);
		
		assertEquals(20, man.getX(), 0.02f);
		assertEquals(12, man.getY(), 0.02f);
	}

	@Test
	public void garInIZonen(){
		WalkingMan spy = spy(man);
		spy.setX(20); 
		spy.setY(18); 
		
		WalkingManCommand cmd = new CommandGoTo(zon);
		cmd.tick(spy);
		cmd.tick(spy);

		verify(spy, times(1)).removeCommand(cmd);;
	}
}
