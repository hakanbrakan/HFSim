package se.frihak.hfsim.simobjects.commands;

import java.awt.Point;

import se.frihak.hfsim.simobjects.WalkingMan;
import se.frihak.hfsim.simobjects.Zone;

public class CommandGoTo implements WalkingManCommand {
	private Zone goal;
	private Point goalPoint;

	public CommandGoTo(Zone goal) {
		this.goal = goal;
	}

	@Override
	public void tick(WalkingMan gaandeMan) {
		goalPoint = goal.nereast(new Point((int)gaandeMan.getX(),(int)gaandeMan.getY()));
		goalPoint.setLocation(goalPoint.getX()+Math.signum(goalPoint.getX()-gaandeMan.getX())*gaandeMan.getBounds().width, goalPoint.getY()+Math.signum(goalPoint.getY()-gaandeMan.getY())*gaandeMan.getBounds().height);
		
		
		float diffX = (float) (gaandeMan.getX() - goalPoint.getX());
		float diffY = (float) (gaandeMan.getY() - goalPoint.getY());
		float distance = (float) Math.sqrt(diffX*diffX + diffY*diffY);

		float velX = (-1 / distance) * diffX;
		float velY = (-1 / distance) * diffY;

		gaandeMan.setX((gaandeMan.getX() + velX));
		gaandeMan.setY((gaandeMan.getY() + velY));
		
		if (goalReached(goal, gaandeMan)) {
			thisCommandIsCompleted(gaandeMan);
		}

	}
	private void thisCommandIsCompleted(WalkingMan gaandeMan) {
		gaandeMan.removeCommand(this);
		goal = null;
	}

	private boolean goalReached(Zone goal, WalkingMan man) {
		return goal.getBounds().contains(man.getBounds());
	}

}
