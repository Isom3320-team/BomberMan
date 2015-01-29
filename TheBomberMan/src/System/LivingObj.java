package System;

public abstract class LivingObj extends Units implements Killable,Movable{

	private final int moveInc = 32;
	
	public LivingObj(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public void moveUp() {
		setY(getY() - moveInc);
	}
	
	public void moveDown() {
		setY(getY() + moveInc);
	}
	
	public void moveLeft(){
		setX(getX() - moveInc);
	}
	
	public void moveRight(){
		setX(getX() + moveInc);
	}
	
}
