package se.frihak.hfsim.simobjects.commands;

import se.frihak.hfsim.simobjects.WalkingMan;

public class CommandFinishedSimulating implements WalkingManCommand {

	@Override
	public void tick(WalkingMan gaandeMan) {
		gaandeMan.removeCommand(this);
		gaandeMan.finishSimulating();
	}
}
