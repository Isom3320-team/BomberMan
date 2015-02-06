package System;
import javafx.scene.image.Image;

/**
 * An enemy is an object that the player should aim to kill
 * @author shawn, jin, cyril
 *
 */
public class Enemy extends LivingObj {

	/**
	 * Create an enemy at (x,y) on the canvas
	 * @param x
	 * @param y
	 */
	public Enemy(int x, int y) {
		super(x, y);
		Image image = new Image("Image/minion.png", 32.0, 32.0, false, true);
		this.setImage(image);
		
	}
	
	
	/**
	 * kill the enemy
	 */
	@Override
	public void die() {
		setDead(true);
		
	}
	

}
