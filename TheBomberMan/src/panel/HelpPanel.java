package panel;

import System.GraphicEngine;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

public class HelpPanel extends Canvas {
	Image image = new Image("Image/help.png",544,416,false,true);
	Button back;
	
	public HelpPanel(double width,double height){
		super(width,height);
		this.getGraphicsContext2D().drawImage(image, 0, 0);
		back = new Button ("Back!");
		back.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				GraphicEngine.getRoot().getChildren().clear();
				MainMenuPanel mainMenuPanel = new MainMenuPanel(Window.WIDTH, Window.HEIGHT);
				GraphicEngine.getRoot().getChildren().add(mainMenuPanel);
				GraphicEngine.getRoot().getChildren().add(mainMenuPanel.getStartButton());
				GraphicEngine.getRoot().getChildren().add(mainMenuPanel.getHelpButton());
			}
			
		});
	}
	
	public Button getBackButton(){
		return this.back;
	}
}
