package control;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import System.GameStatus;
import System.PhysicsManager;

/**
 * For each key control class, set up the corresponding handler
 * In the main engine class, use listener to monitor the keyevents
 * @author jinzenan
 *
 */

public class DownKey implements EventHandler<KeyEvent>{
	
	GameStatus gs;
	PhysicsManager pm;
	
	public DownKey(GameStatus gs){
		this.gs = gs;
		this.pm = new PhysicsManager(gs);
	}
	
	public void handle(KeyEvent keyevent) {
		if (gs.getPlayer() != null
				&& pm.canMove(gs.getPlayer(), PhysicsManager.CollisionType.DOWN)) {
			this.gs.getPlayer().moveDown();
			if (pm.hitsEnemy(gs.getPlayer(), PhysicsManager.CollisionType.OVERLAP)) {
				gs.getPlayer().die();
			}
		}
	}
}
