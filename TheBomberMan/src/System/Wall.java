package System;

import java.util.ArrayList;

import system.HardBlock;


public class Wall extends NonLivingObj implements Killable {
	private ArrayList<Wall> wallArray;
	
	public Wall(int x, int y) {
		super(x, y);
		wallArray= new ArrayList<Wall>();
	}

	@Override
	public void die() {
		this.setDead(true);
	}
	
	public void addWall(Wall x) {
		wallArray.add(x);
	}
	public void removeWall(int number) {
		wallArray.remove(number);
	}
	public ArrayList<Wall> getWallArray() {
		return wallArray;
	}
}
