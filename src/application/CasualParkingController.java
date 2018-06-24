package application;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.lang.Object;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.Observable;
import java.util.ResourceBundle;

import application.Main;
import client.ChatClient;
import client.ClientConsole;
import client.ObservableClient;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CasualParkingController extends Main implements Initializable{

	@FXML
	private TextField car_id_text;

	@FXML
	private TextField person_id_text;

	@FXML
	private ChoiceBox park_id_text;

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
	private ClientConsole client = ClientConsole.getInstance();


	//<PARKING_ID> <ENTRY_DATE> <RELEASE_DATE> <E-MAIL> <CUSTOMER_ID> <CAR_NUMBER>
	@FXML
	void NextOrderAction(ActionEvent event) throws IOException 
	{	
		StringBuilder sent=new StringBuilder();
		sent.append("CasualParking : ");
		String person_id = "";
		String park_id = "" ;
		String car_id;
		String end_minute = "";
		String end_hour="";
		String email = "";
		boolean flag=true;
		person_id_text.setStyle("-fx-text-inner-color: black;");
		car_id_text.setStyle("-fx-text-inner-color: black;");
		end_hour_field.setStyle("-fx-text-inner-color: black;");
		end_minute_field.setStyle("-fx-text-inner-color: black;");
		email_field.setStyle("-fx-text-inner-color: black;");
		park_id_text.setStyle("-fx-text-inner-color: black;");
		//////////
		try {
			park_id=park_id_text.getSelectionModel().getSelectedItem().toString();
				sent.append(park_id + " ");
		}catch(Exception e)
		{
			sent.append("111" + " ");
		}

		try {
			end_hour =end_hour_field.getText().trim().length() > 1 ? 
					end_hour_field.getText().trim() : "0"+end_hour_field.getText().trim();
			end_minute =end_minute_field.getText().trim().length() > 1 ? 
					end_minute_field.getText().trim() : "0"+end_minute_field.getText().trim();						
			if(!Validator.isValidEndTime(end_minute, end_hour))
				throw new Exception();
			Date now = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(now);
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH)+1;
			int day = cal.get(Calendar.DAY_OF_MONTH);
			String nowDate = year+"-"+month+"-"+day+"/"+now.getHours()
			+":"+now.getMinutes()+":00";
			String endDate =  year+"-"+month+"-"+day+"/"+end_hour
					+":"+end_minute+":00";
			sent.append(nowDate+" "+endDate+" ");
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
			sent.append(email+" ");
		}catch(Exception e){
			email_field.setText("invalid input");
			email_field.setStyle("-fx-text-inner-color: red;");
			flag=false;
		}

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
			sent.append(car_id);	
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
		stage.setOnCloseRequest(e -> stage.close());
		Stage curr = (Stage)back_order_button.getScene().getWindow();
		curr.close();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		client.sendRequest("GET_ALL_PARKINGS :");
		while(true)
		{
			System.out.println("while");
			if(client.Done==true)
				break;
		}
		String[] parts = null  ;
		if(client.Result.contains("Failed")== false)
		{
			 parts=client.Result.split(" ");	
		}
		else
		{
			AlertBox.display(client.Result);
		}
		client.Done=false;

		System.out.println("aaaaaa");
		park_id_text.setItems(FXCollections.observableArrayList(parts));
		
	}

}
