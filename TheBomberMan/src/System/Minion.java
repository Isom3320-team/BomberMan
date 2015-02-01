package System;

import java.util.ArrayList;

public class Minion extends Enemy {

	private ArrayList<Minion> minionArray;
	public Minion(int x, int y) {
		super(x, y);
		minionArray= new ArrayList<Minion>();
	}
	@Override
	public void die() {
		setDead(true);
		
	}
	public void addMinion(Minion x) {
		minionArray.add(x);
	}
	public void removeMinion(int number) {
		minionArray.remove(number);
	//	GameEngine.s.playSound("/sounds/hadoken.wav", false);
		Player.getActivePlayer().incrementScore(20 * getScoreIncrement());
	}
	public ArrayList<Minion> getMinionArray() {
		return minionArray;
	}
}
