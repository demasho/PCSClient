package application;

import java.io.IOException;

import client.ChatClient;
import client.ClientConsole;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SubscriptionSParkingController {
	private ClientConsole console = ClientConsole.getInstance();
	private ChatClient client=console.getClient();
	
	@FXML
	private TextField car_id_text0;

	@FXML
	private TextField car_id_text3;

	@FXML
	private TextField car_id_text6;

	@FXML
	private TextField car_id_text1;

	@FXML
	private TextField car_id_text4;

	@FXML
	private TextField car_id_text7;

	@FXML
	private TextField car_id_text2;

	@FXML
	private TextField car_id_text5;

	@FXML
	private TextField car_id_text8;

	@FXML
	private TextField car_id_text;

	@FXML
	private TextField person_id_text;

	@FXML
	private Button next_order_button;

	@FXML
	private Button back_order_button;

	@FXML
	private TextField email_field;

	@FXML
	private TextField numberOfCars;

	@FXML
	private DatePicker start_date_field;

	@FXML
	void NextOrderAction(ActionEvent event) {
		StringBuilder sent=new StringBuilder();
		sent.append("MonthlySubscription : ");
		String person_id = null;
		String car_id;
		String email = null;
		boolean flag=true;
		person_id_text.setStyle("-fx-text-inner-color: black;");
//		car_id_text.setStyle("-fx-text-inner-color: black;");
//		email_field.setStyle("-fx-text-inner-color: black;");
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
			//if(!Validator.isValidArrivalDate(start_date);
			//throw new Exception();
			sent.append(start_date_field.getValue().getYear() + "-" + start_date_field.getValue().getMonthValue() + "-" + start_date_field.getValue().getDayOfMonth() + " ");
		}catch(Exception e){
			//start_date_field.setText("invalid input");
			start_date_field.setStyle("-fx-text-inner-color: red;");
			flag=false;
		}


		try {
			email=email_field.getText().trim();
			if(!Validator.isValidEmailAddress(email))
				throw new Exception();
			sent.append(email + " ");
		}catch(Exception e){
			email_field.setText("invalid input");
			email_field.setStyle("-fx-text-inner-color: red;");
			flag=false;
		}

		try {
			email=email_field.getText().trim();
			if(!Validator.isValidEmailAddress(email))
				throw new Exception();
			sent.append(email + " ");
		}catch(Exception e){
			email_field.setText("invalid input");
			email_field.setStyle("-fx-text-inner-color: red;");
			flag=false;
		}
		int foo = Integer.parseInt(numberOfCars.getText().trim());
		
		sent.append("Yes " + foo + " ");

		/*try {
			car_id=car_id_text.getText().trim();
			if( Validator.isValidCarNumber(car_id)==false)
				throw new Exception();
			sent.append(car_id + " ");
		}catch(Exception e){
			car_id_text.setText("invalid input");
//			car_id_text.setStyle("-fx-text-inner-color: red;");
			flag=false;
		}*/

		switch(foo)
		{
		case 1:
			car_id_text0.setDisable(false);
			sent.append(car_id_text0.getText().trim() + " ");
			break;
		case 2:
			car_id_text0.setDisable(false);
			car_id_text1.setDisable(false);
			sent.append(car_id_text0.getText().trim() + " ");
			sent.append(car_id_text1.getText().trim() + " ");
			break;
		case 3:
			car_id_text0.setDisable(false);
			car_id_text1.setDisable(false);
			car_id_text2.setDisable(false);
			sent.append(car_id_text0.getText().trim() + " ");
			sent.append(car_id_text1.getText().trim() + " ");
			sent.append(car_id_text2.getText().trim() + " ");
			break;
		case 4:
			car_id_text0.setDisable(false);
			car_id_text1.setDisable(false);
			car_id_text2.setDisable(false);
			car_id_text3.setDisable(false);
			sent.append(car_id_text0.getText().trim() + " ");
			sent.append(car_id_text1.getText().trim() + " ");
			sent.append(car_id_text2.getText().trim() + " ");
			sent.append(car_id_text3.getText().trim() + " ");
			break;
		case 5:
			car_id_text0.setDisable(false);
			car_id_text1.setDisable(false);
			car_id_text2.setDisable(false);
			car_id_text3.setDisable(false);
			car_id_text4.setDisable(false);
			sent.append(car_id_text0.getText().trim() + " ");
			sent.append(car_id_text1.getText().trim() + " ");
			sent.append(car_id_text2.getText().trim() + " ");
			sent.append(car_id_text3.getText().trim() + " ");
			sent.append(car_id_text4.getText().trim()+ " ");
			break;
		case 6:
			car_id_text0.setDisable(false);
			car_id_text1.setDisable(false);
			car_id_text2.setDisable(false);
			car_id_text3.setDisable(false);
			car_id_text4.setDisable(false);
			car_id_text5.setDisable(false);
			sent.append(car_id_text0.getText().trim() + " ");
			sent.append(car_id_text1.getText().trim() + " ");
			sent.append(car_id_text2.getText().trim() + " ");
			sent.append(car_id_text3.getText().trim() + " ");
			sent.append(car_id_text4.getText().trim()+ " ");
			sent.append(car_id_text5.getText().trim()+ " ");
			break;
		case 7:
			car_id_text0.setDisable(false);
			car_id_text1.setDisable(false);
			car_id_text2.setDisable(false);
			car_id_text3.setDisable(false);
			car_id_text4.setDisable(false);
			car_id_text5.setDisable(false);
			car_id_text6.setDisable(false);
			sent.append(car_id_text0.getText().trim() + " ");
			sent.append(car_id_text1.getText().trim() + " ");
			sent.append(car_id_text2.getText().trim() + " ");
			sent.append(car_id_text3.getText().trim() + " ");
			sent.append(car_id_text4.getText().trim()+ " ");
			sent.append(car_id_text5.getText().trim()+ " ");
			sent.append(car_id_text6.getText().trim() + " ");
			break;
		case 8:
			car_id_text0.setDisable(false);
			car_id_text1.setDisable(false);
			car_id_text2.setDisable(false);
			car_id_text3.setDisable(false);
			car_id_text4.setDisable(false);
			car_id_text5.setDisable(false);
			car_id_text6.setDisable(false);
			car_id_text7.setDisable(false);
			sent.append(car_id_text0.getText().trim() + " ");
			sent.append(car_id_text1.getText().trim() + " ");
			sent.append(car_id_text2.getText().trim() + " ");
			sent.append(car_id_text3.getText().trim() + " ");
			sent.append(car_id_text4.getText().trim()+ " ");
			sent.append(car_id_text5.getText().trim()+ " ");
			sent.append(car_id_text6.getText().trim() + " ");
			sent.append(car_id_text7.getText().trim()+ " ");
			break;
		case 9:
			car_id_text0.setDisable(false);
			car_id_text1.setDisable(false);
			car_id_text2.setDisable(false);
			car_id_text3.setDisable(false);
			car_id_text4.setDisable(false);
			car_id_text5.setDisable(false);
			car_id_text6.setDisable(false);
			car_id_text7.setDisable(false);
			car_id_text8.setDisable(false);
			sent.append(car_id_text0.getText().trim() + " ");
			sent.append(car_id_text1.getText().trim() + " ");
			sent.append(car_id_text2.getText().trim() + " ");
			sent.append(car_id_text3.getText().trim() + " ");
			sent.append(car_id_text4.getText().trim()+ " ");
			sent.append(car_id_text5.getText().trim()+ " ");
			sent.append(car_id_text6.getText().trim() + " ");
			sent.append(car_id_text7.getText().trim()+ " ");
			sent.append(car_id_text8.getText().trim() + " ");
			break;
		}

		if(flag==true)
		{
			AlertBox.display("Loading", "Loading .....", "Please Wait");
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
