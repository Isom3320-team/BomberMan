package System;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Iterator;

import javafx.application.Application;

public class MainEngine   {
    public static GameStatus gs;
    static GraphicManager gm;
    static Thread graphicThread;
    static Sound sound;

	 
    public static void main(String[] args){
		GameStatus gs = new GameStatus();
		PhysicsManager pm = new PhysicsManager(gs);
		GraphicEngine ge = new GraphicEngine(gs,pm);
		ge.launch(args);
		
	}
	public static void levelUp() {
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

			
			scoreCopy.write(gs.getPlayer().getScore());
			

			scoreCopy.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
