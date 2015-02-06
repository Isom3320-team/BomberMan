package System;
import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import System.Explosion;
import System.PhysicsManager;

public class Bomb extends NonLivingObj implements Killable {
	
	private int lifeTime;
	private Timer timer = new Timer();
	
	public Bomb(int x, int y) {
		super(x, y);
		lifeTime = 2000;
		Image image = new Image("Image/bomb.png", 32.0, 32.0, false, true);
		this.setImage(image);
		timer.schedule(new TimerTask(){
		@Override
		public void run(){
			die();
		}
	}, lifeTime);
	}

	@Override
	public void die() {
		this.setDead(true);
		
		this.timer.cancel();
	}

}
