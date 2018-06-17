package application;

import java.io.IOException;
import java.util.Calendar;
import java.util.EmptyStackException;

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

public class OneTimeParkingController {

    @FXML
    private TextField car_id_text;

    @FXML
    private TextField person_id_text;

    @FXML
    private TextField park_id_text;

    @FXML
    private TextField email_field;

    @FXML
    private Button next_order_button;

    @FXML
    private Button back_order_button;

    @FXML
    private DatePicker start_date_text;

    @FXML
    private TextField start_hour_text;

    @FXML
    private TextField start_minute_text;

    @FXML
    private DatePicker end_date_text;

    @FXML
    private TextField end_minute_field;

    @FXML
    private TextField end_hour_field;

    @FXML
    void NextOrderAction(ActionEvent event) {
    	String person_id = null;
		String car_id;
		String park_id;
		String start_date;
		String start_time_hour;
		String start_time_minute;
		String end_date;
		String end_time_hour;
		String end_time_minute;
		String email = null;
		boolean flag=true;
		person_id_text.setStyle("-fx-text-inner-color: black;");
		car_id_text.setStyle("-fx-text-inner-color: black;");
		email_field.setStyle("-fx-text-inner-color: black;");
		car_id_text.setStyle("-fx-text-inner-color: black;");
		park_id_text.setStyle("-fx-text-inner-color: black;");
		end_hour_field.setStyle("-fx-text-inner-color: black;");
		end_minute_field.setStyle("-fx-text-inner-color: black;");
		start_hour_text.setStyle("-fx-text-inner-color: black;");
		start_minute_text.setStyle("-fx-text-inner-color: black;");
		//////////
		try
		{
			person_id=person_id_text.getText().trim();
			if( Validator.isValidPersonId(person_id)==false )
				throw new Exception();
		}catch (Exception e) {
			person_id_text.setText("invalid input;");
			person_id_text.setStyle("-fx-text-inner-color: red;");
			flag=false;
		}

		try {
			car_id=car_id_text.getText().trim();
			if( Validator.isValidCarNumber(car_id)==false)
				throw new Exception();
		}catch(Exception e){
			car_id_text.setText("invalid input");
			car_id_text.setStyle("-fx-text-inner-color: red;");
			flag=false;
		}
		
		try {
			park_id=park_id_text.getText().trim();
			if(!Validator.isValidRequestedPark(park_id));
				throw new Exception();
		}catch(Exception e) {
			park_id_text.setText("invalid input");
			park_id_text.setStyle("-fx-text-inner-color: red;");
			flag=false;
		}
		
		try {
			email=email_field.getText().trim();
			if(!Validator.isValidEmailAddress(email))
			{
				throw new Exception();

			}
		}catch(Exception e){
			email_field.setText("invalid input");
			email_field.setStyle("-fx-text-inner-color: red;");
			flag=false;
		}
		 
//	    	 String year = start_date_text
//	    	 String month = start_date_text.getValue().getMonthValue();
//	    	 string day = start_date_text.getValue().getDayOfMonth();

		
		try {
			start_time_minute =start_minute_text.getText().trim();
			start_time_hour =start_hour_text.getText().trim();
			if(!Validator.isValidEndTime(start_time_minute, start_time_hour))
				throw new Exception();

		}catch(Exception e){
			start_hour_text.setText("invalid input");
			start_hour_text.setStyle("-fx-text-inner-color: red;");
			start_minute_text.setText("invalid input");
			start_minute_text.setStyle("-fx-text-inner-color: red;");
			flag=false;
		}
		
//		try{
//		 end_date=end_date_text.
//		}
		
		try {
			end_time_minute =end_minute_field.getText().trim();
			end_time_hour =end_hour_field.getText().trim();
			if(!Validator.isValidEndTime(end_time_minute, end_time_hour))
				throw new Exception();

		}catch(Exception e){
			end_hour_field.setText("invalid input");
			end_hour_field.setStyle("-fx-text-inner-color: red;");
			end_minute_field.setText("invalid input");
			end_minute_field.setStyle("-fx-text-inner-color: red;");
			flag=false;
		}
		if(flag==true)
			AlertBox.display("Loading", "Loading .....", "Please Wait");
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

    @FXML
    void email_text(ActionEvent event) {

    }

}
