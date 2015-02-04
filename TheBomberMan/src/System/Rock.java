package System;

import javafx.scene.image.Image;

public class Rock extends NonLivingObj{

	public Rock(int x, int y) {
		super(x, y);
		Image img = new Image("Image/item 1.png",32,32,false,true);
		this.setImage(img);
		
	}
	

}
