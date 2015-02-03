package System;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.beans.property.*;

public abstract class Units {
	private int xCoord;
	private int yCoord;
	private Image image;
	private ImageView view;
	private boolean isDead;
	
	
	
	public Units(int x, int y) {
		this.xCoord = x;
		this.yCoord = y;
		this.isDead = false;
	}
	
	public int getX() {
		return xCoord;
	}
	
	public void setX(int xCoord) {
		this.xCoord = xCoord;
	}
	
	public int getY() {
		return yCoord;
	}
	
	public void setY(int yCoord) {
		this.yCoord = yCoord;
	}
	
	public void setCoordinates(int xCoord, int yCoord) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}
	
	public Image getImage() {
		return image;
	}
	
	public void setImage(Image image) {
		this.image = image;
	}
	
	public boolean isDead() {
		return isDead;
	}
	
	public void setDead(boolean isDead) {
		this.isDead = isDead;
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

}

