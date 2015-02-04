package System;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.beans.property.*;

public abstract class Units {
	protected IntegerProperty xCoord = new SimpleIntegerProperty(0);
	protected IntegerProperty yCoord = new SimpleIntegerProperty(0);
	
	private Image image;
	private boolean isDead;
	
	public Units(){
		this.xCoord = new SimpleIntegerProperty(0);
		this.yCoord = new SimpleIntegerProperty(0);
		this.isDead = false;
	}
	
	public Units(int x, int y) {
		this.xCoord = new SimpleIntegerProperty(x);
		this.yCoord = new SimpleIntegerProperty(y);
		this.isDead = false;
	}
	
	public IntegerProperty xCoord() {
		return xCoord;
	}
	
	public int getX(){
		return xCoord.get();
	}
	
	public void setX(int x) {
		this.xCoord.set(x);
	}
	
	public IntegerProperty yCoord(){
		return yCoord;
	}
	
	public int getY() {
		return yCoord.get();
	}
	
	public void setY(int y) {
		this.yCoord.set(y);
	}
	
	public void setCoordinates(int x, int y) {
		this.xCoord.set(x);
		this.yCoord.set(y);
	}
	
	public boolean isDead() {
		return isDead;
	}
	
	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	
	
	public Image getImage() {
		return image;
	}
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
			System.out.print("paint player");
		}
	}
}

