package System;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Iterator;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import System.GraphicEngine;

public class MainEngine extends Application  {
    static Thread physicsThread;
    static Thread graphicThread;
    static Sound sound;

    public static void main(String[] args){
    	
    	GraphicEngine ge = new GraphicEngine();

    	PhysicsManager physicsM = new PhysicsManager(ge.getStatus());
    	physicsThread = new Thread(physicsM);
    	graphicThread = new Thread(ge);
    	graphicThread.start();
    	//physicsThread.start();
    	
	}

    
	public static void levelUp(GameStatus gs) {
   		gs.getPlayer().setLevel(gs.getPlayer().getLevel() + 1);
   		gs.InitializeGame(gs.getPlayer().getLevel());
   		gs.getPlayer().setCoordinates(32, 32);
   		sound.playSound("/image/levelup.wav", false);
   		gs.getPlayer().setScore(gs.getPlayer().getScore()+500 );
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
