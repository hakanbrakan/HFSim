package se.frihak.hfsim.simobjects.commands;

import java.awt.Point;

import se.frihak.hfsim.Handler;
import se.frihak.hfsim.simobjects.ID;
import se.frihak.hfsim.simobjects.WalkingMan;
import se.frihak.hfsim.simobjects.Zone;

public class CommandGoTo implements WalkingManCommand {

	private String zonename;
	private Zone goalZone;
	private Point goalPoint;
	private Handler handler;

	public CommandGoTo(String name, Handler handler) {
		this.zonename = name;
		this.handler = handler;
	}

	@Override
	public void tick(WalkingMan gaandeMan) {
		if (goalZone == null) {
			goalZone = handler
					.getObjects((i) -> i.getId()==ID.Zone)
					.map(Zone.class::cast)
					.filter((i) -> i.getName().equals(zonename))
					.findFirst()
					.orElse(null);
		}
		goalPoint = goalZone.nereast(new Point((int)gaandeMan.getX(),(int)gaandeMan.getY()));
		goalPoint.setLocation(goalPoint.getX()+Math.signum(goalPoint.getX()-gaandeMan.getX())*gaandeMan.getBounds().width, goalPoint.getY()+Math.signum(goalPoint.getY()-gaandeMan.getY())*gaandeMan.getBounds().height);
		
		
		float diffX = (float) (gaandeMan.getX() - goalPoint.getX());
		float diffY = (float) (gaandeMan.getY() - goalPoint.getY());
		float distance = (float) Math.sqrt(diffX*diffX + diffY*diffY);

		float velX = (-1 / distance) * diffX;
		float velY = (-1 / distance) * diffY;

		gaandeMan.setX((gaandeMan.getX() + velX));
		gaandeMan.setY((gaandeMan.getY() + velY));
		
		if (goalReached(goalZone, gaandeMan.getX(), gaandeMan.getY())) {
			thisCommandIsCompleted(gaandeMan);
		}

	}
	private void thisCommandIsCompleted(WalkingMan gaandeMan) {
		gaandeMan.removeCommand(this);
		handler = null;
		goalZone = null;
	}

	private boolean goalReached(Zone goal, float x, float y) {
		return goal.getBounds().contains(x,y);
	}

}
