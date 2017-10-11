package se.frihak.hfsim;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import se.frihak.hfsim.simobjects.GameObject;
import se.tutorial.main.Game.STATE;

public class KeyInput extends KeyAdapter {

	private Handler handler;
	private boolean[] keyDown = new boolean[4];
	Game game;

	public KeyInput(Handler handler, Game game) {
		this.handler = handler;
		this.game = game;

		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
		keyDown[3] = false;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		for (int i = 0; i < handler.object.size(); i++) {
//			GameObject tempObject = handler.object.get(i);
//			if (tempObject.getId() == ID.player) {
//				// key events for player 1
//
//				if (key == KeyEvent.VK_W) {
//					tempObject.setvelY(-handler.spd);
//					keyDown[0] = true;
//				}
//				if (key == KeyEvent.VK_S) {
//					tempObject.setvelY(handler.spd);
//					keyDown[1] = true;
//				}
//				if (key == KeyEvent.VK_D) {
//					tempObject.setvelX(handler.spd);
//					keyDown[2] = true;
//				}
//				if (key == KeyEvent.VK_A) {
//					tempObject.setvelX(-handler.spd);
//					keyDown[3] = true;
//				}
//			}
//
		}
		if (game.gameState == Game.STATE.Game) {
			if (key == KeyEvent.VK_P) {
				if (Game.paused)
					Game.paused = false;
				else
					Game.paused = true;
			}
		}
		if (key == KeyEvent.VK_ESCAPE)
			System.exit(1);
		if (key == KeyEvent.VK_SPACE) {
			if (Game.gameState == Game.STATE.Game)
				Game.gameState = Game.STATE.Shop;
			else if (Game.gameState == Game.STATE.Shop)
				Game.gameState = Game.STATE.Game;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for (int i = 0; i < handler.object.size(); i++) {
//			GameObject tempObject = handler.object.get(i);
//			if (tempObject.getId() == ID.player) {
//				// key events for player 1
//
//				if (key == KeyEvent.VK_W) {
//					keyDown[0] = false;
//					tempObject.setvelY(0);
//				}
//				if (key == KeyEvent.VK_S) {
//					keyDown[1] = false;
//					tempObject.setvelY(0);
//				}
//				if (key == KeyEvent.VK_D) {
//					keyDown[2] = false;
//					tempObject.setvelX(0);
//				}
//				if (key == KeyEvent.VK_A) {
//					keyDown[3] = false;
//					tempObject.setvelX(0);
//				}
//
//				// Vertical movement
//				if (keyDown[0] && keyDown[1]) {
//					tempObject.setvelY(0);
//				}
//				// Horizontal movement
//				if (keyDown[2] && keyDown[3]) {
//					tempObject.setvelX(0);
//				}
//			}
//
		}
	}

}