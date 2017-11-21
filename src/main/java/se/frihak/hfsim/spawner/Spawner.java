package se.frihak.hfsim.spawner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

import se.frihak.hfsim.Game;
import se.frihak.hfsim.Handler;
import se.frihak.hfsim.HeadUpDisplay;
import se.frihak.hfsim.simobjects.ID;
import se.frihak.hfsim.simobjects.SpecGameObject;
import se.frihak.hfsim.simobjects.WalkingMan;
import se.frihak.hfsim.simobjects.Wall;
import se.frihak.hfsim.simobjects.Zone;
import se.frihak.hfsim.simobjects.commands.CommandFinishedSimulating;
import se.frihak.hfsim.simobjects.commands.CommandGoTo;
import se.frihak.hfsim.simobjects.commands.CommandID;
import se.frihak.hfsim.simobjects.commands.CommandRest;
import se.frihak.hfsim.simobjects.commands.WalkingManCommand;

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

	private WalkingManCommand cmdFinishedSimulating = new CommandFinishedSimulating();

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
		ArrayList<SpecGameObject> specarAttTaBort = new ArrayList<>();
		
		for (SpecGameObject enSpec : attSpawna) {
			if (enSpec.getId() == ID.Zone) {
				ZoneSpawner enZoneSpawner = new ZoneSpawner(enSpec, handler);
				allaZonespawners.put(enSpec.getNamn(), enZoneSpawner);

				Zone enNyZone = new Zone(enSpec);
				handler.addObject(enNyZone);
				enZoneSpawner.set(enNyZone);
				
				specarAttTaBort.add(enSpec);
			}
		}
		
		for (SpecGameObject spec : specarAttTaBort) {
			attSpawna.remove(spec);
		}
	}

	private void spawnOneObject(SpecGameObject enSpec) {
		if (enSpec.getId()==ID.Wall) {
			handler.addObject(new Wall(enSpec));
		} else if (enSpec.getId()==ID.WalkingMan) {
			spawnOneWalkingMan(enSpec);
		}
	}

	private void spawnOneWalkingMan(SpecGameObject enSpec) {
		WalkingMan enGubbe = new WalkingMan(enSpec, handler);
		ZoneSpawner enZonSpawner = allaZonespawners.get(enSpec.getStartzon());
		enZonSpawner.add(enGubbe);
		
		for (Map<String, Object> ettKommando : enSpec.getCommands()) {
			WalkingManCommand cmd;
			String kommandotyp = (String) ettKommando.get("ID");

			if (kommandotyp.equals(CommandID.GoTo.toString())) {
				cmd = new CommandGoTo(allaZonespawners.get(ettKommando.get("ZoneName")).getZone());
			} else if (kommandotyp.equals(CommandID.Rest.toString())) {
				cmd = new CommandRest((int) ettKommando.get("Time"));
			} else {
				cmd = cmdFinishedSimulating;
			}
			
			enGubbe.add(cmd);
		}
		enGubbe.add(cmdFinishedSimulating);
	}

	private boolean isTimeToSpawnNow(SpecGameObject ettObjektAttSpawna) {
		return true;
	}

}
