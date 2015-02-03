package System;

import java.util.ArrayList;

import System.Player;

public class GameStatus {
	int inc = 32;
	private final Player player;
	private Bomb bomb;
<<<<<<< HEAD
<<<<<<< HEAD
	private ArrayList<Wall> wallArray;
	private ArrayList<Rock> rockArray;
	private ArrayList<Enemy> enemyArray;
	private ArrayList<Bomb> bombArray;
	private ArrayList<Item> itemArray;
	private ArrayList<Explosion> explosionArray;
=======
=======
>>>>>>> FETCH_HEAD
	ArrayList<Bomb> bombArray= new ArrayList<Bomb>();
	private ArrayList<Wall> wallArray= new ArrayList<Wall>();
	private ArrayList<Rock> rockArray= new ArrayList<Rock>();
	private ArrayList<Enemy> enemyArray= new ArrayList<Enemy>();
	private ArrayList<Minion> minionArray= new ArrayList<Minion>();
	private ArrayList<Item> itemArray= new ArrayList<Item>();
>>>>>>> FETCH_HEAD
	
	public GameStatus(){
		player = new Player(0, 0);
		wallArray= new ArrayList<Wall>();
		rockArray= new ArrayList<Rock>();
		enemyArray= new ArrayList<Enemy>();
		bombArray= new ArrayList<Bomb>();
		itemArray= new ArrayList<Item>();
	}
	
	public Player getPlayer(){
		return player;
	}
	
<<<<<<< HEAD
<<<<<<< HEAD
=======
	//Bomb
	
>>>>>>> FETCH_HEAD
=======
	//Bomb
	
>>>>>>> FETCH_HEAD
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
<<<<<<< HEAD
<<<<<<< HEAD
	
	public void removeItem(int index){
		itemArray.remove(index);
	}
	public void addExplosion(Explosion x) {
		explosionArray.add(x);
	}
	
	public ArrayList<Wall> getWalls(){
		return wallArray;
	}
	
	public ArrayList<Rock> getRocks(){
		return rockArray;
	}
	
	public ArrayList<Enemy> getEnemies(){
		return enemyArray;
	}
	
	public ArrayList<Item> getItems(){
		return itemArray;
	}
	
	public ArrayList<Bomb> getBombs(){
		return bombArray;
	}
	
	public ArrayList<Explosion> getExplosions(){
		return explosionArray;
	}
	
=======
=======
>>>>>>> FETCH_HEAD
	public ArrayList<Bomb> getBombArray() {
		return bombArray; // Can be used either for Boss AND Player
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
<<<<<<< HEAD
>>>>>>> FETCH_HEAD
=======
>>>>>>> FETCH_HEAD
}
