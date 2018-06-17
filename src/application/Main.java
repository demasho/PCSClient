package application;
	
import java.io.IOException;
import java.net.URL;

import client.ClientConsole;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
	    URL url = getClass().getResource("CustomerScene.fxml"); 
	    GridPane pane = FXMLLoader.load( url );
	    BackgroundImage img = new BackgroundImage(new Image("application/stack02.jpg",1500,800,false,true)
	    		, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT
	    		, BackgroundSize.DEFAULT);
	    pane.setBackground(new Background(img));
	    Scene scene = new Scene( pane );          // setting the stage
	    primaryStage.setScene( scene ); 
	    primaryStage.show();

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
