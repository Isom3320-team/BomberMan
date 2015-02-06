
package System;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import panel.GameApplication;
import panel.MainMenuPanel;
import panel.Window;

/**
 * A graphic engine runs the game, it takes charge of the change of panels
 * and all the runnable things.
 * @author shawn, jin, cyril
 *
 */
public class GraphicEngine extends GameApplication implements Runnable {
	
	/**
	 * a graphicEngine contains a background music
	 */
	
    Media media = new Media("file:///Users/haozaijie/Documents/hang/workspace/newBombergame/BomberMan/TheBomberMan/src/Image/bgm.wav");
    MediaPlayer mp = new MediaPlayer(media);
    
	
    /**
     * create a graphic Engine 
     */
	public GraphicEngine(){
		game = new GameStatus();
		pm = new PhysicsManager(game); 
	}
	
	/**
	 * launch the graphic Engine
	 */
	public void launchGraphicEngine(){
		launch();
		
	}

	/**
	 * Initialize the size of window
	 */
	@Override
	protected void loadBefore() {
		setWindowSize(544,416);
	}

	/**
	 * present the main menu
	 */
	@Override
	protected void loadEnd() {
		
		mp.play();
		MainMenuPanel mainMenuPanel = new MainMenuPanel(Window.WIDTH, Window.HEIGHT);
		getRoot().getChildren().add(mainMenuPanel);
		getRoot().getChildren().add(mainMenuPanel.getStartButton());
		getRoot().getChildren().add(mainMenuPanel.getHelpButton());
		
	}
	
	/**
	 * retrieve the GameStatus that is running
	 * @return
	 */
	public GameStatus getStatus(){
		return game;
	}
	
	/**
	 * set the GameStatus
	 * @param gs
	 */
	public void setStatus(GameStatus gs){
		this.game = gs;
	}


	/**
	 * run the graphic Engine
	 */
	@Override
	public void run() {
		launchGraphicEngine();
	}

	
	
}
