package System;

import javafx.scene.image.Image;

public class Enemy extends LivingObj {

	
	public Enemy(int x, int y) {
		super(x, y);
		Image image = new Image("Image/minion.png", 32.0, 32.0, false, true);
		this.setImage(image);
		
	}
	
	
	@Override
	public void die() {
		setDead(true);
		
	}
	

}
