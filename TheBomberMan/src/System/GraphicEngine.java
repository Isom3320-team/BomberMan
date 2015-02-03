package System;

/*
import control.DownKey;
import control.LeftKey;
import control.RightKey;
import control.SpaceKey;
import control.UpKey;
*/

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import panel.GraphicPanel;

public class GraphicEngine extends GraphicPanel{
	
	public GraphicEngine(double width, double height, GameStatus game, PhysicsManager pm) {
		super(width, height, game, pm);
		/*
		DownKey Down = new DownKey(game);
		UpKey Up = new UpKey(game);
		LeftKey Left = new LeftKey(game);
		RightKey Right = new RightKey(game);
		SpaceKey Space = new SpaceKey(game);
		*/
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(GraphicsContext gc) {
		
		game.getPlayer().paint(gc);
		
		for (int i = 0; i < game.getBombArray().size(); i++) {
			game.getBombArray().get(i).paint(gc);
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
	   		if (game.getPlayer() != null && pm.canMove(game.getPlayer(), CollisionType.DOWN)) {
	   			this.game.getPlayer().moveDown();
	   			if (pm.hitsEnemy(game.getPlayer(), CollisionType.OVERLAP)) {
	   				game.getPlayer().die();
	   			}
	   		}
	   		break;
	   	case DOWN:
			if (game.getPlayer() != null && pm.canMove(game.getPlayer(), CollisionType.DOWN)) {
				this.game.getPlayer().moveDown();
				if (pm.hitsEnemy(game.getPlayer(), CollisionType.OVERLAP)) {
					game.getPlayer().die();
				}
			}
	   		break;
	   	case LEFT:
			if (game.getPlayer() != null && pm.canMove(game.getPlayer(), CollisionType.LEFT)) {
				this.game.getPlayer().moveLeft();
				if (pm.hitsEnemy(game.getPlayer(), CollisionType.OVERLAP)) {
					game.getPlayer().die();
				}
			}
	   		break;
	   	case RIGHT:
			if (game.getPlayer() != null && pm.canMove(game.getPlayer(), CollisionType.RIGHT)) {
				this.game.getPlayer().moveRight();
				if (pm.hitsEnemy(game.getPlayer(),  CollisionType.OVERLAP)) {
					game.getPlayer().die();
				}
			}
	   		break;
	   	case SPACE:
			if (game.getPlayer() != null&& pm.canPlaceBomb(game.getPlayer())) {
				this.game.addBomb();
			}
	   		break;
	   	default:
	   		break;
	   	}
		
	}
}
