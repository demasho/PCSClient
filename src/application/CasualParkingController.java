package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.lang.Object;
import java.util.Observable;
import application.Main;
import client.ChatClient;
import client.ClientConsole;
import client.ObservableClient;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CasualParkingController extends Main {

	@FXML
	private TextField car_id_text;

	@FXML
	private TextField person_id_text;

	@FXML
	private TextField end_minute_field;

	@FXML
	private TextField end_hour_field;

	@FXML
	private Button next_order_button;

	@FXML
	private Button back_order_button;

	@FXML
	private TextField email_field;
	private ClientConsole console = ClientConsole.getInstance();
	private ChatClient client=console.getClient();


	@FXML
	void NextOrderAction(ActionEvent event) throws IOException 
	{	
		StringBuilder sent=new StringBuilder();
		sent.append("CasualParking : ");
		String person_id = null;
		String car_id;
		String end_minute = null;
		String end_hour=null;
		String email = null;
		boolean flag=true;
		person_id_text.setStyle("-fx-text-inner-color: black;");
		car_id_text.setStyle("-fx-text-inner-color: black;");
		end_hour_field.setStyle("-fx-text-inner-color: black;");
		end_minute_field.setStyle("-fx-text-inner-color: black;");
		email_field.setStyle("-fx-text-inner-color: black;");
		//////////
		try
		{
			person_id=person_id_text.getText().trim();
			if( Validator.isValidPersonId(person_id)==false )
				throw new Exception();
			sent.append(person_id + " ");
		}catch (Exception e) {
			person_id_text.setText("invalid input;");
			person_id_text.setStyle("-fx-text-inner-color: red;");
			flag=false;
		}

		try {
			car_id=car_id_text.getText().trim();
			if( Validator.isValidCarNumber(car_id)==false)
				throw new Exception();
			sent.append(car_id + " ");	
		}catch(Exception e){
			car_id_text.setText("invalid input");
			car_id_text.setStyle("-fx-text-inner-color: red;");
			flag=false;
		}


		try {
			end_minute =end_minute_field.getText().trim();
			end_hour =end_hour_field.getText().trim();
			if(!Validator.isValidEndTime(end_minute, end_hour))
				throw new Exception();
			sent.append(end_hour + ":" + end_minute);
		}catch(Exception e){
			end_hour_field.setText("invalid input");
			end_hour_field.setStyle("-fx-text-inner-color: red;");
			end_minute_field.setText("invalid input");
			end_minute_field.setStyle("-fx-text-inner-color: red;");
			flag=false;
		}

		try {
			email=email_field.getText().trim();
			if(!Validator.isValidEmailAddress(email))
				throw new Exception();
			sent.append(" " + email);
		}catch(Exception e){
			email_field.setText("invalid input");
			email_field.setStyle("-fx-text-inner-color: red;");
			flag=false;
		}
		if(flag==true)
		{
			AlertBox.display("Loading", "Loading .....", "Please Waitt");
			client.handleMessageFromClientUI(sent.toString());
		}
		else
			AlertBox.display("הזמנת חניה", "הנתונים שגויים", "נא לעדכן את הנתונים");


	}

	@FXML
	void back_order_action(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OrderParkScene.fxml"));
    	BorderPane root1 = fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setScene(new Scene(root1));  
    	stage.show();
    	stage.setOnCloseRequest(e -> Platform.exit());
	}

}
