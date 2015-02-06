package System;
import javafx.scene.image.Image;

/**
 * A rock can't be destroyed!
 * @author shawn, jin, cyril
 *
 */
public class Rock extends NonLivingObj{

	/**
	 * create a rock at (x,y) on the map
	 * @param x
	 * @param y
	 */
	public Rock(int x, int y) {
		super(x, y);
		Image img = new Image("Image/rock.png",32,32,false,true);
		this.setImage(img);
		
	}
	

}
