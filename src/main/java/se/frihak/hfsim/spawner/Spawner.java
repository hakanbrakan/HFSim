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
import se.frihak.hfsim.simobjects.GameObject;
import se.frihak.hfsim.simobjects.Wall;
import se.frihak.hfsim.simobjects.Zone;

public class Spawner {
	private Logger log = Logger.getLogger(this.getClass().getName());

	private Handler handler;
	private HeadUpDisplay hud;
	private int scoreKeep = 0;
	private Random r = new Random();
	private Game game;

	private List<GameObject> attSkickaUt;
	private Map<String, GameObject> allaZoner;

	public Spawner(Handler handler, HeadUpDisplay hud, Game game) {
		this.handler = handler;
		this.hud = hud;
		this.game = game;
		allaZoner = new HashMap<>();
		attSkickaUt = new ArrayList<GameObject>();
		attSkickaUt.add(new Wall(50,	80, 60, 50));
		attSkickaUt.add(new Wall(150, 80, 60, 50));
		attSkickaUt.add(new Zone(350, 200, 100, 60));
		attSkickaUt.add(new Wall(10,	200, 100, 60));
		attSkickaUt.add(new Wall(130, 200, 100, 60));
		attSkickaUt.add(new Zone(250, 200, 100, 60));
	}

	public void tick() {
        log.finer("entering tick");
        if (!attSkickaUt.isEmpty()) {
        		log.fine("Spawnar ett gameobject");
			handler.addObject(attSkickaUt.remove(0));
//			attSkickaUt.stream().filter(l -> l.getId()==ID.Zone).forEach(k -> allaZoner.add(k.getName(), k));
		}
		//Kolla om det finns mer att släppa ut på banan
//		scoreKeep++;
//
//		if (scoreKeep >= 200) {
//			scoreKeep = 0;
//			hud.setLevel(hud.getLevel() + 1);
//
//		}
	}
}
