package System;
import javafx.application.Application;
import javafx.stage.Stage;
import System.GraphicEngine;

/**
 * A mainEngine is the brain of the game, it contains the engines that runs the game
 * @author shawn, jin, cyril
 *
 */
public class MainEngine extends Application  {
	/**
	 * MainEngine contains two threads, and record the score of each game when the game is running
	 */
    public static Thread physicsThread;
    public  static Thread graphicThread;
    private static String[] record = {"0","0","0"};

    /**
     * Main method starts the threads
     * @param args
     */
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

    /**
     * A level up method will restart the game but will increase the difficulty
     * @param game
     */
    public static void levelUp(GameStatus game) {
   		game.getPlayer().setLevel(game.getPlayer().getLevel() + 1);
   		game.InitializeGame(game.getPlayer().getLevel());
   		game.getPlayer().setCoordinates(32, 32);
   	}
   	
    /**
     * Record the score of each game, but only record the highest three
     * @param score
     */
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
	
	/**
	 * get the record of the scores
	 * @return
	 */
	public static String[] getRecord(){
		return record;
	}

	@Override
	public void start(Stage arg0) throws Exception {
		//
		
	}
}
