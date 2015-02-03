package control;

import java.awt.event.ActionEvent;
import System.GameStatus;
import System.PhysicsManager;

public class SpaceKey {
	
	GameStatus gs;
	PhysicsManager pm;
	
	public SpaceKey(GameStatus gs){
		this.gs = gs;
		this.pm = new PhysicsManager(gs);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (gs.getPlayer() != null&& pm.canPlaceBomb(gs.getPlayer())) {
			this.gs.addBomb();
		}
	}
}
