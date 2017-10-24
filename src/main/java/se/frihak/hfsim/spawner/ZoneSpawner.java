package se.frihak.hfsim.spawner;

import java.awt.Graphics;
import java.awt.Rectangle;

import se.frihak.hfsim.simobjects.GameObject;
import se.frihak.hfsim.simobjects.SpecGameObject;
import se.frihak.hfsim.simobjects.Zone;

public class ZoneSpawner extends GameObject {

	public ZoneSpawner(SpecGameObject ettSpecObject) {
		super(1,1,ettSpecObject.getId());
	}

	public void add(Zone enNyZone) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
