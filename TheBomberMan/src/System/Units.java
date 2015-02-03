package System;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.beans.property.*;

public abstract class Units {
	private IntegerProperty xCoord = new SimpleIntegerProperty(0);
	private IntegerProperty yCoord = new SimpleIntegerProperty(0);
	
	private Image image;
	private ImageView view;
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
	public ImageView getView() {
		return view;
	}
	public void setView(ImageView view) {
		this.view = view;
	}
	public void setView(){
		ImageView iv = new ImageView(this.getImage());
		this.view = iv ;
	}

	/**this paint method draw an image on the graphics context on the canvas
	 * 
	 * @param gc
	 * @param unit
	 */
	
	public void paint(GraphicsContext gc, Units unit){
		gc.drawImage(unit.getImage(), unit.getX(), unit.getY());
	}
}

