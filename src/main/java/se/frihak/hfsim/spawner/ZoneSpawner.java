package se.frihak.hfsim.spawner;

import java.util.ArrayList;
import java.util.List;

import se.frihak.hfsim.Game;
import se.frihak.hfsim.Handler;
import se.frihak.hfsim.simobjects.GameObject;
import se.frihak.hfsim.simobjects.SpecGameObject;
import se.frihak.hfsim.simobjects.WalkingMan;
import se.frihak.hfsim.simobjects.Zone;

public class ZoneSpawner {
	private String zonNamn;
	private Zone zoneAttSpawnaTill;
	private List<GameObject> allaGubbar;
	private List<GameObject> gubbarIZonen;
	private Handler handler;
	private double xTo;
	private double xFrom;
	private double xDirection;
	private double yTo;
	private double yFrom;
	private double yDirection;

	public ZoneSpawner(SpecGameObject ettSpecObject, Handler handler) {
		allaGubbar = new ArrayList<>();
		gubbarIZonen = new ArrayList<>();
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
			GameObject enGubbe = allaGubbar.get(0);
			fortsattaSpawna = tryToSpawn(enGubbe);
			if (fortsattaSpawna) {
				allaGubbar.remove(enGubbe);
			}
		}
	}
	
	private boolean tryToSpawn(GameObject enGubbe) {
		for (double xTry = xFrom ; (xTo - xTry)*xDirection >= 0; xTry += xDirection) {
			for (double yTry = yFrom ; (yTo - yTry)*yDirection >= 0; yTry += yDirection) {
				System.out.println(xTry +", "+ yTry);
				if (lyckasPlaceraPaPoint(enGubbe, xTry, yTry)) {
					gubbarIZonen.add(enGubbe);
					handler.addObject(enGubbe);
					return true;
				}
			}
		}

		return false;
	}

	private boolean lyckasPlaceraPaPoint(GameObject enGubbeAttSpawna, double xTry, double yTry) {
		enGubbeAttSpawna.setX((int) xTry);
		enGubbeAttSpawna.setY((int) yTry);
		if ( ! zoneAttSpawnaTill.getBounds().contains(enGubbeAttSpawna.getBounds())) {
			return false;
		}
		//TODO kolla även mot andra redan placerade gubbar.
		for (GameObject testgubbe : gubbarIZonen) {
			//Kolla om denna gubbe hunnit ut ur zonen
			if ( ! zoneAttSpawnaTill.getBounds().contains(testgubbe.getBounds())) {
				gubbarIZonen.remove(testgubbe);
			}
			if (enGubbeAttSpawna.getBounds().intersects(testgubbe.getBounds())) {
				return false;
			}
		}
		return true;
	}

	public void add(WalkingMan enGubbe) {
		allaGubbar.add(enGubbe);
	}
	
	public void set(Zone enNyZone) {
		this.zoneAttSpawnaTill = enNyZone;
		if (Math.abs(Game.WIDTH/2 - enNyZone.getX()) < Math.abs(Game.WIDTH/2 - enNyZone.getBounds().getMaxX())) {
			xFrom = enNyZone.getX();
			xTo = enNyZone.getBounds().getMaxX();
		} else {
			xFrom = enNyZone.getBounds().getMaxX();
			xTo = enNyZone.getX();
		}
		xDirection = Math.signum(xTo - xFrom);
		
		
		if (Math.abs(Game.HEIGHT/2 - enNyZone.getY()) < Math.abs(Game.HEIGHT/2 - enNyZone.getBounds().getMaxY())) {
			yFrom = enNyZone.getY();
			yTo = enNyZone.getBounds().getMaxY();
		} else {
			yFrom = enNyZone.getBounds().getMaxY();
			yTo = enNyZone.getY();
		}
		yDirection = Math.signum(yTo - yFrom);
	}

	@Override
	public String toString() {
		return "ZoneSpawner [zonNamn=" + zonNamn + "]";
	}
}

