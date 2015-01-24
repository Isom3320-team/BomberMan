package System;

import System.Player;

public class GameStatus {
	private final Player player;
	
	public GameStatus(){
		player = new Player(0, 0);
	}
	
	public Player getPlayer(){
		return player;
	}
}
