package System;

import System.Player;

public class GameStatus {
	private final Player player;
	private Bomb bomb;
	
	public GameStatus(){
		player = new Player(0, 0);
	}
	
	public Player getPlayer(){
		return player;
	}
	public Bomb getBomb(){
		return bomb;
	}
	public Bomb newBomb(){
		bomb = new Bomb(player.getX(),player.getY());
		return bomb;
	}
}
