package System;
import javafx.scene.image.Image;

public class Player extends LivingObj{

	public Player(int x, int y) {
		super(x, y);
		Image image = new Image("http://3.bp.blogspot.com/-cm32xlxpRpM/UwVnRoHb5GI/AAAAAAAAAHM/iKj6UABgbeo/s1600/Rage+Comic+App.png", 100.0, 100.0, false, true);
		this.setImage(image);
		// TODO Auto-generated constructor stub		
	}
}
