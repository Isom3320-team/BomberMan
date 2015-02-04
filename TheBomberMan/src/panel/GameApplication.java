package panel;

import System.GameStatus;
import System.PhysicsManager;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class GameApplication extends Application{
	protected Group mGroup;
	protected Scene mScene;
    protected GameStatus game;
    protected PhysicsManager pm;
    
    public GameApplication (GameStatus game, PhysicsManager pm ){
    	this.game = game;
    	this.pm = pm;
    }
    
    
	@Override
	public void start(Stage primaryStage) throws Exception {
		loadBefore();
		mGroup= new Group();
		mScene = new Scene(mGroup, Window.WIDTH, Window.HEIGHT);		
		loadEnd();
		showStage(primaryStage);
	}
	
	protected abstract void loadBefore();
	
	protected abstract void loadEnd();
	
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
