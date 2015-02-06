package System;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.beans.property.*;

/**
 * All the things in the game are units
 * @author shawn, jin, cyril
 *
 */
public abstract class Units {
	
	/**
	 * A units has two intergerProperty in order to be drawn on the canvas
	 * each unit has image
	 * and a status whether it is dead
	 */
	protected IntegerProperty xCoord = new SimpleIntegerProperty(0);
	protected IntegerProperty yCoord = new SimpleIntegerProperty(0);
	private Image image;
	private boolean isDead = false;
	
	/**
	 * create an unit at (0,0) on the canvas
	 */
	public Units(){
		this.xCoord = new SimpleIntegerProperty(0);
		this.yCoord = new SimpleIntegerProperty(0);
		this.isDead = false;
	}
	
	/**
	 * create an unit at (x,y) on the canvs
	 * @param x
	 * @param y
	 */
	public Units(int x, int y) {
		this.xCoord = new SimpleIntegerProperty(x);
		this.yCoord = new SimpleIntegerProperty(y);
		this.isDead = false;
	}
	
	/**
	 * get the x intergerproperty of the unit
	 * @return
	 */
	public IntegerProperty xCoord() {
		return xCoord;
	}
	
	/**
	 * get the x coord
	 * @return
	 */
	public int getX(){
		return xCoord.get();
	}
	
	/**
	 * set the x intergerproperty
	 * @param x
	 */
	public void setX(int x) {
		this.xCoord.set(x);
	}
	/**
	 * get the y intergerproperty of the unit
	 * @return
	 */
	public IntegerProperty yCoord(){
		return yCoord;
	}
	
	/**
	 * get the y coord
	 * @return
	 */
	public int getY() {
		return yCoord.get();
	}
	/**
	 * set the y intergerproperty
	 * @param y
	 */
	public void setY(int y) {
		this.yCoord.set(y);
	}
	
	/**
	 * set the coordinates of the unit
	 * @param x
	 * @param y
	 */
	public void setCoordinates(int x, int y) {
		this.xCoord.set(x);
		this.yCoord.set(y);
	}
	
	/**
	 * check if unit died
	 * @return
	 */
	public boolean isDead() {
		return isDead;
	}
	/**
	 * make unit die
	 * @param isDead
	 */
	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	
	/**
	 * get image of unit
	 * @return
	 */
	public Image getImage() {
		return image;
	}
	/**
	 * set image of unit
	 * @param image
	 */
	public void setImage(Image image) {
		this.image = image;
	}

	/**this paint method draw an image on the graphics context on the canvas
	 * 
	 * @param gc
	 * @param unit
	 */
	
	public void paint(GraphicsContext gc){
		if(this.getImage()!=null){
		gc.drawImage(this.getImage(), this.getX(), this.getY());
		}else{
			
		}
	}
	/**
	 * remove the unit from canvas
	 * @param gc
	 */
	public void clear(GraphicsContext gc){
		gc.clearRect(this.getX(), this.getY(), 32, 32);
	}
	
}

