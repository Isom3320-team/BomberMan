package panel;

import System.GameStatus;
import System.GraphicEngine;
import System.PhysicsManager;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public  class GameApplication extends Application{
	protected Group mGroup;
	protected Scene mScene;
    protected GameStatus game ;
    protected PhysicsManager pm;
    
    public GameApplication(){
    	
    }
    
	@Override
	public void start(Stage primaryStage) throws Exception {
		loadBefore();
		mGroup= new Group();
		mScene = new Scene(mGroup, Window.WIDTH, Window.HEIGHT);		
		loadEnd();
		showStage(primaryStage);
	}
	
	protected void loadBefore(){;

	}
	
	protected void loadEnd(){
		
	};
	
	protected void showStage(Stage stage){
		stage.setScene(mScene);
		stage.show();
	}
	
	protected Scene getScene(){
		return mScene;
	}
	
	protected Group getRoot(){
		return mGroup;
	}
	
	public void setWindowSize(int width, int height){
		Window.init(width, height);
	}
}
