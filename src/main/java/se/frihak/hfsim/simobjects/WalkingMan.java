package se.frihak.hfsim.simobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.logging.Logger;
import java.util.stream.Stream;

import se.frihak.hfsim.Handler;

public class WalkingMan extends GameObject {
	private static final int WIDTH = 5;
	private static final int HEIGHT = 5;
	private String goalZoneName;
	private boolean shouldAddTrail = false;
	private Handler handler;
	private Zone goalZone;
	private Point goalPoint;
	private boolean okAttAvsluta = false; 

	public WalkingMan(SpecGameObject enSpec, Handler handler) {
		super(1, 1, ID.WalkingMan);
		this.goalZoneName = enSpec.getGoal();
		this.handler = handler;
	}

	@Override
	public void tick() {
		if (goalZone == null) {
			//TODO Nedan kanske ska flyttas in i handler istället med metodanrop härifrån
			goalZone = handler
						.getObjects((i) -> i.getId()==ID.Zone)
						.map(Zone.class::cast)
						.filter((i) -> i.getName().equals(goalZoneName))
						.findFirst()
						.orElse(null);
			goalPoint = goalZone.nereast(new Point((int)x,(int)y));
			goalPoint.setLocation(goalPoint.getX()+Math.signum(goalPoint.getX()-x)*WIDTH, goalPoint.getY()+Math.signum(goalPoint.getY()-y)*HEIGHT);
		}
		x += velX;
		y += velY;

		float diffX = (float) (x - goalPoint.getX());
		float diffY = (float) (y - goalPoint.getY());
		float distance = (float) Math.sqrt(diffX*diffX + diffY*diffY);

		velX = (float) ((-1 / distance) * diffX);
		velY = (float) ((-1 / distance) * diffY);

//		if (y <= 0 || y >= Game.HEIGHT - 32) {
//			velY *= -1;
//		}
//
//		if (x <= 0 || x >= Game.WIDTH - 32) {
//			velX *= -1;
//		}
		
		if (goalReached(goalZone, x, y)) {
			handler.removeObject(this);
			okAttAvsluta = true;
		}

		addTrail(shouldAddTrail );
	}

	private boolean goalReached(Zone goal, float x, float y) {
		return goal.getBounds().contains(x,y);
	}

	private void addTrail(boolean addTrail) {
		if (addTrail) {
			System.out.println("skapar en trail"); //TODO
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect((int) x, (int) y, WIDTH, HEIGHT);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, WIDTH, HEIGHT);
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("destruerar WalkingMan");
		super.finalize();
	}

	@Override
	public boolean isOKAttAvslutaSimulering() {
		return okAttAvsluta;
	}

}
