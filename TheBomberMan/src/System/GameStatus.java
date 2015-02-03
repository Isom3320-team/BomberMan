package System;

import java.util.ArrayList;

import System.Player;

public class GameStatus {
	int inc = 32;
	private final Player player;
	private Bomb bomb;
	private ArrayList<Wall> wallArray;
	private ArrayList<Rock> rockArray;
	private ArrayList<Enemy> enemyArray;
	private ArrayList<Bomb> bombArray;
	private ArrayList<Item> itemArray;
	private ArrayList<Explosion> explosionArray;
	private ArrayList<Boss> bossArray;
	
	public GameStatus(){
		player = new Player(0, 0);
		wallArray= new ArrayList<Wall>();
		rockArray= new ArrayList<Rock>();
		enemyArray= new ArrayList<Enemy>();
		bombArray= new ArrayList<Bomb>();
		itemArray= new ArrayList<Item>();
		explosionArray = new ArrayList<Explosion>();
	}
	
	public Player getPlayer(){
		return player;
	}
	

	//Bomb
	

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
	public void removeBomb(int index){
		bombArray.remove(index);
	}

	public void removeItem(int index){
		itemArray.remove(index);
	}
	
	public void addExplosion(Explosion x) {
		explosionArray.add(x);
	}
	
	
	public ArrayList<Item> getItemArray(){
		return itemArray;
	}
	
	public ArrayList<Explosion> getExplosionArray(){
		return explosionArray;
	}
	
	public ArrayList<Bomb> getBombArray() {
		return bombArray; // Can be used either for Boss AND Player
	}
	
	public ArrayList<Wall> getWallArray() {
		return wallArray;
	}
	public ArrayList<Rock> getRockArray() {
		return rockArray;
	}
	public ArrayList<Boss> getBossArray() {
		return bossArray;
	}
	public ArrayList<Enemy> getEnemyArray() {
		return enemyArray;
	}

}
