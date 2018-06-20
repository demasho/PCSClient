package application;

import client.ClientConsole;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class SignUp extends Application {
	String firstName, lastName , email , position , organization , signUpString ,workerId ,password,usernm;
	private ClientConsole client = ClientConsole.getInstance();
	public String getData()
	{
		return signUpString;
	}
	@Override
	public void start(Stage primaryStage) {		
		primaryStage.setTitle("יצירת משתמש חדש");
		GridPane grid = new GridPane();
		grid.setStyle("-fx-background-color: #336DFF;");
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text scenetitle = new Text("Sign Up");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);


		/************ first name ***************/
		Label fNamelbl = new Label("first name");
		grid.add(fNamelbl, 1, 1);

		TextField fNameTextField = new TextField();
		grid.add(fNameTextField, 0, 1);

		/************ last name ***************/
		Label lNamelbl = new Label("last name");
		grid.add(lNamelbl, 1, 2);

		TextField lNameTextField = new TextField();
		grid.add(lNameTextField, 0, 2);

		/************ email ***************/
		Label emailLbl = new Label("email");
		grid.add(emailLbl, 1, 3);

		TextField emailTextField = new TextField();
		grid.add(emailTextField, 0, 3);

		/************ role ***************/
		Label positionLbl = new Label("role");
		grid.add(positionLbl, 1, 4);
		ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList("Kiosk_Worker", "Service_Worker","Network_Manager", "Parking_Manager"));
		grid.add(cb, 0, 4);

		/************ parking id ***************/
		Label organizationLbl = new Label("parking id");
		grid.add(organizationLbl, 1, 5);
		TextField organizationTextField = new TextField();
		grid.add(organizationTextField, 0, 5);


		/************  password ***************/
		Label passwordLbl= new Label("password");
		grid.add(passwordLbl, 1, 6);
		PasswordField pwBox = new PasswordField();
		grid.add(pwBox, 0, 6);

		/************ username  ***************/
		Label username= new Label("username");
		grid.add(username, 1, 7);
		TextField usernameTextField = new TextField();
		grid.add(usernameTextField, 0, 7);
		/************  worker id ***************/
		Label idLbl= new Label("ID");
		grid.add(idLbl, 1, 8);
		TextField idTextField = new TextField();
		grid.add(idTextField, 0, 8);





		Button signInBtn = new Button("sign up");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(signInBtn);
		grid.add(hbBtn, 1, 9);

		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 10);

		signInBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				actiontarget.setFill(Color.FIREBRICK);
				actiontarget.setText("Signing up.. ");
				firstName = fNameTextField.getText();
				lastName = lNameTextField.getText();
				email  = emailTextField.getText();
				position = cb.getSelectionModel().getSelectedItem().toString();
				organization = organizationTextField.getText();
				workerId = idTextField.getText();
				password = pwBox.getText();
				usernm= usernameTextField.getText();

				if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() ||
						position.isEmpty() || organization.isEmpty() || workerId.isEmpty()|| password.isEmpty()|| usernm.isEmpty())
				{
					actiontarget.setText("please fill all fields.. ");
					signUpString = "missing data";


				}

				else 
				{
					if(Validator.isValidEmailAddress(email)==false) {
						actiontarget.setText("wrong email");
					}else {
						if(Validator.isValidPersonId(workerId)==false)
						{ 
							actiontarget.setText("wrong ID");
						}else {
							//<FIRST_NAME> <LAST_NAME> <WORKER_ID> <E-MAIL> <ROLE> <ParkingID> <USERNAME> <PASSWORD>
							signUpString = "SignUp : " + firstName + " " + lastName + " " + workerId + " " + email+ " " + position +
									" " + organization + " " +usernm + " "+ password;
							client.sendRequest(signUpString);
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
							mylert.setContentText(client.Result);
							mylert.show();
						}
					}
					System.out.println(signUpString);
				}              
			}
		});    
		Scene scene = new Scene(grid, 300, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	//	public static void main(String[] args) {
	//		launch(args);
	//	}
}
