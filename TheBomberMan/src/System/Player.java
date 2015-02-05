package System;
import java.util.Timer;
import java.util.TimerTask;

import System.Item.ItemType;
import javafx.scene.image.Image;

public class Player extends LivingObj{
	private int score, level, lives,maxBomb, blastRadius; //What are these unused variables?
	private boolean godmode; 
	private String name;

	
	public Player(){
		super(0, 0);
	}
	
	public Player(int x, int y) {
		super(x, y);
		
		Image image = new Image("Image/player.png", 32, 32, false, true);
		this.setImage(image);
		lives = 1;
		maxBomb = 1;
		blastRadius = 2;
		level = 1;
		godmode = false;
		name = "Default Name ";// to do: prompt the use to input the name;
		
	}
	
	public int getLive(){
		return lives;
	}
	
	public void setLives(int lives){
		this.lives = lives;
	}
	
	public int getMaxBomb(){
		return maxBomb;
	}
	
	public void setMaxBomb(int maxBomb){
		this.maxBomb = maxBomb;
	}
	
	public int getBombRadius(){
		return blastRadius;
	}
	
	public void setBombRadius(int br){
		this.blastRadius = br;
	}
	
	public int getScore(){
		return score;
	}
	
	public void setScore(int sc){
		this.score = sc;
	}
	/* no need this function 
	 * ex: setScore(getScore() +100)
	 
	public void addScore(int addScore){
		this.score += addScore;
	}
	 */
	
	public void consume(Item item){
		
		if(item.gettype() == ItemType.BLAST){
			this.blastRadius+=1;
		}else{
			this.maxBomb++;
		}
	}
	
	public int getLevel(){
		return level;
	}
	public void setLevel(int level){
		this.level = level;
	}
	public void levelUp(){
		this.level += 1;
	}
	public boolean isGodMode(){
		return godmode;
	}
	public void setGodMode(boolean god){
		this.godmode = god;
	}
	@Override
	public void die() {
		if (!godmode) {
			this.setDead(true);
			setCoordinates(32, 32);
			System.out.print(lives);
			this.lives--;
			System.out.print(lives);
			
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
