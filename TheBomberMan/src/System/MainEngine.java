package System;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import System.GraphicEngine;

public class MainEngine extends Application  {
    public static Thread physicsThread;
    public  static Thread graphicThread;
    public static Sound sound;
    

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
   	
	public static void scoreCopy(String score) {
		try {
			BufferedWriter scoreCopy = new BufferedWriter(new FileWriter("src/scoreCopy.txt",true));
			
			scoreCopy.write(score+"\n");
			
			scoreCopy.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static ArrayList<String> loadScores() {
		ArrayList<String> loadedScores = new ArrayList<String>();

		try {
			BufferedWriter init = new BufferedWriter(new FileWriter("src/scoreCopy.txt",true));
			
			init.write(0+"\n");
			
			init.close();
			
			BufferedReader bReader = new BufferedReader(new FileReader(
					"src/scoreCopy.txt"));

			String currentLine;
			while (!(currentLine = bReader.readLine()).equals(null)) {
				loadedScores.add(currentLine);
			}

			bReader.close();

			return loadedScores;

		} catch (Exception e) {
			File emptyDummy = new File("src/scoreCopy.txt");
			try {
				@SuppressWarnings("unused")
				boolean fileCreated = emptyDummy.createNewFile();
			}

			catch (IOException ioe) {

			}
		}

		return loadedScores;
	}

	@Override
	public void start(Stage arg0) throws Exception {
		//
		
	}
}
