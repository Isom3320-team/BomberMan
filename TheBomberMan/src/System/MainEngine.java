package System;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Iterator;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import System.GraphicEngine;

public class MainEngine extends Application  {
    public static Thread physicsThread;
    static Thread graphicThread;
    static Sound sound;
    

    public static void main(String[] args){
    	
    	GraphicEngine ge = new GraphicEngine();

    	PhysicsManager physicsM = new PhysicsManager(ge.getStatus());
    	
    	graphicThread = new Thread(ge);
    	physicsThread = new Thread(physicsM);
    	try{
    	graphicThread.start();
    	physicsThread.start();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	
	}

    public static void levelUp(GameStatus game) {
   		game.getPlayer().setLevel(game.getPlayer().getLevel() + 1);
   		game.InitializeGame(game.getPlayer().getLevel());
   		game.getPlayer().setCoordinates(32, 32);
   		game.getPlayer().setScore(game.getPlayer().getScore()+500 );
   	}
   	
	public static void scoreCopy() {
		try {
			BufferedWriter scoreCopy = new BufferedWriter(new FileWriter(
					"src/scoreCopy.txt"));

			
			//scoreCopy.write(gs.getPlayer().getScore());
			

			scoreCopy.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void start(Stage arg0) throws Exception {
		//
		
	}
}
