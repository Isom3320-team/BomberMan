package control;

import javafx.scene.input.KeyEvent;
import System.GameStatus;
import System.PhysicsManager;

public class UpKey {
	GameStatus gs;
	PhysicsManager pm;
	
	public UpKey(GameStatus gs){
		this.gs = gs;
		this.pm = new PhysicsManager(gs);
	}
	
	public void handle(KeyEvent keyevent) {
		if (gs.getPlayer() != null
				&& pm.canMove(gs.getPlayer(), PhysicsManager.CollisionType.UP)) {
			this.gs.getPlayer().moveUp();
			if (pm.hitsEnemy(gs.getPlayer(), PhysicsManager.CollisionType.OVERLAP)) {
				gs.getPlayer().die();
			}
		}
	}
}