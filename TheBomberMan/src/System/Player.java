package System;
import java.util.Timer;
import java.util.TimerTask;

import System.Item.ItemType;
import javafx.scene.image.Image;

public class Player extends LivingObj{
	private int score, level, lives,maxBomb, bombRadius, blastRadius, speed; //What are these unused variables?
	private boolean godmode, isAlive; 
	private String name;
	private boolean isActivePlayer;
	
	public Player(){
		super(0, 0);
	}
	
	public Player(int x, int y) {
		super(x, y);
		
		Image image = new Image("Image/player.png", 32, 32, false, true);
		this.setImage(image);
		lives = 3;
		maxBomb = 1;
		blastRadius = 2;
		level = 1;
		isAlive = true;
		godmode = false;
		name = "Default Name ";// to do: prompt the use to input the name;
		isActivePlayer = true;
	}
	
	public int giveLive(){
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
		return bombRadius;
	}
	
	public void setBombRadius(int br){
		this.bombRadius = br;
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
		// to do: get the Item type and add attributes to the player
		if(item.gettype() == ItemType.BLAST){
			this.blastRadius+=5;// to decide how much to increase 
		}else if (item.gettype() == ItemType.BOMB){
			this.maxBomb++;
		}else{
			this.speed+=4;// to decide how much to increase
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
			this.lives--;
			this.maxBomb = 1;
			this.blastRadius = 2;
			this.godmode = true;
			Timer timer = new Timer();
			timer.schedule(new TimerTask(){
				public void run(){
					godmode = false;
				}
			}, 1000);
		}
		// to do: commit the score to the GameEngine;
	}
/*	
	public void addPlayer(Player x) {
		playerArray.add(x);
	}
	public void removePlayer(int number) {
		playerArray.remove(number);
	}
	public ArrayList<Player> getPlayerArray() {
		return playerArray;
	}
	public Player getActivePlayer() {

		if (playerArray.get(1).isActivePlayer()) {
			return playerArray.get(1);
		} else {
			return playerArray.get(0);
		}
	}
	public boolean isActivePlayer() {
		return isActivePlayer;
	}
	public void setActivePlayer(boolean isActivePlayer) {
		this.isActivePlayer = isActivePlayer;
	}
	public void switchActivePlayers() {
		if (playerArray.size() == 2) {

			if (playerArray.get(0).isActivePlayer()) {
				playerArray.get(0).setActivePlayer(false);
				playerArray.get(1).setActivePlayer(true);
			} else {
				playerArray.get(0).setActivePlayer(true);
				playerArray.get(1).setActivePlayer(false);
			}
		}
	}*/
	
}
