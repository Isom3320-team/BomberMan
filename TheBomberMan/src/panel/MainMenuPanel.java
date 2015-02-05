package panel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

import System.GraphicEngine;

public class MainMenuPanel extends GraphicPanel{
	Image image = new Image("Image/StartGame.png", 544.0, 416.0, false, true);
	Button help;
	Button start;
	
	public MainMenuPanel(double width, double height) {
		super(width, height);
		this.getGraphicsContext2D().drawImage(image, 0, 0);
		
		start = new Button("Start!");
		start.setLayoutX(450);
		start.setLayoutY(320);
		start.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				InGamePanel inGamePanel = new InGamePanel(Window.WIDTH, Window.HEIGHT);
				GraphicEngine.getRoot().getChildren().add(inGamePanel);
				
			}
			
			
		});
	}
	

	@Override
	public void drawpanel(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void clear(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void onKeyPressed(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	public Button getButton(){
		return this.start;
	}
	
}
