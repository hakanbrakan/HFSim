package se.frihak.hfsim.simobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class WalkingMan extends GameObject {
	private static final int WIDTH = 5;
	private static final int HEIGHT = 5;

	public WalkingMan(SpecGameObject enSpec) {
		super(1, 1, ID.WalkingMan);
	}

	@Override
	public void tick() {
		System.out.println("walkingman tick");
		// TODO Auto-generated method stub

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

}
