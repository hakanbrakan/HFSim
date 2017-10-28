package se.frihak.hfsim.spawner;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import se.frihak.hfsim.Handler;
import se.frihak.hfsim.simobjects.GameObject;
import se.frihak.hfsim.simobjects.SpecGameObject;
import se.frihak.hfsim.simobjects.WalkingMan;
import se.frihak.hfsim.simobjects.Zone;

public class ZoneSpawner extends GameObject {

	private Zone zoneAttSpawnaTill;
	private List<GameObject> allaGubbar;
	private Handler handler;

	public ZoneSpawner(SpecGameObject ettSpecObject, Handler handler) {
		super(0,0,ettSpecObject.getId());
		allaGubbar = new ArrayList<>();
		this.handler = handler;
	}

	@Override
	public void tick() {
		spawnaSaMangaGubbarSomMojligt();
		if (allaGubbar.isEmpty()) {
			handler.removeObject(this);
		}
	}

	private void spawnaSaMangaGubbarSomMojligt() {
		boolean fortsattaSpawna = true;
		
		while (fortsattaSpawna && !allaGubbar.isEmpty()) {
			System.out.println("spaaawn");
			handler.addObject(allaGubbar.remove(0));
		}
	}
	
	public void add(WalkingMan enGubbe) {
		allaGubbar.add(enGubbe);
	}
	
	public void set(Zone enNyZone) {
		this.zoneAttSpawnaTill = enNyZone;
	}
	
	@Override
	public void render(Graphics g) {
		// Zonespawnwer ska inte rita ut sig
	}
	
	@Override
	public Rectangle getBounds() {
		// Denna finns inte på spelplanen
		return null;
	}
}

