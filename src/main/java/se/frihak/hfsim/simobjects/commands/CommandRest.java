package se.frihak.hfsim.simobjects.commands;

import se.frihak.hfsim.simobjects.WalkingMan;

public class CommandRest implements WalkingManCommand {

	private int numOfTicksToWait;

	public CommandRest(int antal) {
		numOfTicksToWait = antal;
	}

	@Override
	public void tick(WalkingMan gaandeMan) {
		numOfTicksToWait--;
		if (numOfTicksToWait > 0) {
			//Fortsatt vanta
		} else {
			gaandeMan.removeCommand(this);
		}
	}

}
