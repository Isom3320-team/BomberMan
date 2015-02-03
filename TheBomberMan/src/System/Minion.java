package System;

import javafx.scene.image.Image;

public class Minion extends Enemy {
	
	public Minion(int x, int y) {
		super(x, y);
		Image image = new Image("Image/minion.png", 50.0, 50.0, false, true);
	}
}
