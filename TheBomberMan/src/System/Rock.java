package System;

import java.util.ArrayList;
import java.util.Random;

import system.HardBlock;


public class Rock extends NonLivingObj{
	private ArrayList<Rock> rockArray;
	
	public Rock(int x, int y) {
		super(x, y);
		rockArray= new ArrayList<Rock>();
	}
	
	public void addRock(Rock x) {
		rockArray.add(x);
	}
	public void removeRock(int number) {

		int proba;
		String difficulty = Difficulty.getDifficulty();
		
		if (difficulty == "EASY") 
			proba = 10;
		 else if (difficulty == "MEDIUM") 
			proba = 8;
		else if (difficulty == "HARD")
			proba = 6;	
		else if (difficulty == "GOD")
			proba = 4;
		 else {
			proba = 2;
		}

		if (proba > (int)(Math.random()*100)+1 ) {
			powerups.add(new Powerup(rockArray.get(number).getxPos(), //havent checked what powerUp is
					rockArray.get(number).getyPos()));
		}
		rockArray.remove(number);

		if (Player.playerArray.size() != 0)
			Player.getActivePlayer().incrementScore(10 * getScoreIncrement());
	}
	public ArrayList<Rock> getRockArray() {
		return rockArray;
	}
}
