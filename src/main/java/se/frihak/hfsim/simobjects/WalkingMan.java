package se.frihak.hfsim.simobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

import se.frihak.hfsim.Handler;
import se.frihak.hfsim.simobjects.commands.WalkingManCommand;

public class WalkingMan extends GameObject {
	private static final int WIDTH = 5;
	private static final int HEIGHT = 5;
	private boolean shouldAddTrail = false;
	private Handler handler;
	private boolean okAttAvsluta = false;
	private List<WalkingManCommand> myCommands = new LinkedList<>(); 

	public WalkingMan(SpecGameObject enSpec, Handler handler) {
		super(1, 1, ID.WalkingMan);
		this.handler = handler;
	}

	@Override
	public void tick() {
		if (myCommands.isEmpty()) {
			finishSimulating();
		} else {
			myCommands.get(0).tick(this);
		}

		addTrail(shouldAddTrail );
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

	public void add(WalkingManCommand cmd) {
		myCommands.add(cmd);
	}

	public void removeCommand(WalkingManCommand commandRest) {
		myCommands.remove(commandRest);
	}

	public void finishSimulating() {
		okAttAvsluta = true;
		myCommands.clear();
		handler.removeObject(this);
		handler = null;
		shouldAddTrail = false;
	}

}
