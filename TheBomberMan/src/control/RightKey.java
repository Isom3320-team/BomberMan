package control;

import javafx.scene.input.KeyEvent;
import System.GameStatus;
import System.PhysicsManager;

public class RightKey {
	GameStatus gs;
	PhysicsManager pm;
	
	public RightKey(GameStatus gs){
		this.gs = gs;
		this.pm = new PhysicsManager(gs);
	}
	
	public void handle(KeyEvent keyevent) {
		if (gs.getPlayer() != null
				&& pm.canMove(gs.getPlayer(), PhysicsManager.CollisionType.RIGHT)) {
			this.gs.getPlayer().moveRight();
			if (pm.hitsEnemy(gs.getPlayer(), PhysicsManager.CollisionType.OVERLAP)) {
				gs.getPlayer().die();
			}
		}
	}
}
