package System;
import java.util.ArrayList;
import java.util.Random;

import System.Bomb;
import System.Boss;
import System.Enemy;
import System.Explosion;
import System.FlyMinion;
import System.Rock;
import System.Item;
import System.Wall;
import System.Player;

/**
 * GameStatus is where the memory of the game is created and stored, it also
 * records the progress of the game 
 * @author shawn, jin, cyril
 *
 */

public class GameStatus {
	
	/**
	 * A GameStatus gives a virtual world of 544*416 pixels.
	 * It contains a player, some walls, some rocks, some enemies, some bombs,
	 * some items, some explosions, the score of the game, and an boss.
	 * A game is finished when the gameOver is set to true.
	 */
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
	private ArrayList<String> scoreArray; 
	
	private String Score = "0";
	private boolean gameOver;
	
	/**
	 * Create a GameStatus that puts a player at (32,32) and all other units
	 * It starts from level 1.
	 */
	
	
	public GameStatus(){
		player = new Player(32, 32);
		wallArray= new ArrayList<Wall>();
		rockArray= new ArrayList<Rock>();
		enemyArray= new ArrayList<Enemy>();
		bombArray= new ArrayList<Bomb>();
		itemArray= new ArrayList<Item>();
		explosionArray = new ArrayList<Explosion>();
		InitializeGame(1);
		scoreArray = new ArrayList<String>();
		gameOver = false;
		
	}
	
	/**
	 * get the player
	 * @return
	 */
	public Player getPlayer(){
		return player;
	}
	/**
	 * add the score that player has earned
	 * @param score
	 */
	public void addScore(int score){
		for (int i=0; i<score; i++){
		   scoreArray.add("+1");
		}
	}
	/**
	 * set the score of the game
	 */
	public void setScore(){
		Score=String.valueOf(scoreArray.size());
		
	}
	/**
	 * get the score of the game
	 * @return
	 */
	public String getScore(){
		return Score;
	}
	
	/**
	 * add a bomb to the map
	 */
	public void addBomb(){
		bombArray.add(new Bomb(player.getX() ,player.getY()));
	}
	
	/**
	 * remove the bomb from the map
	 */
	
	public void removeBomb(){
		if(bombArray.size()!=0){
		bombArray.remove(0);
		}
	}
	
	/**
	 * remove a certain bomb
	 * @param index
	 */
	public void removeBomb(int index){
		bombArray.remove(index);
	}

	/**
	 * remove item form the map
	 * @param index
	 */
	public void removeItem(int index){
		itemArray.remove(index);
		addScore(5);
	}
	
	/**
	 * add explosion to the map
	 * @param x
	 */
	public void addExplosion(Explosion x) {
		explosionArray.add(x);
	}

	/**
	 * get the list of items
	 * @return
	 */
	public ArrayList<Item> getItemArray(){
		return itemArray;
	}
	
	/**
	 * get the list of explosions
	 * @return
	 */
	public ArrayList<Explosion> getExplosionArray(){
		return explosionArray;
	}
	
	/**
	 * get the list of bombs
	 * @return
	 */
	public ArrayList<Bomb> getBombArray() {
		return bombArray; 
	}
	
	/**
	 * get the list of walls
	 * @return
	 */
	public ArrayList<Wall> getWallArray() {
		return wallArray;
	}
	
	/**
	 * get the list of rocks
	 * @return
	 */
	public ArrayList<Rock> getRockArray() {
		return rockArray;
	}
	
	/**
	 * get the list of bosses
	 * @return
	 */
	public ArrayList<Boss> getBossArray() {
		return bossArray;
	}
	
	/**
	 * get the list of enemies
	 * @return
	 */
	public ArrayList<Enemy> getEnemyArray() {
		return enemyArray;
	}
	
	/**
	 * remove an explosion from the map
	 * @param index
	 */
	public void removeExplosion(int index){
		explosionArray.remove(index);
	}
	/**
	 * remove an enemy from the map
	 * @param index
	 */
	public void removeEnemy(int index){
		enemyArray.remove(index);
		addScore(20);
	}
	/**
	 * remove an wall from the map
	 * @param index
	 */
	public void removeWall(int index){
		wallArray.remove(index);
		addScore(30);
	}
	/**
	 * remove everything from the map
	 */
	public void removeAll(){
		player = new Player(32,32);
		bombArray.clear();
		wallArray.clear();
		rockArray.clear();
		itemArray.clear();
		enemyArray.clear();
		explosionArray.clear();
		scoreArray.clear();
		gameOver = false;
	}
	/**
	 * initilize the game, set the number of each units according to the levels
	 * @param lvl
	 */
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
		
		
	/**
	 * check if the game is over
	 */
	}
	public boolean isGameOver() {
		return gameOver;
	}

	/**
	 * make the game over
	 * @param gameOver
	 */
	public void setGameOver(boolean gameOver) {
		MainEngine.addToRecord(Integer.valueOf(Score));
		this.gameOver = gameOver;
	}
}
