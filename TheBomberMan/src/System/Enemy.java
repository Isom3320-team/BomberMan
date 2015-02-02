package System;

public class Enemy extends LivingObj {

	public Enemy(int x, int y) {
		super(x, y);
		
	}

	@Override
	public void die() {
		setDead(true);
		
	}
	

}
