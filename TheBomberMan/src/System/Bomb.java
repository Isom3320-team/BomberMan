package System;
import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import System.Explosion;
import System.PhysicsManager;

/** A bomb is an unit that can be used to destroy other units
 *  
 * @author shawn, jin, cyril
 *
 */

public class Bomb extends NonLivingObj implements Killable {
	
	/**
	 * each bomb has a lifetime of 2 seconds
	 */
	
	private int lifeTime;
	private Timer timer = new Timer();
	
	/**
	 * create a bomb at location (x,y) on the canvas, start its timer
	 */
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
	
	/**
	 * Kills the bomb and stops the timer
	 */
	@Override
	public void die() {
		this.setDead(true);
		this.timer.cancel();
	}

}
