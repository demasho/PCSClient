package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

import client.ChatClient;
import client.ClientConsole;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SubscriptionParkingController {

	@FXML
	private TextField car_id_text;

	@FXML
	private TextField person_id_text;

	@FXML
	private Button next_order_button;

	@FXML
	private DatePicker start_date_field;

	@FXML
	private Button back_order_button;

	@FXML
	private TextField email_field;

	private ClientConsole client = ClientConsole.getInstance();

	boolean flag=true;
	@FXML
	void NextOrderAction(ActionEvent event) {
		StringBuilder sent=new StringBuilder();
		StringBuilder start_date=new StringBuilder();
		sent.append("MonthlySubscription : ");
		String person_id = null;
		String car_id;
		String email = null;
		person_id_text.setStyle("-fx-text-inner-color: black;");
		car_id_text.setStyle("-fx-text-inner-color: black;");
		email_field.setStyle("-fx-text-inner-color: black;");
		start_date_field.setStyle("-fx-text-inner-color: black;");
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

		Calendar cal = Calendar.getInstance();
        long currentdaymilliseconds = 0;
        long orderstartmilisenconds = 0;
    	try {
	    	 int currentYear = cal.get(Calendar.YEAR);
	    	 int currentMonth = cal.get(Calendar.MONTH);
	    	 int currentDay = cal.get(Calendar.DAY_OF_MONTH);
	    	 int year = start_date_field.getValue().getYear();
	    	 int month = start_date_field.getValue().getMonthValue();
	    	 int day = start_date_field.getValue().getDayOfMonth();
	    	 cal.clear();
	    	 cal.set(currentYear, currentMonth, currentDay);
	    	 currentdaymilliseconds = cal.getTimeInMillis();
	    	 cal.clear();
	         cal.set(year, month-1, day);
	         orderstartmilisenconds = cal.getTimeInMillis();
	         if(currentdaymilliseconds > orderstartmilisenconds) {
	    		 throw new Exception();
	         }		
			sent.append(start_date_field.getValue()+"/00:00:00 ");
		}catch(Exception e){
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

		sent.append("false 1 , ");

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


		if(flag==true)
		{
			client.sendRequest(sent.toString());
			AlertBox.display("Loading .. click OK plese");
			while(client.Done==false)
			{
				System.out.println("while");
				if(client.Done==true)
					break;
			}
			AlertBox.display(client.Result);
			client.Done=false;
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
		Stage curr = (Stage)back_order_button.getScene().getWindow();
		curr.close();
	}

}
