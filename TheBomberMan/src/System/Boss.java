package System;
import javafx.scene.image.Image;

public class Boss extends FlyMinion {

	
	
	public Boss(int x, int y){
		super(x,y);
		
		Image image = new Image("Image/boss.png", 32.0, 32.0, false, true);
		this.setImage(image);
	}
		
	
	@Override
	public void die(){
		this.setDead(true);
		
	}
}
