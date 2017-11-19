package se.frihak.hfsim.simobjects.commands;

import se.frihak.hfsim.simobjects.WalkingMan;

public class CommandGoTo implements WalkingManCommand {

	private String name;

	public CommandGoTo(String name) {
		this.name = name;
	}

	@Override
	public void tick(WalkingMan gaandeMan) {
		// TODO Auto-generated method stub
		
	}

}
