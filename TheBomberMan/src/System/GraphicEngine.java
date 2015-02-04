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
import javafx.scene.paint.Color;
import panel.GraphicPanel;
import panel.GameApplication;
import panel.Window;
import panel.InGamePanel;

public class GraphicEngine extends GameApplication {
	
	
	
	public GraphicEngine(GameStatus game, PhysicsManager pm) {
		super(game, pm);
		
	}

	@Override
	protected void loadBefore() {
		setWindowSize(800,600);
		
	}

	@Override
	protected void loadEnd() {
		InGamePanel inGamePanel = new InGamePanel(Window.WIDTH,Window.HEIGHT,game,pm);
		getRoot().getChildren().add(inGamePanel);
		inGamePanel.start();
		inGamePanel.initEvents();
		
		getScene().setFill(Color.GREY);
	}
		
}
