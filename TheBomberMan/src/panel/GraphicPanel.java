package panel;
import java.util.ArrayList;
import java.util.List;

import System.Player;
import javafx.scene.canvas.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.*;
import javafx.scene.Group;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;;

public class GraphicPanel extends Canvas {
	protected enum GameState {GAME_MENU, GAME_START, GAME_CONTINUE, GAME_HELP, GAME_SET,GAME_EXIT,GAME_PAUSE};
	private Player p = new Player();
	private Timeline timeline;
	private KeyFrame keyFrame;
	private int duration = 10;
    protected GameState mGameState = GameState.GAME_MENU;
	
	public GraphicPanel(double width, double height){
		super(width,height);
		initTimeLine();
	}
	
	public void draw(GraphicsContext gc){
		p.paint(gc, p);
	}
	
	private void initTimeLine() {
		timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);

		keyFrame = new KeyFrame(Duration.millis(duration), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				draw(getGraphicsContext2D());
			}
		});
		timeline.getKeyFrames().add(keyFrame);
	}
}
