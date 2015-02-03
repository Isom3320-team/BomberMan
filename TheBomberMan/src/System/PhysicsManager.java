package System;

import java.util.ArrayList;
import java.util.Random;

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

public  class  PhysicsManager implements Runnable{
	static  int inc;
	static GameStatus game;
	
	public PhysicsManager(GameStatus game){ 
		this.game = game;
	}
	
		@Override
	public void run() {
			// TODO Auto-generated method stub
			}
		// to do : in the detector we need to use switch to distinguish different type of collision
		// this is useful and can save time
public static boolean CollisionDetector(Units unit1, Units unit2, CollisionType type) {
			
			if (type == CollisionType.UP) {
				if (unit1.getX() == unit2.getX() && unit1.getY() == unit2.getY() - inc){
					return true;
				}
			}
			
			if (type == CollisionType.DOWN) {	
				if (unit1.getX() == unit2.getX() && unit1.getY() == unit2.getY() + inc){
					return true;
				}
			}
			
			if (type == CollisionType.RIGHT) {
				if (unit1.getY() == unit2.getY() && unit1.getX() == unit2.getX() + inc){
					return true;
				}
			}
			
			if (type == CollisionType.LEFT) {
				if (unit1.getY() == unit2.getY() && unit1.getX() == unit2.getX() - inc){
					return true;
				}
			}
			
			if (type == CollisionType.OVERLAP) {
				if (unit1.getX() == unit2.getY() && unit1.getY() == unit2.getY()){
					return true;
				}
			}
			
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
	public boolean canPlaceBomb(Units unit1) {
			 
		 
			 	for(int i=0; i < game.getWallArray().size(); i++) {
					if (CollisionDetector(unit1, game.getWallArray().get(i),CollisionType.OVERLAP))
							return false;
					}
				
				for(int i=0; i < game.getRockArray().size(); i++) {
					if (CollisionDetector(unit1, game.getRockArray().get(i),CollisionType.OVERLAP))
							return false;
					}
				
				for(int i=0; i < game.getEnemyArray().size(); i++) {
					if (CollisionDetector(unit1, game.getEnemyArray().get(i),CollisionType.OVERLAP))
							return false;
					}
								
				for (int i = 0; i < game.getBombArray().size(); i++) {
					if (CollisionDetector(unit1, game.getBombArray().get(i),CollisionType.OVERLAP)) 
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
	public boolean hitsPlayer(Enemy enemy) {

		if (CollisionDetector(enemy, game.getPlayer(), CollisionType.OVERLAP)) {
			return true;
		}

		return false;
	}
	public void ItemPickUp() {
		for (int i = 0; i < game.getItemArray().size(); i++) {
			if (CollisionDetector(game.getPlayer(), game.getItemArray().get(i),
					CollisionType.OVERLAP)) {
				game.getPlayer().consume(game.getItemArray().get(i));
				game.removeItem(i);
			}
		}
	}
	public void ExplosionDetector() {
		for (int i = 0; i < game.getExplosionArray().size(); i++) {
			for (int j = 0; j < game.getWallArray().size(); j++) {
				if (CollisionDetector(game.getExplosionArray().get(i), game.getWallArray()
						.get(j), CollisionType.OVERLAP)) {
					game.getWallArray().get(j).die();
				}
			}

			for (int j = 0; j < game.getEnemyArray().size(); j++) {
				if (CollisionDetector(game.getExplosionArray().get(i), game
								.getEnemyArray().get(j), CollisionType.OVERLAP)) {
					game.getEnemyArray().get(j).die();
				}
			}


			if (CollisionDetector(game.getExplosionArray().get(i), game.getPlayer(), CollisionType.OVERLAP)) {
				game.getPlayer().die();
			}
			
		}
	}
	public void enemyRandomWalk(Enemy en) {
		ArrayList<CollisionType> options = new ArrayList<CollisionType>();

		if (canMove(en, CollisionType.UP)) {
			options.add(CollisionType.UP);
		}

		if (canMove(en, CollisionType.DOWN)) {
			options.add(CollisionType.DOWN);
		}

		if (canMove(en, CollisionType.LEFT)) {
			options.add(CollisionType.LEFT);
		}

		if (canMove(en, CollisionType.RIGHT)) {
			options.add(CollisionType.RIGHT);
		}

		// chooses a direction to move in from options
		if (options.size() > 0) {
			CollisionType direction = options.get(new Random().nextInt(options.size()));
			if (direction == CollisionType.UP) {
				en.moveUp();
			} else if (direction == CollisionType.DOWN) {
				en.moveDown();
			} else if (direction == CollisionType.LEFT) {
				en.moveLeft();
			} else if (direction == CollisionType.RIGHT) {
				en.moveRight();
			}
		}
	}
	
	public void moveEnemies() {
		//if (!MainEngine.isPaused) {
			for (int i = 0; i < game.getEnemyArray().size(); i++) {
				enemyRandomWalk(game.getEnemyArray().get(i));
				if (hitsPlayer(game.getEnemyArray().get(i))) {
					game.getPlayer().die();
				}
			}
		//}
	}

	public void explodeBomb(int bombX) {

				boolean canExpUp = true;
				boolean canExpDown = true;
				boolean canExpLeft = true;
				boolean canExpRight = true;
				int originX = game.getBombArray().get(bombX).getX();
				int originY = game.getBombArray().get(bombX).getY();
				int playerBlastRadius = 2; //bombX.ItemType ??? + set ItemType --> Range of the blast
				int bossBlastRadius = 2; //bombX.Type ???


				// adds explosion outwards 
				for (int i = 0; i < (game.getBombArray().get(bombX).getbossBomb() ? bossBlastRadius
						: playerBlastRadius); i++) {

					// up
					Explosion up = new Explosion(originX,originY-i*inc); 
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
					Explosion down = new Explosion(originX,originY+i*inc); 

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
					Explosion left = new Explosion(originX-i*inc,originY); 

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
					Explosion right = new Explosion(originX+i*inc ,originY); 

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