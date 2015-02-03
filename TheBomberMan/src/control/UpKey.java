package control;

import javafx.scene.input.KeyEvent;
import System.GameStatus;
import System.PhysicsManager;
import System.CollisionType;

public class UpKey {
	GameStatus gs;
	PhysicsManager pm;
	
	public UpKey(GameStatus gs){
		this.gs = gs;
		this.pm = new PhysicsManager(gs);
	}
	
	public void handle(KeyEvent keyevent) {
		if (gs.getPlayer() != null
				&& pm.canMove(gs.getPlayer(), CollisionType.UP)) {
			this.gs.getPlayer().moveUp();
			if (pm.hitsEnemy(gs.getPlayer(), CollisionType.OVERLAP)) {
				gs.getPlayer().die();
			}
		}
	}
}