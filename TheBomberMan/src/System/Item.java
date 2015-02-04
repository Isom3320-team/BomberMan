package System;

import java.util.Random;

import javafx.scene.image.Image;

public class Item extends NonLivingObj {
	
	Random r = new Random();
	ItemType type;
	
	enum ItemType{
		BLAST, BOMB ,SPEED;
	}
	
	public Item(int x, int y) {
		super(x, y);
		Image image = new Image("Image/item 3.png", 32.0, 32.0, false, true);
		this.setImage(image);
		if (r.nextInt(100)<30){
			settype(ItemType.BLAST);
		}
		else if ((r.nextInt(100)<70)&&(r.nextInt(100)>30)){
			settype(ItemType.BOMB);
		}else{
			settype(ItemType.SPEED);
		}
	}
	
	public ItemType gettype(){
		return type;
		
	}
	public void settype(ItemType type){
		this.type = type;
	}
 
}
