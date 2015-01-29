package System;

public class Wall extends NonLivingObj implements Killable {

	public Wall(int x, int y) {
		super(x, y);
		
	}

	@Override
	public void die() {
		this.setDead(true);
	}
	

}
