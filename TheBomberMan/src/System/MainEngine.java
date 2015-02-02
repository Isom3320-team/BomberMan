package System;

import javafx.application.Application;

public class MainEngine   {
    public static GameStatus gs;
    static GraphicManager gm;
    static Thread graphicThread;
	 
    public static void main(String[] args) {
		gm = new GraphicManager();
		graphicThread = new Thread(gm);
		graphicThread.start();
      }

}
