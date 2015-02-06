package System;


import javafx.application.Application;
import javafx.stage.Stage;
import System.GraphicEngine;

public class MainEngine extends Application  {
    public static Thread physicsThread;
    public  static Thread graphicThread;
    private static String[] record = {"0","0","0"};

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
   	}
   	
	public static void addToRecord(int score){
			if (score > Integer.valueOf(record[0])){
				record[2] = record [1];
				record[1] = record [0];
				record[0] = String.valueOf(score);
			} else if(score > Integer.valueOf(record[1])){
				record[2]=record[1];
				record[1] = String.valueOf(score);
			} else if(score > Integer.valueOf(record[2])){
				record[2] = String.valueOf(score);
			}
			
	}
	
	public static String[] getRecord(){
		return record;
	}

	@Override
	public void start(Stage arg0) throws Exception {
		//
		
	}
}
