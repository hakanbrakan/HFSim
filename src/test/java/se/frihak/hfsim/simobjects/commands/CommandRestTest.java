package se.frihak.hfsim.simobjects.commands;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import se.frihak.hfsim.Handler;
import se.frihak.hfsim.simobjects.ID;
import se.frihak.hfsim.simobjects.SpecGameObject;
import se.frihak.hfsim.simobjects.WalkingMan;

public class CommandRestTest {

	private WalkingMan gaandeMan;

	@Before
	public void initera() {
		gaandeMan = new Gaande(new SpecGameObject(ID.WalkingMan, "Pelle", "zonB", "zonA"), null);
	}
	
	@Test
	public void testarTreTicks() {
		WalkingManCommand cmd = new CommandRest(3);
		cmd.tick(gaandeMan);
		assertFalse(((Gaande)gaandeMan).removeCommandHasBeenCalled());
		cmd.tick(gaandeMan);
		assertFalse(((Gaande)gaandeMan).removeCommandHasBeenCalled());
		cmd.tick(gaandeMan);
		assertTrue(((Gaande)gaandeMan).removeCommandHasBeenCalled());
	}
	
	
	
	
	
	private class Gaande extends WalkingMan {
		boolean removeCommandHasBeenCalled = false;

		public Gaande(SpecGameObject enSpec, Handler handler) {
			super(enSpec, handler);
		}
		@Override
		public void removeCommand(WalkingManCommand commandRest) {
			removeCommandHasBeenCalled = true;
		}
		public boolean removeCommandHasBeenCalled() {
			return removeCommandHasBeenCalled;
		}

	}
}
