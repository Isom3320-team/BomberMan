package System;

import java.util.ArrayList;

import system.CollisionType;
import system.Ghost;
import system.LivingUnit;
import system.MapObject;
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
			
			for(int i=0; i < game.getWallArray().size(); i++) {
				if (CollisionDetector(unit1, game.getWallArray().get(i)))
						return false;
				}
			
			for(int i=0; i < game.getRockArray().size(); i++) {
				if (CollisionDetector(unit1, game.getRockArray().get(i)))
						return false;
				}
			
			if (unit1 instanceof Enemy) {
			for(int i=0; i < game.getEnemyArray().size(); i++) {
				if (CollisionDetector(unit1, game.getEnemyArray().get(i)))
						return false;
				}
			}
			
		if (!(unit1 instanceof Bomb)) {
			for (int i = 0; i < game.getBombArray().size(); i++) {
				if (CollisionDetector(unit1, game.getBombArray().get(i))) {
					return false;
				}
			}
		}	
		return true;
		
	}
		//Both for Boss and Players
		 public boolean canPlaceBomb(Units unit1) {
			 
		 
			 	for(int i=0; i < game.getWallArray().size(); i++) {
					if (CollisionDetector(unit1, game.getWallArray().get(i)))
							return false;
					}
				
				for(int i=0; i < game.getRockArray().size(); i++) {
					if (CollisionDetector(unit1, game.getRockArray().get(i)))
							return false;
					}
				
				for(int i=0; i < game.getEnemyArray().size(); i++) {
					if (CollisionDetector(unit1, game.getEnemyArray().get(i)))
							return false;
					}
								
				for (int i = 0; i < game.getBombArray().size(); i++) {
					if (CollisionDetector(unit1, game.getBombArray().get(i))) 
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
		 
		 public boolean hitsEnemy(Units unit1) {
				for (int i = 0; i < game.getEnemyArray().size(); i++) {
					if (CollisionDetector(unit1, game.getEnemyArray().get(i))) {
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
						if (gs.getBombs().get(index).isBossBomb()) {
							u.setBossExplosion(true);
						}
						gs.addExplosion(u);
					}

					if (!canMove(u, CollisionType.UP)) {
						canExpUp = false;
					}

					// down
					Explosion d = new Explosion(gs.getBombs().get(index).getxPos(), gs
							.getBombs().get(index).getyPos()
							+ i * gs.yInc);

					if (canExpDown) {
						if (gs.getBombs().get(index).isBossBomb()) {
							d.setBossExplosion(true);
						}
						gs.addExplosion(d);
					}

					if (!canMove(d, CollisionType.DOWN)) {
						canExpDown = false;
					}

					// left
					Explosion l = new Explosion(gs.getBombs().get(index).getxPos() - i
							* gs.xInc, gs.getBombs().get(index).getyPos());

					if (canExpLeft) {
						if (gs.getBombs().get(index).isBossBomb()) {
							l.setBossExplosion(true);
						}
						gs.addExplosion(l);
					}

					if (!canMove(l, CollisionType.LEFT)) {
						canExpLeft = false;
					}

					// right
					Explosion r = new Explosion(gs.getBombs().get(index).getxPos() + i
							* gs.xInc, gs.getBombs().get(index).getyPos());

					if (canExpRight) {
						if (gs.getBombs().get(index).isBossBomb()) {
							r.setBossExplosion(true);
						}
						gs.addExplosion(r);
					}

					if (!canMove(r, CollisionType.RIGHT)) {
						canExpRight = false;
					}

				}

				gs.removeBomb(index);
			}	
		 
}