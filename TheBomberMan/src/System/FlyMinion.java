package System;
import javafx.scene.image.Image;

/**
 * A flying minion is an enemy that can fly over wall!
 * @author shawn, jin, cyril
 *
 */
public class FlyMinion extends Minion{

	/**
	 * create an flying minion at (x,y) on the canvas
	 * @param x
	 * @param y
	 */
	public FlyMinion(int x, int y) {
		super(x, y);
		Image image = new Image("Image/minion.png", 32.0, 32.0, false, true);
		this.setImage(image);
	}

}
