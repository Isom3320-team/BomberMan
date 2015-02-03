package System;

public abstract class LivingObj extends Units implements Killable,Movable{

	private final int moveInc = 32;
	
	public LivingObj(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public void moveUp() {
		this.xCoord.set(getX() - moveInc);
	}
	
	public void moveDown() {
		this.xCoord.set(getX() + moveInc);
	}
	
	public void moveLeft(){
		this.yCoord.set(getY() - moveInc);
	}
	
	public void moveRight(){
		this.yCoord.set(getY() + moveInc);
	}
	
}
