package application;

import java.io.IOException;

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
    	String person_id = null;
		String car_id;
		String start_date;
		String email = null;
		String num_of_cars;
		person_id_text.setStyle("-fx-text-inner-color: black;");
		car_id_text.setStyle("-fx-text-inner-color: black;");
		email_field.setStyle("-fx-text-inner-color: black;");
		car_id_text.setStyle("-fx-text-inner-color: black;");
		numberOfCars.setStyle("-fx-text-inner-color: black;");
		boolean flag=true;
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
			start_date=start_date_field.toString();
		}catch(Exception e){
			
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
		
		try {
			num_of_cars=numberOfCars.toString();
			boolean numeric = true;
			try {
				Double num = Double.parseDouble(num_of_cars);
			} catch (NumberFormatException e) {
				numeric = false;
			}
			if(numeric)
				throw new Exception();
		}catch(Exception e){
			numberOfCars.setText("invalid input");
			numberOfCars.setStyle("-fx-text-inner-color: red;");
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

}
