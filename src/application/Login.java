package application;

import java.io.IOException;

import client.ClientConsole;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class Login extends Application {
	String username;
	String password;
	String signInString;

	private ClientConsole client = ClientConsole.getInstance();

	public String getData()
	{
		return signInString;
	}
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("התחברות");
		GridPane grid = new GridPane();
		grid.setStyle("-fx-background-color: #336DFF;");
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text scenetitle = new Text("התחברות");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);


		Label userName = new Label("שם משתמש:");
		grid.add(userName, 1, 1);

		TextField userTextField = new TextField();
		grid.add(userTextField, 0, 1);


		Label pw = new Label("סיסמא:");
		grid.add(pw, 1, 2);


		PasswordField pwBox = new PasswordField();
		grid.add(pwBox, 0, 2);


		Button signInBtn = new Button("התחבר");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(signInBtn);
		grid.add(hbBtn, 1, 4);

		Button signUpBtn = new Button("הרשמה");
		HBox hb1Btn = new HBox(10);
		hb1Btn.setAlignment(Pos.BOTTOM_LEFT);
		hb1Btn.getChildren().add(signUpBtn);
		grid.add(hb1Btn, 0, 4);

		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 6);

		signInBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				actiontarget.setFill(Color.FIREBRICK);
				actiontarget.setText("Signing in.. ");

				username = userTextField.getText();
				password=pwBox.getText();

				if(username.isEmpty())
				{
					actiontarget.setText("please enter username.. ");
					signInString  = "missing data";
					AlertBox.display("please enter username.. ");
				}

				else if(password.isEmpty())
				{
					actiontarget.setText("please enter password.. ");
					signInString  = "missing data";
					AlertBox.display("please enter password.. ");

				}

				else {
					signInString = "Login : " + username + " " + password;
					client.sendRequest(signInString);
					javafx.scene.control.Alert mylert = new Alert(Alert.AlertType.INFORMATION," Operation in Progress");
					mylert.setResizable(true);
					mylert.getDialogPane().setPrefSize(480, 170);
					mylert.show();
					while(client.Done==false)
					{
						if(client.Done==true)
							break;
					}
					client.Done=false;
					if(client.Result.contains("Success")==true) {
						String msg=client.Result;
						String role = msg.substring(msg.indexOf(":")+2, msg.length());
						try {
							if(role.contains("Kiosk_Worker"))
								loadKyoskWorker();
							if(role.contains("Service_Worker"))
								loadServiceWoker();
							if(role.contains("Network_Manager"))
								loadChainManager();
							if(role.contains("Parking_Manager"))
								loadAdmin();
							
						}
						catch(Exception f){}
					}
					else {
						mylert.setContentText(client.Result);
						mylert.show();
					}
				}
			}
		});

		signUpBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				SignUp signup = new SignUp();
				signup.start(new Stage());

			}
		});

		Scene scene = new Scene(grid, 300, 275);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void loadAdmin() throws IOException
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdministratorScene.fxml"));
		BorderPane root1= fxmlLoader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root1));  
		stage.show();    	
		stage.setOnCloseRequest(e -> Platform.exit());
	}
	public void loadChainManager() throws IOException
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ChainManager.fxml"));
		BorderPane root1= fxmlLoader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root1));  
		stage.show();    	
		stage.setOnCloseRequest(e -> Platform.exit());
	}
	public void loadKyoskWorker() throws IOException
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("KyoskerScene.fxml"));
		BorderPane root1= fxmlLoader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root1));  
		stage.show();    	
		stage.setOnCloseRequest(e -> Platform.exit());
	}
	public void loadServiceWoker() throws IOException
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ServiceWorkerScene.fxml"));
		BorderPane root1= fxmlLoader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root1));  
		stage.show();    	
		stage.setOnCloseRequest(e -> Platform.exit());
	}

	public static void main(String[] args) {
		launch(args);
	}
}
