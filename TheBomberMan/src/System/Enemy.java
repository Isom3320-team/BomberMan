package System;

import javafx.scene.image.Image;

public class Enemy extends LivingObj {
	
	private boolean isUpdated = false;
	
	public Enemy(int x, int y) {
		super(x, y);
		Image image = new Image("Image/minion.png", 32.0, 32.0, false, true);
		this.setImage(image);
		
	}
	
	
	@Override
	public void die() {
		setDead(true);
		
	}
	
	/*@Override
	public void moveUp(){
		
		
	}
	
	@Override
	public void moveDown(){
		
		
	}
	@Override
	public void moveLeft(){
		
		
	}
	@Override
	public void moveRight(){
		
		
	}
	public void clearPath() {
		
		
	}*/
	

}
