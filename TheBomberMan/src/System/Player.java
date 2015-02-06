package System;
import java.util.Timer;
import java.util.TimerTask;

import System.Item.ItemType;
import javafx.scene.image.Image;

/**
 * A player is where we play!
 * @author shawn, jin, cyril
 *
 */
public class Player extends LivingObj{
	/**
	 * A player has level, lives, certain number of bombs, bomb has radius
	 * 
	 */
	private int  level, lives,maxBomb, blastRadius; //What are these unused variables?
	private boolean godmode; 

	/**
	 * create a player at (0,0) on the canvas
	 */
	public Player(){
		super(0, 0);
	}
	
	/**
	 * create a player at (x,y) on the canvs
	 * @param x
	 * @param y
	 */
	public Player(int x, int y) {
		super(x, y);
		
		Image image = new Image("Image/player.png", 32, 32, false, true);
		this.setImage(image);
		lives = 1;
		maxBomb = 1;
		blastRadius = 2;
		level = 1;
		godmode = false; 
		
	}
	
	/**
	 * get the lives of player
	 * @return
	 */
	public int getLive(){
		return lives;
	}

	/**
	 * set the lives of player
	 * @param lives
	 */
	public void setLives(int lives){
		this.lives = lives;
	}
	
	/**
	 * get max bombs
	 * @return
	 */
	public int getMaxBomb(){
		return maxBomb;
	}
	
	/**
	 * set max bombs
	 * @param maxBomb
	 */
	public void setMaxBomb(int maxBomb){
		this.maxBomb = maxBomb;
	}
	
	/**
	 * get bomb radius
	 * @return
	 */
	public int getBombRadius(){
		return blastRadius;
	}
	
	/**
	 * set bomb radius
	 * @param br
	 */
	public void setBombRadius(int br){
		this.blastRadius = br;
	}
	
	/**
	 * eat the itme
	 * @param item
	 */
	
	public void consume(Item item){
		
		if(item.gettype() == ItemType.BLAST){
			this.blastRadius+=1;
		}else{
			this.maxBomb++;
		}
	}
	
	/**
	 * get the level
	 * @return
	 */
	public int getLevel(){
		return level;
	}
	/**
	 * set the level
	 * @param level
	 */
	public void setLevel(int level){
		this.level = level;
	}
	/**
	 * level up the player
	 */
	public void levelUp(){
		this.level += 1;
	}
	
	/**
	 * kill the player
	 */
	@Override
	public void die() {
		if (!godmode) {
			this.setDead(true);
			setCoordinates(32, 32);
			
			this.lives--;
			
			if(lives==0){
			   this.setDead(true);
		}
			
			this.maxBomb = 1;
			this.blastRadius = 2;
			this.godmode = true;
			Timer timer = new Timer();
			timer.schedule(new TimerTask(){
				public void run(){
					godmode = false;
				}
			}, 500);
	
		}
		// to do: commit the score to the GameEngine;
	}

	
}
