
package System;


import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import panel.GraphicPanel;
import panel.GameApplication;
import panel.Window;
import panel.InGamePanel;

public class GraphicEngine extends GameApplication implements Runnable {
	
	protected InGamePanel inGamePanel;
	
	public GraphicEngine(){
		game = new GameStatus();
		pm = new PhysicsManager(game); 
	}
	
	
	public void launchGraphicEngine(){
		launch();
		
	}

	@Override
	protected void loadBefore() {
		setWindowSize(544,416);
	}

	@Override
	protected void loadEnd() {
		
		inGamePanel = new InGamePanel(Window.WIDTH,Window.HEIGHT);
		
		getRoot().getChildren().add(inGamePanel);
		inGamePanel.start();
		inGamePanel.initEvents();
		getScene().setFill(Color.rgb(128,128,128));
	}
	
	public GameStatus getStatus(){
		return game;
	}
	

	public void setStatus(GameStatus gs){
		this.game = gs;
	}


	@Override
	public void run() {
		launchGraphicEngine();
	}
	
	

	
	
}
