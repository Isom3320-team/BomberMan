package System;
import javafx.scene.image.Image;

/**
 * A minion is the most dump enemy in this game
 * @author shawn, jin, cyril
 *
 */
public class Minion extends Enemy {
	
	/**
	 * create a minion at (x,y) on the canvas
	 * @param x
	 * @param y
	 */
	public Minion(int x, int y) {
		super(x, y);
		Image image = new Image("Image/minion.png", 32.0, 32.0, false, true);
		this.setImage(image);
	}
}
