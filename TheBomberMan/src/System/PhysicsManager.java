package System;

import java.util.ArrayList;

import system.Ghost;
import system.LivingUnit;
import System.Bomb;
import System.Difficulty;
import System.Enemy;
import System.Explosion;
import System.Rock;
import System.Player;
import System.Item;
import System.Wall;

public abstract class  PhysicsManager implements Runnable{
	static int increment;
	static GameStatus gs;
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
			
			for(int i=0; i < gs.getWallArray().size(); i++) {
				if (CollisionDetector(unit1, gs.getWallArray().get(i)))
						return false;
				}
			
			for(int i=0; i < gs.getRockArray().size(); i++) {
				if (CollisionDetector(unit1, gs.getRockArray().get(i)))
						return false;
				}
			
			if (unit1 instanceof Enemy) {
			for(int i=0; i < gs.getEnemyArray().size(); i++) {
				if (CollisionDetector(unit1, gs.getEnemyArray().get(i)))
						return false;
				}
			}
			
			for (int i = 0; i < gs.getBombArray().size(); i++) {
				if (CollisionDetector(unit1, gs.getBombArray().get(i))) {
					return false;
				}
		}
		return true;
		
	}
		
		/* public boolean canPlaceBomb(Player player) {
			for (int i = 0; i < gs.getHardBlocks().size(); i++) {
				if (collidesWith(p, gs.getHardBlocks().get(i),
						CollisionType.OVERLAP)) {
					return false;
				}
			}

			for (int i = 0; i < gs.getSoftBlocks().size(); i++) {
				if (collidesWith(p, gs.getSoftBlocks().get(i),
						CollisionType.OVERLAP)) {
					return false;
				}
			}

			for (int i = 0; i < gs.getBombs().size(); i++) {
				if (collidesWith(p, gs.getBombs().get(i), CollisionType.OVERLAP)) {
					return false;
				}
			}

			int counter = 0;

			for (int i = 0; i < gs.getBombs().size(); i++) {
				if (!gs.getBombs().get(i).isBossBomb()) {
					counter++;
				}
			}
			if (p.getMaxBombs() == counter) {
				return false;
			}

			return true;
		} */
}