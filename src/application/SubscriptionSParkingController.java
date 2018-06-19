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
			String month="" ;
			String day="" ;
			if(start_date_field.getValue().getMonthValue() <= 9)
				month = "0"+Integer.toString(start_date_field.getValue().getMonthValue());
			else 
				month = Integer.toString(start_date_field.getValue().getMonthValue()) ;
			if(start_date_field.getValue().getDayOfMonth() <= 9)
				day=("0"+start_date_field.getValue().getDayOfMonth());
			else 
				day=Integer.toString(start_date_field.getValue().getDayOfMonth());
			sent.append(start_date_field.getValue().getYear() + "-" + month 
					+ "-" + day + "/00:00:00 ");
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
				System.out.println(sent.toString());
				AlertBox.display("Loading", "Loading .....", "Please Wait");
				client.handleMessageFromClientUI(sent.toString());
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
