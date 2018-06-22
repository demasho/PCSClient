package application;

import client.ClientConsole;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Start extends Application {
	@Override
	public void start(Stage primaryStage) {		
		primaryStage.setTitle("Welcome");
		GridPane grid = new GridPane();
		grid.setStyle("-fx-background-color: #336DFF;");
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(5);
		grid.setVgap(5);
		grid.setPadding(new Insets(5, 5, 5, 5));

		/************ host ***************/
		Label host = new Label(" Enter server host");
		grid.add(host, 1, 1);

		TextField h = new TextField();
		grid.add(h, 0, 1);

		/************ port ***************/
		Label lNamelbl = new Label(" Enter server port");
		grid.add(lNamelbl, 1, 2);

		TextField p = new TextField();
		grid.add(p, 0, 2);
		
		Button Run = new Button("Run");
		grid.add(Run, 0,3 );


		final TextField Consol = new TextField();
		Consol.setDisable(true);
		grid.add(Consol,1,3);		
		Run.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				try {
					ClientConsole.host=h.getText().trim();
					ClientConsole.port=Integer.parseInt(p.getText().trim());
					FirstWindow start = new FirstWindow();
					start.start(new Stage());
					primaryStage.close();
				} catch (Exception e1) {
					Consol.setText(e1.getMessage());
				}
			}
		});
		Scene scene = new Scene(grid, 300, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
