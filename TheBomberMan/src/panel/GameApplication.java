package panel;

import System.GameStatus;
import System.PhysicsManager;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public  class GameApplication extends Application{
	protected static Group mGroup;
	protected static Scene mScene;
	protected static Pane mPane;
    protected GameStatus game ;
    protected PhysicsManager pm;
    
    public GameApplication(){
    	
    }
    
	@Override
	public void start(Stage primaryStage) throws Exception {
		loadBefore();
		mPane = new Pane();
		mGroup= new Group(mPane);
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
	
	
	protected static Scene getScene(){
		return mScene;
	}
	
	protected static Pane getRoot(){
		return mPane;
	}
	public void setWindowSize(int width, int height){
		Window.init(width, height);
	}
	
	
}
