package control;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import System.GameStatus;


public class DownKey implements EventHandler<KeyEvent>{
	
	GameStatus gs;
	
	public DownKey(GameStatus gs){
		this.gs = gs;
	}
	
	public void handle(KeyEvent keyevent){
		if (keyevent.getCode() == KeyCode.DOWN){
		this.gs.getPlayer().moveDown();
		}
	}
	
}
