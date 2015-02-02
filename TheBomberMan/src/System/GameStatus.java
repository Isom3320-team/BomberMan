package System;

import java.util.ArrayList;

import System.Player;

public class GameStatus {
	private final Player player;
	private Bomb bomb;
	ArrayList<Bomb> bombArray= new ArrayList<Bomb>();
	private ArrayList<Wall> wallArray= new ArrayList<Wall>();
	private ArrayList<Rock> rockArray= new ArrayList<Rock>();
	private ArrayList<Enemy> enemyArray= new ArrayList<Enemy>();
	private ArrayList<Minion> minionArray= new ArrayList<Minion>();
	private ArrayList<Item> itemArray= new ArrayList<Item>();
	
	public GameStatus(){
		player = new Player(0, 0);
	}
	
	public Player getPlayer(){
		return player;
	}
	
	//Bomb
	
	public Bomb getBomb(){
		if (!bombArray.isEmpty()){
		int l = bombArray.lastIndexOf(bomb);
		return bombArray.get(l);
		}else{
		return null;
		}
	}
	public void addBomb(){
		bomb = new Bomb(player.getX() ,player.getY());
		bombArray.add(bomb);
	}
	public void removeBomb(){
		if(bombArray.size()!=0){
		bombArray.remove(0);
		}
	}
	public ArrayList<Bomb> getBombArray() {
		return bombArray; // I need the complete array for Physics Manager
	}
	
	public ArrayList<Wall> getWallArray() {
		return wallArray;
	}
	public ArrayList<Rock> getRockArray() {
		return rockArray;
	}
	public ArrayList<Minion> getMinionArray() {
		return minionArray;
	}
	public ArrayList<Enemy> getEnemyArray() {
		return enemyArray;
	}
}
