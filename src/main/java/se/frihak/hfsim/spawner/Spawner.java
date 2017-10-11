package se.frihak.hfsim.spawner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import se.frihak.hfsim.Game;
import se.frihak.hfsim.Handler;
import se.frihak.hfsim.HeadUpDisplay;
import se.frihak.hfsim.simobjects.GameObject;
import se.frihak.hfsim.simobjects.Wall;

public class Spawner {
	private Logger log = Logger.getLogger(this.getClass().getName());

	private Handler handler;
	private HeadUpDisplay hud;
	private int scoreKeep = 0;
	private Random r = new Random();
	private Game game;

	private List<GameObject> attSkickaUt;

	public Spawner(Handler handler, HeadUpDisplay hud, Game game) {
		this.handler = handler;
		this.hud = hud;
		this.game = game;
		attSkickaUt = new ArrayList<GameObject>();
		attSkickaUt.add(new Wall(50,	80, 60, 50));
		attSkickaUt.add(new Wall(150, 80, 60, 50));
		attSkickaUt.add(new Wall(10,	200, 100, 60));
	}

	public void tick() {
        log.finer("entering tick");
        if (!attSkickaUt.isEmpty()) {
        		log.fine("Spawnar ett gameobject");
			handler.addObject(attSkickaUt.get(0));
			attSkickaUt.remove(0);
		}
		//Kolla om det finns mer att släppa ut på banan
//		scoreKeep++;
//
//		if (scoreKeep >= 200) {
//			scoreKeep = 0;
//			hud.setLevel(hud.getLevel() + 1);
//
//			if (game.diff == 0) {
//				if (hud.getLevel() >= 1 && hud.getLevel() <= 5) {
//					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50),
//							ID.BasicEnemy, handler));
//				} else if (hud.getLevel() == 6) {
//					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50),
//							ID.FastEnemy, handler));
//				} else if (hud.getLevel() == 7) {
//					handler.addObject(new SmartEnemy(Game.WIDTH / 2, Game.HEIGHT / 2, ID.SmartEnemy, handler));
//				} else if (hud.getLevel() == 10) {
//					handler.clearEnemys();
//					handler.addObject(new EnemyBoss(Game.WIDTH / 2, Game.HEIGHT - 500, ID.EnemyBoss, handler));
//				}
//				if(hud.getLevel() == 14){
//					handler.clearEnemys();
//					handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50),ID.BasicEnemy, handler));
//				}
//			}
//		}
	}
}
