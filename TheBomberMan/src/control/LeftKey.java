package control;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import System.GameStatus;
import System.PhysicsManager;
import System.CollisionType;

public class LeftKey implements EventHandler<KeyEvent>{

	GameStatus gs;
	PhysicsManager pm;
		
	public LeftKey(GameStatus gs){
		this.gs = gs;
		this.pm = new PhysicsManager(gs);
	}
		
	public void handle(KeyEvent keyevent) {
		if (gs.getPlayer() != null
				&& pm.canMove(gs.getPlayer(), CollisionType.LEFT)) {
			this.gs.getPlayer().moveLeft();
			if (pm.hitsEnemy(gs.getPlayer(), CollisionType.OVERLAP)) {
				gs.getPlayer().die();
			}
		}
	}	
}
