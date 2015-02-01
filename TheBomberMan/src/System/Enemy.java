package System;

import java.util.ArrayList;

import system.Enemy;
import system.GameEngine;

public class Enemy extends LivingObj {
	private ArrayList<Enemy> enemyArray;
	
	public Enemy(int x, int y) {
		super(x, y);
		enemyArray= new ArrayList<Enemy>();
	}

	@Override
	public void die() {
		setDead(true);
		
	}
	public void addEnemy(Enemy x) {
		enemyArray.add(x);
	}
	public void removeEnemy(int number) {
		enemyArray.remove(number);
	//	GameEngine.s.playSound("/sounds/hadoken.wav", false);
		Player.getActivePlayer().incrementScore(10 * getScoreIncrement());
	}
	public ArrayList<Enemy> getEnemyArray() {
		return enemyArray;
	}
}
