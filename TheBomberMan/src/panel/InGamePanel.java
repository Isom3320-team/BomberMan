package panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import System.CollisionType;
import System.GameStatus;
import System.PhysicsManager;

public class InGamePanel extends GraphicPanel  {
	
	
	public InGamePanel(double width, double height) {
		super(width, height);
		this.game = new GameStatus();
		this.mGameState= GamePanel.GAME_START;
		this.pm = new PhysicsManager(game);
		
		
	}

	@Override
public void drawpanel(GraphicsContext gc) {
		gc.clearRect(32, 32, 480, 352);
		game.getPlayer().paint(getGraphicsContext2D());
		
		for (int i = 0; i < game.getBombArray().size(); i++) {
			if(!game.getBombArray().get(i).isDead()){
			game.getBombArray().get(i).paint(gc);
			}else {
				pm.explodeBomb(i);
				pm.explosionDetector();
			}
		}
		
		for (int i = 0; i < game.getWallArray().size(); i++) {
			game.getWallArray().get(i).paint(gc);
		}
		
		for (int i = 0; i < game.getRockArray().size(); i++) {
			game.getRockArray().get(i).paint(gc);
		}
		
		for (int i = 0; i < game.getEnemyArray().size(); i++) {
			game.getEnemyArray().get(i).paint(gc);
		}
		
		for (int i = 0; i < game.getItemArray().size(); i++) {
			game.getItemArray().get(i).paint(gc);
		}
		
		for (int i = 0; i < game.getExplosionArray().size(); i++) {
			game.getExplosionArray().get(i).paint(gc);
		}
	}

	@Override
	protected void onKeyPressed(KeyEvent event) {
	       switch (event.getCode()) {
	   	case UP:
	   		if (game.getPlayer() != null && pm.canMove(game.getPlayer(), CollisionType.UP)) {
	   			System.out.println("can move");
	   			this.game.getPlayer().clear(gc);
	   			this.game.getPlayer().moveUp();
	   			if (pm.hitsEnemy(game.getPlayer(), CollisionType.OVERLAP)) {
	   				game.getPlayer().die();
	   			}
	   		}else{
	   			System.out.println("cannotmove");
	   			
	   			break;
	   		}
	   		break;
	   	case DOWN:
			if (game.getPlayer() != null && pm.canMove(game.getPlayer(), CollisionType.DOWN)) {
				System.out.println("can move");
				this.game.getPlayer().clear(gc);
				this.game.getPlayer().moveDown();
				if (pm.hitsEnemy(game.getPlayer(), CollisionType.OVERLAP)) {
					game.getPlayer().die();
				}
				
			}else{
				System.out.println("cannotmove");
				break;
			}
	   		break;
	   	case LEFT:
			if (game.getPlayer() != null && pm.canMove(game.getPlayer(), CollisionType.LEFT)) {
				System.out.println("can move");
				this.game.getPlayer().clear(gc);
				this.game.getPlayer().moveLeft();
				if (pm.hitsEnemy(game.getPlayer(), CollisionType.OVERLAP)) {
					game.getPlayer().die();
				}
			}else{
				System.out.println("cannotmove");
				
				break;
			}
	   		break;
	   	case RIGHT:
			if (game.getPlayer() != null && pm.canMove(game.getPlayer(), CollisionType.RIGHT)) {
				System.out.println("can move");
				this.game.getPlayer().clear(gc);
				this.game.getPlayer().moveRight();
				if (pm.hitsEnemy(game.getPlayer(),  CollisionType.OVERLAP)) {
					game.getPlayer().die();
				}
			}else{
				System.out.println("cannotmove");
				
				break;
			}
	   		break;
	   	case SPACE:
			if (game.getPlayer() != null&& pm.canPlaceBomb(game.getPlayer())) {
				System.out.println("can place");
				this.game.addBomb();
			}else{
				break;
			}
	   		break;
	   	default:
	   		break;
	   	}
		
	}

	@Override
	public void clear(GraphicsContext gc) {
		if (game.getPlayer().isDead()){
		  //game.getPlayer().clear(getGraphicsContext2D());
		}
		for (int i = 0; i < game.getBombArray().size(); i++) {
			if(game.getBombArray().get(i).isDead()){
				game.getBombArray().get(i).clear(gc);
				game.removeBomb(i);
			}
		}
		
		for (int i = 0; i < game.getWallArray().size(); i++) {
			if(game.getWallArray().get(i).isDead()){
			game.getWallArray().get(i).clear(gc);
			game.removeWall(i);
			}
		}
		
		
		for (int i = 0; i < game.getEnemyArray().size(); i++) {
			if(game.getEnemyArray().get(i).isDead()){
			game.getEnemyArray().get(i).clear(gc);
			game.removeEnemy(i);
			}
		}
		
		for (int i = 0; i < game.getItemArray().size(); i++) {
			if(game.getItemArray().get(i).isDead()){
			game.getItemArray().get(i).clear(gc);
			game.removeItem(i);
			}
			
		}
		
		for (int i = 0; i < game.getExplosionArray().size(); i++) {
			
			if(game.getExplosionArray().get(i).isDead()){
				game.getExplosionArray().get(i).clear(gc);
				game.getExplosionArray().remove(i);
			
			}
		}
		
	}

	
	
}
