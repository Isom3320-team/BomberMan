package panel;

import System.GraphicEngine;
import System.MainEngine;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class GameOverPanel extends Canvas{
	Image image = new Image("Image/GameOver.png", 544.0, 416.0, false, true);
	Button restart;
	
	public GameOverPanel(double width, double height) {
		super(width, height);
		this.getGraphicsContext2D().drawImage(image, 0, 0);
		restart = new Button("Restart!");
		restart.setLayoutX(450);
		restart.setLayoutY(100);
		restart.setOnAction(new EventHandler<ActionEvent>(){
			
			@Override
			public void handle(ActionEvent arg0){
				System.out.print("cleared and clicked");
				GraphicEngine.getRoot().getChildren().clear();
				
				MainMenuPanel mainMenuPanel = new MainMenuPanel(Window.WIDTH, Window.HEIGHT);
				GraphicEngine.getRoot().getChildren().add(mainMenuPanel);
				GraphicEngine.getRoot().getChildren().add(mainMenuPanel.getStartButton());
				GraphicEngine.getRoot().getChildren().add(mainMenuPanel.getHelpButton());

				
			}
		});
	}

	public Button getRestartButton(){
		return this.restart;
	}
}
