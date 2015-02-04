
package System;


import javafx.application.Application;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import panel.GraphicPanel;
import panel.GameApplication;
import panel.Window;
import panel.InGamePanel;

public class GraphicEngine extends GameApplication {
	
	public GraphicEngine(){
		game = new GameStatus();
		pm = new PhysicsManager(game);
	}
	
	
	public void launchGraphicEngine(){
		launch();
	}

	@Override
	protected void loadBefore() {
		setWindowSize(800,600);
		
	}

	@Override
	protected void loadEnd() {
		
		InGamePanel inGamePanel = new InGamePanel(Window.WIDTH,Window.HEIGHT);
		getRoot().getChildren().add(inGamePanel);
		inGamePanel.start();
		inGamePanel.initEvents();
		
		getScene().setFill(Color.GREY);
	}
	
	public GameStatus getStatus(){
		return game;
	}
	
	public void setStatus(GameStatus gs){
		this.game = gs;
	}
}
