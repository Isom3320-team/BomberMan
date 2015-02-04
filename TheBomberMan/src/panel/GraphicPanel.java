package panel;
import java.util.ArrayList;
import java.util.List;

import System.GameStatus;
import System.PhysicsManager;
import System.Player;
import System.Units;
import javafx.scene.canvas.*;
import javafx.scene.input.KeyEvent;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.*;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;;

public abstract class GraphicPanel extends Canvas {
	protected enum GamePanel {GAME_MENU, GAME_START, GAME_CONTINUE, GAME_HELP, GAME_SET,GAME_EXIT,GAME_PAUSE};
	protected GameStatus game;
	protected PhysicsManager pm;
	private Timeline timeline;
	private KeyFrame keyFrame;
	private int duration = 10;
    protected GamePanel mGameState = GamePanel.GAME_MENU;
	
	public GraphicPanel(double width, double height, GameStatus game, PhysicsManager pm){
		super(width,height);
		this.game = game;
		this.pm = pm;
		initTimeLine();
	}
	
	public abstract void paint(GraphicsContext gc);
	
	
	public void initEvents(){
		getParent().getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				onKeyPressed(event);
			}
		});
	}
	
	protected abstract void onKeyPressed(KeyEvent event);
	
	
	private void initTimeLine() {
		timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);

		keyFrame = new KeyFrame(Duration.millis(duration), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				paint(getGraphicsContext2D());
			}
		});
		timeline.getKeyFrames().add(keyFrame);
	}
	
	public void start(){
		timeline.play();
	}
	
	public void pause(){
		timeline.pause();
	}
	public void stop(){
		timeline.stop();
	}
}
