package System;
import javafx.scene.image.Image;

/**
 * A wall can be destroyed
 * @author shawn, jin, cyril
 *
 */
public class Wall extends NonLivingObj implements Killable {

	/**
	 * create the wall at (x,y) on the canvas
	 * @param x
	 * @param y
	 */
	public Wall(int x, int y) {
		super(x, y);
		Image img = new Image("Image/wall.png",32,32,false,true);
		this.setImage(img);
	}

	/**
	 * kill the wall
	 */
	@Override
	public void die() {
		this.setDead(true);
		System.out.println("wall die");
	}
	

}
