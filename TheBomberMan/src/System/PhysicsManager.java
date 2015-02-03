package System;

import java.util.ArrayList;

import System.CollisionType;
import System.Ghost;
import System.LivingObj;
import System.Units;
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
	static GameStatus game;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			}
		// to do : in the detector we need to use switch to distinguish different type of collision
		// this is useful and can save time
		public static boolean CollisionDetector(Units unit1, Units unit2,CollisionType type) {
			
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
		
		public static boolean canMove(Units unit1, CollisionType type) {
			
			for(int i=0; i < game.getWallArray().size(); i++) {
				if (CollisionDetector(unit1, game.getWallArray().get(i),type))
						return false;
				}
			
			for(int i=0; i < game.getRockArray().size(); i++) {
				if (CollisionDetector(unit1, game.getRockArray().get(i),type))
						return false;
				}
			
			if (unit1 instanceof Enemy) {
			for(int i=0; i < game.getEnemyArray().size(); i++) {
				if (CollisionDetector(unit1, game.getEnemyArray().get(i),type))
						return false;
				}
			}
			
		if (!(unit1 instanceof Bomb)) {
			for (int i = 0; i < game.getBombArray().size(); i++) {
				if (CollisionDetector(unit1, game.getBombArray().get(i),type)) {
					return false;
				}
			}
		}	
		return true;
		
	}
		//Both for Boss and Players
		 public boolean canPlaceBomb(Units unit1,CollisionType type) {
			 
		 
			 	for(int i=0; i < game.getWallArray().size(); i++) {
					if (CollisionDetector(unit1, game.getWallArray().get(i),type))
							return false;
					}
				
				for(int i=0; i < game.getRockArray().size(); i++) {
					if (CollisionDetector(unit1, game.getRockArray().get(i),type))
							return false;
					}
				
				for(int i=0; i < game.getEnemyArray().size(); i++) {
					if (CollisionDetector(unit1, game.getEnemyArray().get(i),type))
							return false;
					}
								
				for (int i = 0; i < game.getBombArray().size(); i++) {
					if (CollisionDetector(unit1, game.getBombArray().get(i),type)) 
						return false;
					}
				

			int playerBombs = 0;
			if(unit1 instanceof Player) {
				for (int i = 0; i < game.getBombArray().size(); i++) {
					if (!game.getBombArray().get(i).getbossBomb()) {
						playerBombs++;
					}
				}
				if (((Player) unit1).getMaxBomb() == playerBombs) {
				return false;
				}
			}	
		return true;
		} 
		 
		 public boolean hitsEnemy(Units unit1,CollisionType type) {
				for (int i = 0; i < game.getEnemyArray().size(); i++) {
					if (CollisionDetector(unit1, game.getEnemyArray().get(i),type)) {
						return true;
					}
				}
				return false;
			}
		 
		 public void explodeBomb(int bombX) {

				boolean canExpUp = true;
				boolean canExpDown = true;
				boolean canExpLeft = true;
				boolean canExpRight = true;
				int playerBlastRadius = 2; //bombX.ItemType ??? + set ItemType --> Range of the blast
				int bossBlastRadius = 2; //bombX.Type ???


				// adds explosion outwards 
				for (int i = 0; i < (game.getBombArray().get(bombX).getbossBomb() ? bossBlastRadius
						: playerBlastRadius); i++) {

					// up
					Explosion up = new Explosion(game.getBombArray().get(bombX).getX(),
							 game.getBombArray().get(bombX).getY()); 
							// - i * game.yInc (yInc = 32) needed?
							
			/*	do
					if canMove(game.getBombArray().get(bombX).getX()+increment)
						Explosion
				while */
					
					if (canExpUp) {
						if (game.getBombArray().get(bombX).isBossBomb()) {
							up.setBossExplosion(true);
						}
						game.addExplosion(up);
					}

					if (!canMove(up, CollisionType.UP)) {
						canExpUp = false;
					}

					// down
					Explosion down = new Explosion(game.getBombArray().get(bombX).getX(), game
							.getBombArray().get(bombX).getY()
							+ i * game.inc);

					if (canExpDown) {
						if (game.getBombArray().get(bombX).isBossBomb()) {
							down.setBossExplosion(true);
						}
						game.addExplosion(down);
					}

					if (!canMove(down, CollisionType.DOWN)) {
						canExpDown = false;
					}

					// left
					Explosion left = new Explosion(game.getBombArray().get(bombX).getX() - i
							* game.inc, game.getBombArray().get(bombX).getY());

					if (canExpLeft) {
						if (game.getBombArray().get(bombX).isBossBomb()) {
							left.setBossExplosion(true);
						}
						game.addExplosion(left);
					}

					if (!canMove(left, CollisionType.LEFT)) {
						canExpLeft = false;
					}

					// right
					Explosion right = new Explosion(game.getBombArray().get(bombX).getX() + i
							* game.inc, game.getBombArray().get(bombX).getY());

					if (canExpRight) {
						if (game.getBombArray().get(bombX).isBossBomb()) {
							right.setBossExplosion(true);
						}
						game.addExplosion(right);
					}

					if (!canMove(right, CollisionType.RIGHT)) {
						canExpRight = false;
					}

				}

				game.removeBomb(bombX);// change the remove method in the gamestatus 
			}	
		 
}