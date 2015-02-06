
package System;



import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import panel.GameApplication;
import panel.MainMenuPanel;
import panel.Window;

public class GraphicEngine extends GameApplication implements Runnable {
	

    Media media = new Media("file:///Users/haozaijie/Desktop/bgm.mp3");
    MediaPlayer mp = new MediaPlayer(media);
    
	
	public GraphicEngine(){
		game = new GameStatus();
		pm = new PhysicsManager(game); 
	}
	
	
	public void launchGraphicEngine(){
		launch();
		
	}

	@Override
	protected void loadBefore() {
		setWindowSize(544,416);
	}

	@Override
	protected void loadEnd() {
		
		mp.play();
		MainMenuPanel mainMenuPanel = new MainMenuPanel(Window.WIDTH, Window.HEIGHT);
		getRoot().getChildren().add(mainMenuPanel);
		getRoot().getChildren().add(mainMenuPanel.getStartButton());
		getRoot().getChildren().add(mainMenuPanel.getHelpButton());
		
	}
	
	
	public GameStatus getStatus(){
		return game;
	}
	

	public void setStatus(GameStatus gs){
		this.game = gs;
	}



	@Override
	public void run() {
		launchGraphicEngine();
	}

	
	
}
