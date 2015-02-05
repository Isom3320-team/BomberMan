package System;
import javafx.scene.image.Image;

public class Wall extends NonLivingObj implements Killable {

	public Wall(int x, int y) {
		super(x, y);
		Image img = new Image("Image/explosion.png",32,32,false,true);
		this.setImage(img);
	}

	@Override
	public void die() {
		this.setDead(true);
	}
	

}
