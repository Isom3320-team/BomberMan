package System;
import javafx.scene.image.Image;

/** A boss is a different looking enemy!
 *  
 * @author shawn, jin, cyril
 *
 */
public class Boss extends FlyMinion {
	
	/**
	 * create a boss at location (x,y) on the canvas
	 * @param x
	 * @param y
	 */
	public Boss(int x, int y){
		super(x,y);
		
		Image image = new Image("Image/boss.png", 32.0, 32.0, false, true);
		this.setImage(image);
	}
		
	/**
	 * Kills the boss
	 */
	@Override
	public void die(){
		this.setDead(true);
		
	}
}
