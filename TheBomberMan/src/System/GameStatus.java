package System;

import java.util.ArrayList;
import java.util.Random;

import System.Bomb;
import System.Boss;
import System.Difficulty;
import System.Enemy;
import System.Explosion;
import System.FlyMinion;
import System.Rock;
import System.Item;
import System.Wall;
import System.Player;

public class GameStatus {
	
	int fieldWidth = 544;
	int fieldHeight = 416;
	int inc = 32;
	
	private Player player;
	private ArrayList<Wall> wallArray;
	private ArrayList<Rock> rockArray;
	private ArrayList<Enemy> enemyArray;
	private ArrayList<Bomb> bombArray;
	private ArrayList<Item> itemArray;
	private ArrayList<Explosion> explosionArray;
	private ArrayList<Boss> bossArray;
	private boolean gameOver;
	
	
	public GameStatus(){
		player = new Player(32, 32);
		wallArray= new ArrayList<Wall>();
		rockArray= new ArrayList<Rock>();
		enemyArray= new ArrayList<Enemy>();
		bombArray= new ArrayList<Bomb>();
		itemArray= new ArrayList<Item>();
		explosionArray = new ArrayList<Explosion>();
		InitializeGame(2);
		gameOver = false;
		
	}
	
	public Player getPlayer(){
		return player;
	}


	
	public void addBomb(){
		bombArray.add(new Bomb(player.getX() ,player.getY()));
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
	
	public void removeExplosion(int index){
		explosionArray.remove(index);
	}
	public void removeEnemy(int index){
		enemyArray.remove(index);
	}
	public void removeWall(int index){
		wallArray.remove(index);
		System.out.print("this wall removed");
	}
	public void removeAll(){
		bombArray.clear();
		wallArray.clear();
		rockArray.clear();
		itemArray.clear();
		enemyArray.clear();
		explosionArray.clear();
	}
	public void InitializeGame(int lvl){
		bombArray = new ArrayList<Bomb>();
		wallArray = new ArrayList<Wall>();
		rockArray = new ArrayList<Rock>();
		itemArray = new ArrayList<Item>();
		enemyArray = new ArrayList<Enemy>();
		explosionArray = new ArrayList<Explosion>();
		
		int enemyChance;
		int wallChance;
		int itemChance = 5;

		if (lvl % 2 == 0) {
			enemyChance = 5;
			wallChance = 40;
		} else if (lvl % 3 == 0) {
			enemyChance = 10;
			wallChance = 30;
			enemyArray.add(new Boss(480,320));
		} else {
			enemyChance = 5;
			wallChance = 40;
		}

		for (int i = 0; i < fieldWidth; i += inc) {
			for (int j = 0; j < fieldHeight; j += inc) {
				// places edge blocks
				if (i % (fieldWidth - inc) == 0 || j % (fieldHeight - inc) == 0
				// places lattice
						|| i % (2 * inc) == 0 && j % (2 * inc) == 0) {
					rockArray.add(new Rock(i, j));
				} 
				
				// create wall, but leave space for player and boss
				else if ((i > 3 * inc) || (j > 3 * inc) && i != 480
						&& j != 320) {
					// chance of softblock
					if ((new Random().nextInt(100)) < wallChance) {
						wallArray.add(new Wall(i, j));
						// chance of enemy
					} else if ((new Random().nextInt(100)) < enemyChance) {

						if (lvl % 2 == 0) { // every second level, add FlyMinions

							enemyArray.add(new FlyMinion(i, j));
						} else {
							enemyArray.add(new Minion(i, j));

						}
					} else if ((new Random()).nextInt(100)< itemChance){
						
						itemArray.add(new Item(i,j));
						
					}
				}
			}
		}
		
	}
	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
}
