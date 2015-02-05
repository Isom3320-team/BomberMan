package System;


import java.util.Timer;
import java.util.TimerTask;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.Timer;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Explosion extends NonLivingObj implements Killable {
	private int lifeTime;
	private Timer timer = new Timer();
	private boolean bossExplosion = false;
	
	public Explosion(int x, int y) {
		super(x, y);
		lifeTime = 500;
		Image image = new Image("Image/explosion.png", 32.0, 32.0, false, true);
		this.setImage(image);
		
		
		( timer).schedule(new TimerTask(){
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




	
	public void setBossExplosion(boolean bossBomb){
		this.bossExplosion = bossBomb;
	}
	public boolean getBossExplosion(){
		return bossExplosion;
	}
}

