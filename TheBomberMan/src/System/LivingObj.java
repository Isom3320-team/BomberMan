package System;

/**
 * All livingobj are killable and movable
 * @author shawn, jin, cyril
 *
 */
public abstract class LivingObj extends Units implements Killable,Movable{

	/**
	 * the movement of each livingObj is 32 pixels
	 */
	private final int moveInc = 32;
	
	/**
	 * create an LivingObj on the (x,y) on the canvas
	 * @param x
	 * @param y
	 */
	public LivingObj(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	/**
	 * move the unit Up
	 */
	public void moveUp() {
		this.yCoord.set(getY() - moveInc);
	}
	/**
	 * move the unit Down
	 */
	public void moveDown() {
		this.yCoord.set(getY() + moveInc);
	}
	
	/**
	 * move the unit left
	 */
	public void moveLeft(){
		this.xCoord.set(getX() - moveInc);
	}
	
	/**
	 * move the unit right
	 */
	public void moveRight(){
		this.xCoord.set(getX() + moveInc);
	}
	
}
