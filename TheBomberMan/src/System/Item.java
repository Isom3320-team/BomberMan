package System;

import java.util.Random;

import javafx.scene.image.Image;

public class Item extends NonLivingObj {
	
	Random r = new Random();
	ItemType type;
	
	enum ItemType{
		BLAST, BOMB ;
	}
	
	public Item(int x, int y) {
		super(x, y);
		Image image = new Image("Image/item 2.png", 32.0, 32.0, false, true);
		this.setImage(image);
		if (r.nextInt(100)<50){
			settype(ItemType.BLAST);
			//this.setImage(new Image("Image/item.png", 32.0, 32.0, false, true));
		}
		else {
			settype(ItemType.BOMB);
			//this.setImage(new Image("Image/item 2.png", 32.0, 32.0, false, true));
		}
	}
	
	public ItemType gettype(){
		return type;
	}
	public void settype(ItemType type){
		this.type = type;
	}
 
}
