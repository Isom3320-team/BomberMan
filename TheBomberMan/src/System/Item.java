package System;
import java.util.Random;

import javafx.scene.image.Image;

/**
 * An item is an unit that can be consumed by the player to increase its power
 * @author shawn, jin, cyril
 *
 */

public class Item extends NonLivingObj {
	
	/**
	 * It contains a random number so to give random type of items
	 */
	Random r = new Random();
	ItemType type;
	
	enum ItemType{
		BLAST, BOMB ;
	}
	
	/**
	 * add an item to the map at (x,y) on the canvas
	 * @param x
	 * @param y
	 */
	
	public Item(int x, int y) {
		super(x, y);
		if (r.nextInt(100)<50){
			settype(ItemType.BLAST);
			this.setImage(new Image("Image/item 1.png", 32.0, 32.0, false, true));
		}
		else {
			settype(ItemType.BOMB);
			this.setImage(new Image("Image/item 2.png", 32.0, 32.0, false, true));
		}
	}
	
	/**
	 * get the type of the item
	 * @return
	 */
	public ItemType gettype(){
		return type;
	}
	/**
	 * set the type of the item
	 * @param type
	 */
	public void settype(ItemType type){
		this.type = type;
	}
 
}
