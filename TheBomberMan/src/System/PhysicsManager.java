package System;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javafx.scene.canvas.GraphicsContext;

import javax.swing.Timer;

import System.CollisionType;
import System.FlyMinion;
import System.LivingObj;
import System.Units;
import System.Bomb;
import System.Enemy;
import System.Explosion;
import System.Rock;
import System.Player;
import System.Item;
import System.Wall;

/**
 * The physics manager checks collision and move the enemies
 * @author shawn, jin, cyril
 *
 */
public  class  PhysicsManager implements Runnable{
	/**
	 * A physics manager contains a game status, a timer
	 */
	static  int inc = 32;
	static GameStatus game;
	private Timer timer,timer2;
	
	/**
	 * create a physics manager
	 * @param game
	 */
	public PhysicsManager(GameStatus game){ 
		this.game = game;
	}
	
	/**
	 * start the physics manager
	 */
		@Override
	public void run() {

			ActionListener listener = new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						checkGameOver();
					} catch (InterruptedException e1) {
						
						e1.printStackTrace();
					}
					if (!game.isGameOver()) {
						winning();
						explosionDetector();
						itemPickUp();
						
					}
					

				}

			};
			timer = new Timer(100, listener);
			timer.start();

			ActionListener listener2 = new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (!game.isGameOver()) {
					   moveEnemies();
					}
				}

			};
			timer2 = new Timer(600, listener2);
			timer2.start();
		
			}
		
		/**
		 * check the collision between two units
		 * @param unit1
		 * @param unit2
		 * @param type
		 * @return
		 */
		public static boolean CollisionDetector(Units unit1, Units unit2, CollisionType type) {
			
			if (type == CollisionType.UP) {
				if (unit1.getX() == unit2.getX() && unit2.getY() == (unit1.getY() - inc)){
					return true;
				}
			}
			
			if (type == CollisionType.DOWN) {	
				if (unit1.getX() == unit2.getX() && unit2.getY() == (unit1.getY() + inc)){
					return true;
				}
			}
			
			if (type == CollisionType.RIGHT) {
				if (unit1.getY() == unit2.getY() && unit2.getX() == (unit1.getX() + inc)){
					return true;
				}
			}
			
			if (type == CollisionType.LEFT) {
				if (unit1.getY() == unit2.getY() && unit2.getX() == (unit1.getX() - inc)){
					return true;
				}
			}
			
			if (type == CollisionType.OVERLAP) {
				if (unit1.getX() == unit2.getX() && unit2.getY() == unit1.getY()){
					return true;
				}
			}
			
			return false;
		}

		/**
		 * see if a unit can move
		 * @param unit1
		 * @param type
		 * @return
		 */
		public static boolean canMove(Units unit1, CollisionType type) {

			if (!(unit1 instanceof Explosion)&&!(unit1 instanceof FlyMinion)){
			for(int i=0; i < game.getWallArray().size(); i++) {
				if (CollisionDetector(unit1, game.getWallArray().get(i),type))
					{
						return false;}
				}
			}
			
			for(int i=0; i < game.getRockArray().size(); i++) {
				if (CollisionDetector(unit1, game.getRockArray().get(i),type)){
					
						return false;}
				}
			if (!(unit1 instanceof Explosion)){
			if (unit1 instanceof Enemy) {
			for(int i=0; i < game.getEnemyArray().size(); i++) {
				if (CollisionDetector(unit1, game.getEnemyArray().get(i),type))
						return false;
				}
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
		
		/**
		 * see if player can place bomb
		 * @param unit1
		 * @return
		 */
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
				
				if (((Player) unit1).getMaxBomb() == game.getBombArray().size()) {
				return false;
				}
			
		return true;
		} 
		 
	/**
	 * see it player hit enemy
	 * @param unit1
	 * @param type
	 * @return
	 */
		public boolean hitsEnemy(Units unit1,CollisionType type) {
				for (int i = 0; i < game.getEnemyArray().size(); i++) {
					if (CollisionDetector(unit1, game.getEnemyArray().get(i),type)) {
						return true;
					}
				}
				return false;
			}
		/**
		 * see if enemy or explosion hits player
		 * @param enemy
		 * @return
		 */
	public boolean hitsPlayer(Enemy enemy) {

		if (CollisionDetector(enemy, game.getPlayer(), CollisionType.OVERLAP)) {
			return true;
		}

		return false;
	}
	/**
	 * see if player consume the item
	 */
	public void itemPickUp() {
		for (int i = 0; i < game.getItemArray().size(); i++) {
			if (CollisionDetector(game.getPlayer(), game.getItemArray().get(i),
					CollisionType.OVERLAP)) {
				game.getPlayer().consume(game.getItemArray().get(i));
				
				game.removeItem(i);
			}
		}
	}
	/**
	 * see if the explosion has kill anything
	 */
	public void explosionDetector() {
		try{for (int i = 0; i < game.getExplosionArray().size(); i++) {
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

		}
		for (int i = 0; i < game.getExplosionArray().size(); i++) {
			if (CollisionDetector(game.getExplosionArray().get(i), game.getPlayer(), CollisionType.OVERLAP)) {
				game.getPlayer().die();
				break;
			}
			
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * algorithm to let the enemy walk
	 * @param en
	 */
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
	/**
	 * let the enemy walk
	 */
	public void moveEnemies() {

			for (int i = 0; i < game.getEnemyArray().size(); i++) {
				enemyRandomWalk(game.getEnemyArray().get(i));
				if (hitsPlayer(game.getEnemyArray().get(i))) {
					game.getPlayer().die();
				}
			}
	}
	
	/**
	 * explode the bomb
	 * @param bombX
	 */
	public void explodeBomb(int bombX) {

				boolean canExpUp = true;
				boolean canExpDown = true;
				boolean canExpLeft = true;
				boolean canExpRight = true;
				int originX = game.getBombArray().get(bombX).getX();
				int originY = game.getBombArray().get(bombX).getY();
				int playerBlastRadius = game.getPlayer().getBombRadius(); //bombX.ItemType ??? + set ItemType --> Range of the blast

				
				for (int i = 0; i < playerBlastRadius; i++) {

					// up
					Explosion up = new Explosion(originX,originY-i*inc); 
					
					
					if (canExpUp) {
						game.addExplosion(up);
					}

					if (!canMove(up, CollisionType.UP)) {
						canExpUp = false;
					}

					// down
					Explosion down = new Explosion(originX,originY+i*inc); 
					
					if (canExpDown) {
						
						game.addExplosion(down);
					}

					if (!canMove(down, CollisionType.DOWN)) {
						canExpDown = false;
					}

					// left
					Explosion left = new Explosion(originX-i*inc,originY); 

					if (canExpLeft) {
						
						game.addExplosion(left);
					}

					if (!canMove(left, CollisionType.LEFT)) {
						canExpLeft = false;
					}

					// right
					Explosion right = new Explosion(originX+i*inc ,originY); 

					if (canExpRight) {
						
						game.addExplosion(right);
					}

					if (!canMove(right, CollisionType.RIGHT)) {
						canExpRight = false;
					}

				}

				game.removeBomb(bombX);
			}
	/**
	 * remove dead things from game status
	 */
	public void removeCorpse() {
		for (int i = 0; i < game.getBombArray().size(); i++) {
			if (game.getBombArray().get(i).isDead()) {
				explodeBomb(i);
			}
		}

		for (int i = 0; i < game.getExplosionArray().size(); i++) {
			if (game.getExplosionArray().get(i).isDead()) {
				game.removeExplosion(i);
			}
		}

		for (int i = 0; i < game.getEnemyArray().size(); i++) {
			if (game.getEnemyArray().get(i).isDead()) {
				game.removeEnemy(i);
			}
		}

		for (int i = 0; i < game.getWallArray().size(); i++) {
			if (game.getWallArray().get(i).isDead()) {
				game.removeWall(i);
			}
		}

	}
	/**
	 * win will upgrade the game to next level
	 */
	public void winning() {
		if (game.getEnemyArray().isEmpty()) {
			MainEngine.levelUp(game);
		}
	}
	/**
	 * check if the player has lost
	 * @throws InterruptedException
	 */
	public void checkGameOver() throws InterruptedException {
		if (!game.isGameOver()&&!timer2.isRunning()){
			timer2.start();
		}
		if (game.getPlayer().getLive()==0){
		    game.setGameOver(true);
		    timer2.stop();
		}
	}	 
	
	
		 
}