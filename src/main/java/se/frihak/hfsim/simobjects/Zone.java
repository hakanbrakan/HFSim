package se.frihak.hfsim.simobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import se.frihak.hfsim.Game;

public class Zone extends GameObject {
	private int width;
	private int height;
	private String name;

	public Zone(int x, int y, int width, int height, String name) {
		super(x, y, ID.Zone);
		if (y >= Game.HEIGHT) {
			setY(Game.HEIGHT);
		}
		//TODO Fyll på med fler felkontroller här   x >= Game.WIDTH
		this.width = width;
		this.height = height;
		this.name = name;
	}

	public Zone(SpecGameObject enSpec) {
		this(1,1,1,1, enSpec.getNamn());
	}

	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, width, height);
	}

	public void tick() {
	}

	public void render(Graphics g) {
		g.setColor(Color.GRAY);
		g.drawRect((int) x, (int) y, width, height);
	}
}
