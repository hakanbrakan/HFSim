package se.frihak.hfsim.spawner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

import se.frihak.hfsim.Game;
import se.frihak.hfsim.Handler;
import se.frihak.hfsim.HeadUpDisplay;
import se.frihak.hfsim.simobjects.GameObject;
import se.frihak.hfsim.simobjects.ID;
import se.frihak.hfsim.simobjects.SpecGameObject;
import se.frihak.hfsim.simobjects.WalkingMan;
import se.frihak.hfsim.simobjects.Wall;
import se.frihak.hfsim.simobjects.Zone;

public class Spawner {
	private Logger log = Logger.getLogger(this.getClass().getName());

	private Handler handler;
	private HeadUpDisplay hud;
	private int scoreKeep = 0;
	private Random r = new Random();
	private Game game;

	private List<SpecGameObject> attSpawna;
	private List<SpecGameObject> attSpawnaSenare;
	private Map<String, ZoneSpawner> allaZonespawners;

	public Spawner(Handler handler, HeadUpDisplay hud, Game game, SpawnerObjects objs) {
		this.handler = handler;
		this.hud = hud;
		this.game = game;
		allaZonespawners = new HashMap<>();
		attSpawna = new ArrayList<>();
		attSpawna.addAll(objs.getObjectsToSpawn());
		
		attSpawnaSenare = new ArrayList<>();
	}

	public void tick() {
        log.finer("entering tick");
        
        if(allaZonespawners.isEmpty()) {
        		createZoneSpawners();
        }
        
        spawnaAllaObjekt();
		//Kolla om det finns mer att släppa ut på banan
//		scoreKeep++;
//
//		if (scoreKeep >= 200) {
//			scoreKeep = 0;
//			hud.setLevel(hud.getLevel() + 1);
//
//		}
        
        spawnaDeSomHarVantat();
        allaZonespawners.values().forEach(r -> r.tick());
	}

	private void spawnaDeSomHarVantat() {
		for (SpecGameObject ettObjektAttSpawna : attSpawnaSenare) {
			if (isTimeToSpawnNow(ettObjektAttSpawna)) {
				spawnOneObject(ettObjektAttSpawna);
				attSpawnaSenare.remove(ettObjektAttSpawna);
			}
		}
	}

	private void spawnaAllaObjekt() {
		while (!attSpawna.isEmpty()) {
	    		log.fine("Spawnar ett gameobject");
			SpecGameObject ettObjektAttSpawna = attSpawna.remove(0);
			if (isTimeToSpawnNow(ettObjektAttSpawna)) {
				spawnOneObject(ettObjektAttSpawna);
			} else {
				attSpawnaSenare.add(ettObjektAttSpawna);
			}
		}
	}

	private void createZoneSpawners() {
		for (SpecGameObject enSpec : attSpawna) {
			if (enSpec.getId() == ID.Zone) {
				ZoneSpawner enZoneSpawner = new ZoneSpawner(enSpec, handler);
				allaZonespawners.put(enSpec.getNamn(), enZoneSpawner);
			}
		}
	}

	private void spawnOneObject(SpecGameObject enSpec) {
		if (enSpec.getId()==ID.Wall) {
			handler.addObject(new Wall(enSpec));
		} else if (enSpec.getId()==ID.Zone) {
			Zone enNyZone = new Zone(enSpec);
			handler.addObject(enNyZone);
			ZoneSpawner enZonSpawner = allaZonespawners.get(enSpec.getNamn());
			enZonSpawner.set(enNyZone);
		} else if (enSpec.getId()==ID.WalkingMan) {
			WalkingMan enGubbe = new WalkingMan(enSpec);
			ZoneSpawner enZonSpawner = allaZonespawners.get(enSpec.getStartzon());
			enZonSpawner.add(enGubbe);
		}
	}
	
	private boolean isTimeToSpawnNow(SpecGameObject ettObjektAttSpawna) {
		return true;
	}

}
