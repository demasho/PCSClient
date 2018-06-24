package application;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Calendar;
import java.util.Date;

import client.ChatClient;
import client.ClientConsole;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SubscriptionSParkingController {
	private ClientConsole client = ClientConsole.getInstance();
	public static boolean flag1 =true;

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
		car_id_text0.setStyle("-fx-text-inner-color: black;");
		car_id_text1.setStyle("-fx-text-inner-color: black;");
		car_id_text2.setStyle("-fx-text-inner-color: black;");
		car_id_text3.setStyle("-fx-text-inner-color: black;");
		car_id_text4.setStyle("-fx-text-inner-color: black;");
		car_id_text5.setStyle("-fx-text-inner-color: black;");
		car_id_text6.setStyle("-fx-text-inner-color: black;");
		car_id_text7.setStyle("-fx-text-inner-color: black;");
		car_id_text8.setStyle("-fx-text-inner-color: black;");
		email_field.setStyle("-fx-text-inner-color: black;");
		numberOfCars.setStyle("-fx-text-inner-color: black;");
		start_date_field.setStyle("-fx-text-inner-color: black;");
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

		int foo =0;
		try {
			foo = Integer.parseInt(numberOfCars.getText().trim());
			if(foo<=0)
				throw new Exception();
			sent.append("true " + foo + " , ");
		}catch(Exception e){
			numberOfCars.setText("invalid input");
			numberOfCars.setStyle("-fx-text-inner-color: red;");
			flag=false;
		}
		//numbers of cars
		switch(foo)
		{
		case 1:
			car_id_text0.setDisable(false);
			if(flag1==false)
				try {
					car_id=car_id_text0.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text0.setText("invalid input");
					car_id_text0.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
			break;
		case 2:
			car_id_text0.setDisable(false);
			car_id_text1.setDisable(false);
			if(flag1==false)
			{
				try {
					car_id=car_id_text0.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text0.setText("invalid input");
					car_id_text0.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text1.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text1.setText("invalid input");
					car_id_text1.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
			}
			break;
		case 3:
			car_id_text0.setDisable(false);
			car_id_text1.setDisable(false);
			car_id_text2.setDisable(false);
			if(flag1==false)
			{
				try {
					car_id=car_id_text0.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text0.setText("invalid input");
					car_id_text0.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text1.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text1.setText("invalid input");
					car_id_text1.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text2.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text2.setText("invalid input");
					car_id_text2.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
			}
			break;
		case 4:
			car_id_text0.setDisable(false);
			car_id_text1.setDisable(false);
			car_id_text2.setDisable(false);
			car_id_text3.setDisable(false);
			if(flag1==false)
			{
				try {
					car_id=car_id_text0.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text0.setText("invalid input");
					car_id_text0.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text1.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text1.setText("invalid input");
					car_id_text1.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text2.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text2.setText("invalid input");
					car_id_text2.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text3.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text3.setText("invalid input");
					car_id_text3.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
			}
			break;
		case 5:
			car_id_text0.setDisable(false);
			car_id_text1.setDisable(false);
			car_id_text2.setDisable(false);
			car_id_text3.setDisable(false);
			car_id_text4.setDisable(false);
			if(flag1==false)
			{
				try {
					car_id=car_id_text0.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text0.setText("invalid input");
					car_id_text0.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text1.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text1.setText("invalid input");
					car_id_text1.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text2.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text2.setText("invalid input");
					car_id_text2.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text3.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text3.setText("invalid input");
					car_id_text3.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text4.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text4.setText("invalid input");
					car_id_text4.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
			}

		case 6:
			car_id_text0.setDisable(false);
			car_id_text1.setDisable(false);
			car_id_text2.setDisable(false);
			car_id_text3.setDisable(false);
			car_id_text4.setDisable(false);
			car_id_text5.setDisable(false);
			if(flag1==false)
			{
				try {
					car_id=car_id_text0.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text0.setText("invalid input");
					car_id_text0.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text1.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text1.setText("invalid input");
					car_id_text1.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text2.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text2.setText("invalid input");
					car_id_text2.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text3.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text3.setText("invalid input");
					car_id_text3.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text4.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text4.setText("invalid input");
					car_id_text4.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text5.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text5.setText("invalid input");
					car_id_text5.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
			}
			break;
		case 7:
			car_id_text0.setDisable(false);
			car_id_text1.setDisable(false);
			car_id_text2.setDisable(false);
			car_id_text3.setDisable(false);
			car_id_text4.setDisable(false);
			car_id_text5.setDisable(false);
			car_id_text6.setDisable(false);
			if(flag1==false)
			{
				try {
					car_id=car_id_text0.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text0.setText("invalid input");
					car_id_text0.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text1.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text1.setText("invalid input");
					car_id_text1.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text2.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text2.setText("invalid input");
					car_id_text2.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text3.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text3.setText("invalid input");
					car_id_text3.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text4.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text4.setText("invalid input");
					car_id_text4.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text5.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text5.setText("invalid input");
					car_id_text5.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text6.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text6.setText("invalid input");
					car_id_text6.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
			}
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
			if(flag1==false)
			{
				try {
					car_id=car_id_text0.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text0.setText("invalid input");
					car_id_text0.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text1.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text1.setText("invalid input");
					car_id_text1.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text2.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text2.setText("invalid input");
					car_id_text2.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text3.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text3.setText("invalid input");
					car_id_text3.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text4.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text4.setText("invalid input");
					car_id_text4.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text5.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text5.setText("invalid input");
					car_id_text5.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text6.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text6.setText("invalid input");
					car_id_text6.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text7.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text7.setText("invalid input");
					car_id_text7.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
			}
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
			if(flag1==false)
			{
				try {
					car_id=car_id_text0.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text0.setText("invalid input");
					car_id_text0.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text1.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text1.setText("invalid input");
					car_id_text1.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text2.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text2.setText("invalid input");
					car_id_text2.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text3.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text3.setText("invalid input");
					car_id_text3.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text4.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text4.setText("invalid input");
					car_id_text4.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text5.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text5.setText("invalid input");
					car_id_text5.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text6.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text6.setText("invalid input");
					car_id_text6.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text7.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text7.setText("invalid input");
					car_id_text7.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
				try {
					car_id=car_id_text8.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id + " ");
				}catch(Exception e){
					car_id_text8.setText("invalid input");
					car_id_text8.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}
			}
			break;
		}
		if(flag1==true)
		{
			flag1=false;
		}
		else
		{
			if(flag==true)
			{
				client.sendRequest(sent.toString());
				AlertBox.display("Loading .. click OK plese");
				while(client.Done==false)
				{
					if(client.Done==true)
						break;
				}
				AlertBox.display(client.Result);
				client.Done=false;
			}
			else
				AlertBox.display("הזמנת חניה", "הנתונים שגויים", "נא לעדכן את הנתונים");
		}

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
