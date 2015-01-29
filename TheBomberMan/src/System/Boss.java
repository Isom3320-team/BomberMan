package System;
import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.image.Image;

public class Boss extends Minion {
	Timer timer = new Timer(false);
	long placeBombDelay;
	
	
	public Boss(int x, int y){
		super(x,y);
		placeBombDelay = 5000;
		Image image = new Image("Image/baozou.png", 50.0, 50.0, false, true);
		this.setImage(image);
		this.setView();
		timer.schedule(new TimerTask(){
			@Override
			public void run(){
				Bomb bossBomb = new Bomb(x,y);
				bossBomb.setbossBomb(true);
				// to do: to declare the bossBomb in the game engine 
			}
		}, 5000, placeBombDelay);
	}

	@Override
	public void die(){
		this.setDead(true);
		this.timer.cancel();
	}
}
