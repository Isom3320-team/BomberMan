package System;
import java.util.Timer;
import java.util.TimerTask;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.Timer;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * A explosion is blasted from a dead bomb and removes other unit when touches it.
 * @author shawn, jin, cyril
 *
 */

public class Explosion extends NonLivingObj implements Killable {
	
	/**
	 * each explosion has a lifetime of 0.5 seconds
	 */
	private int lifeTime;
	private Timer timer = new Timer();
	
	public Explosion(int x, int y) {
		
		/**
		 * create a new explosion at (x,y) on the canvas
		 */
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
	
	/**
	 * kill the explosion
	 */

	@Override
	public void die() {
		this.setDead(true);
		this.timer.cancel();
	}
}

