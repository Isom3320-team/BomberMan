package System;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import system.Player;
import System.Item.ItemType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player extends LivingObj{
	private int score, level, lives,maxBomb, bombRadius, blastRadius,speed;
	private boolean godmode, isAlive; 
	private String name;
	public static ArrayList<Player> playerArray;
	private boolean isActivePlayer;
	public Player(int x, int y) {
		super(x, y);
		
		Image image = new Image("Image/baozou.png", 100.0, 100.0, false, true);
		this.setImage(image);
		ImageView view = new ImageView();
		view.setImage(image);
		this.setView(view);
		lives = 3;
		maxBomb = 1;
		blastRadius = 2;
		level = 1;
		isAlive = true;
		godmode = false;
		name = "Default Name ";// to do: prompt the use to input the name;
		playerArray = new ArrayList<Player>();
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
	
	public void addScore(int addScore){
		this.score += addScore;
	}
	
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
	
	public void addPlayer(Player x) {
		playerArray.add(x);
	}
	public void removePlayer(int number) {
		playerArray.remove(number);
	}
	public ArrayList<Player> getPlayerArray() {
		return playerArray;
	}
	public static Player getActivePlayer() {

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
	}
}
