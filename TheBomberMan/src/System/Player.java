package System;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player extends LivingObj{
	int score, level, lives,maxBomb, bombRadius;
	boolean godmode; 
	public Player(int x, int y) {
		super(x, y);
		
		Image image = new Image("Image/baozou.png", 100.0, 100.0, false, true);
		this.setImage(image);
		ImageView view = new ImageView();
		view.setImage(image);
		this.setView(view);

		// TODO Auto-generated constructor stub		
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
		// TODO Auto-generated method stub
		
	}
}
