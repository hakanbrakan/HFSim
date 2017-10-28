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

public class ZoneSpawner {
	private String zonNamn;
	private Zone zoneAttSpawnaTill;
	private List<GameObject> allaGubbar;
	private Handler handler;

	public ZoneSpawner(SpecGameObject ettSpecObject, Handler handler) {
		allaGubbar = new ArrayList<>();
		this.handler = handler;
		this.zonNamn = ettSpecObject.getNamn();
	}

	public void tick() {
		if (!allaGubbar.isEmpty()) {
			spawnaSaMangaGubbarSomMojligt();
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
	public String toString() {
		return "ZoneSpawner [zonNamn=" + zonNamn + "]";
	}
}

