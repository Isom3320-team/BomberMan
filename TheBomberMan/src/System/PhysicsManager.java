package System;

import java.util.ArrayList;

import system.Bomb;
import system.Difficulty;
import system.Enemy;
import system.Explosion;
import system.HardBlock;
import system.Player;
import system.Powerup;
import system.SoftBlock;

public abstract class  PhysicsManager implements Runnable{
	static int increment;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			}
		
		public static boolean CollisionDetector(Units unit1, Units unit2) {
			if (unit1.getX() == unit2.getX() && unit1.getY() == unit2.getY() + increment)
				return true;
			else if (unit1.getY() == unit2.getY() && unit1.getX() == unit2.getX() + increment)
				return true;
			else if (unit1.getX() == unit2.getX() && unit1.getY() == unit2.getY() - increment)
				return true;
			else if (unit1.getY() == unit2.getY() && unit1.getX() == unit2.getX() - increment)
				return true;
			else
				return false;
		}
		
		public static boolean canMove(Units unit1) {
			for(int i=0; i < Units.getUnitsArray().size(); i++) {
				if (CollisionDetector(unit1, Units.getUnitsArray().get(i)))
						return false;
				}
		}

		private ArrayList<Player> playerArray = new ArrayList<Player>();
		private ArrayList<Wall> wallArray= new ArrayList<Wall>();
		private ArrayList<Rock> rockArray= new ArrayList<Rock>();
		private ArrayList<Enemy> enemyArray= new ArrayList<Enemy>();
		private ArrayList<Bomb> bombArray= new ArrayList<Bomb>();
		private ArrayList<Minion> minionArray= new ArrayList<Minion>();
		private ArrayList<Item> itemArray= new ArrayList<Item>();
		
}