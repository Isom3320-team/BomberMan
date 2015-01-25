package System;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player extends LivingObj{

	public Player(int x, int y) {
		super(x, y);
		
		Image image = new Image("Image/baozou.png", 100.0, 100.0, false, true);
		this.setImage(image);
		ImageView view = new ImageView();
		view.setImage(image);
		this.setView(view);

		// TODO Auto-generated constructor stub		
	}
}
