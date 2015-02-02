package System;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;

public class MainEngine{
    public static GameStatus gs;
    static GraphicManager gm;
    static Thread graphicThread;
	 
    public static void main(String[] args) {

				Application.launch(args);				
	}
}
