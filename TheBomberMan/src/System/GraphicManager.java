package System;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import System.GameStatus;
import control.DownKey;

public class GraphicManager extends Application implements Runnable{
	GameStatus gs; 
	Stage primayStage;
	
	@Override
	  public void start(Stage primaryStage){
		  
		gs = new GameStatus();
		
	    primaryStage.setTitle("BorderPane Test");

	    //Creating Pane
	    Pane p = new Pane();
		
		gs.getPlayer().getView().setOnKeyPressed(e-> {
			switch (e.getCode()) {
			case UP:
				gs.getPlayer().moveUp();
				gs.getPlayer().getView().setLayoutY(gs.getPlayer().getY());
				break;
			case DOWN:
				gs.getPlayer().moveDown();
				gs.getPlayer().getView().setLayoutY(gs.getPlayer().getY());
				break;
			case LEFT:
				gs.getPlayer().moveLeft();
				gs.getPlayer().getView().setLayoutX(gs.getPlayer().getX());
				break;
			case RIGHT:
				gs.getPlayer().moveRight();
				gs.getPlayer().getView().setLayoutX(gs.getPlayer().getX());
				break;
			case SPACE:
				if (gs.getBomb()!=null){
					int l = gs.bombArray.size();
					p.getChildren().remove(gs.getBomb().getView());
					System.out.print(gs.bombArray.size());
					gs.removeBomb();
					gs.addBomb();
				}else{
					gs.addBomb();
				}
				p.getChildren().add(gs.getBomb().getView());
				gs.getBomb().getView().setLayoutX(gs.getPlayer().getX());
				gs.getBomb().getView().setLayoutY(gs.getPlayer().getY());
			case ESCAPE:
				break;
			default:
				break;
			}
			
		});
		
		p.getChildren().add(gs.getPlayer().getView());
	    //Adding StackPane to the scene
	    Scene scene = new Scene(p,300,200);
	    primaryStage.setScene(scene);
	    primaryStage.show();
	    
	    gs.getPlayer().getView().requestFocus();
	    
	    //t.play();
	  }



	@Override
	public void run() {
		Application.launch();
		
	}
	

}


  
