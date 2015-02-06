package System;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.image.Image;

public class Boss extends FlyMinion {
	Timer timer = new Timer(false);
	long placeBombDelay;

	
	
	public Boss(int x, int y){
		super(x,y);
		placeBombDelay = 5000;
		Image image = new Image("Image/boss.png", 32.0, 32.0, false, true);
		this.setImage(image);
		
		timer.schedule(new TimerTask(){
			@Override
			public void run(){
				//Bomb bossBomb = new Bomb(x,y);
				//bossBomb.setbossBomb(true);
			}
		}, 5000, placeBombDelay);
	}
	
	
	@Override
	public void die(){
		this.setDead(true);
		this.timer.cancel();
	}
}
