package System;
import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bomb extends NonLivingObj implements Killable {
	
	private int lifeTime;
	private Timer timer = new Timer();
	private boolean bossBomb = false;
	
	public Bomb(int x, int y) {
		super(x, y);
		lifeTime = 5000;
		Image image = new Image("Image/baozou.png", 50.0, 50.0, false, true);
		this.setImage(image);
		ImageView imgView = new ImageView(image);
		this.setView(imgView);
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
	
	public void setbossBomb(boolean bossBomb){
		this.bossBomb = bossBomb;
	}
	public boolean getbossBomb(){
		return bossBomb;
	}

}
