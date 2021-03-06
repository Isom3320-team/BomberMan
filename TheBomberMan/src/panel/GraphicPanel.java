package panel;

import System.GameStatus;
import System.PhysicsManager;
import javafx.scene.canvas.*;
import javafx.scene.input.KeyEvent;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;;

public abstract class GraphicPanel extends Canvas {
	protected GameStatus game ;
	public PhysicsManager pm;
	private Timeline timeline;
	private KeyFrame keyFrameForUpdate;
	private int duration = 30;
    protected GraphicsContext gc = this.getGraphicsContext2D();
	
	public GraphicPanel(double width, double height){
		super(width,height);
		initTimeLine();
	}
	
	public abstract void drawpanel(GraphicsContext gc);
	
	public abstract void clear(GraphicsContext gc);
	
	
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

		keyFrameForUpdate = new KeyFrame(Duration.millis(duration), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				drawpanel(gc);
				clear(gc);
			}
		});
		
		timeline.getKeyFrames().add(keyFrameForUpdate);
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
