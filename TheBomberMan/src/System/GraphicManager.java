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

public class GraphicManager extends Application {
	GameStatus gs; 
	DownKey dk;
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	
	@Override
	  public void start(Stage primaryStage){
		  
		gs = new GameStatus();
		dk = new DownKey(this.gs);
		
	    primaryStage.setTitle("BorderPane Test");

	    //Creating Pane
	    Pane p = new Pane();
		
		gs.getPlayer().getView().setOnKeyPressed(e-> {
			if (e.getCode() == KeyCode.DOWN){
				gs.getPlayer().moveDown();
				gs.getPlayer().getView().setLayoutY(gs.getPlayer().getY());
			}
			if(e.getCode() == KeyCode.UP){
				gs.getPlayer().moveUp();
				gs.getPlayer().getView().setLayoutY(gs.getPlayer().getY());
			}
			if(e.getCode() == KeyCode.LEFT){
				gs.getPlayer().moveLeft();
				gs.getPlayer().getView().setLayoutX(gs.getPlayer().getX());
			}
			if(e.getCode() == KeyCode.RIGHT){
				gs.getPlayer().moveRight();
				gs.getPlayer().getView().setLayoutX(gs.getPlayer().getX());
			}
			else{
				
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
	

}


  
