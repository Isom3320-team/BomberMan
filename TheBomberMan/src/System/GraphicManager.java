package System;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GraphicManager extends Application {
  public static void main(String[] args) {
    Application.launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("BorderPane Test");
    
    Player p = new Player(50, 50);
    //Creating StackPane
    StackPane sp = new StackPane();
	ImageView imgView = new ImageView(p.getImage());
	sp.getChildren().add(imgView);
    //
    Label lbl = new Label("JavaFX 2 StackPane");
    sp.getChildren().add(lbl);
    Button btn = new Button("Button");
    sp.getChildren().add(btn);
   
    //Adding StackPane to the scene
    Scene scene = new Scene(sp,300,200);
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}