package application;

import java.io.IOException;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FirstWindow extends Application {

	private static boolean customer = false;
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Main Window");
		 GridPane grid = new GridPane();
		 grid.setStyle("-fx-background-color: #336DFF;");
		 grid.setAlignment(Pos.CENTER);
		 grid.setHgap(10);
		 grid.setVgap(10);
		 grid.setPadding(new Insets(25, 25, 25, 25));
		 
		 
		 
		 Button clientBtn = new Button("לקוח");
		 HBox hbBtn = new HBox(10);
		 hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		 hbBtn.getChildren().add(clientBtn);
		 grid.add(hbBtn, 7, 2);
		 
		 Button userBtn = new Button("משתמש מערכת");
		 HBox hbBtn1 = new HBox(10);
		 hbBtn1.setAlignment(Pos.BOTTOM_RIGHT);
		 hbBtn1.getChildren().add(userBtn);
		 grid.add(hbBtn1, 1, 2);
		 
		 clientBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				customer=true;
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CustomerScene.fxml"));
		    	GridPane root1 = null;
				try {
					root1 = fxmlLoader.load();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	Stage stage = new Stage();
		    	stage.setScene(new Scene(root1));  
		    	stage.show();
		    	stage.setOnCloseRequest(e -> stage.close());			
			}
		});
		 
		 userBtn.setOnAction(new EventHandler<ActionEvent>() {
			 @Override
			public void handle(ActionEvent event) {
				customer = false;
				Login login = new Login();
				login.start(new Stage());
			}
		});
		 Scene scene = new Scene(grid, 300, 275);
		 primaryStage.setScene(scene);
	        primaryStage.show();
	}
	
	public static boolean isCustomer()
	{
		return customer;
	}

//	public static void main(String[] args) {
//		launch(args);
//	}
}
