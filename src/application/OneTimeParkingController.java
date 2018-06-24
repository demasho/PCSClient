package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.EmptyStackException;
import java.util.ResourceBundle;

import client.ChatClient;
import client.ClientConsole;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
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

public class OneTimeParkingController implements Initializable {

	@FXML
	private TextField car_id_text;

	@FXML
	private TextField person_id_text;

	@FXML
	private ChoiceBox park_id_text;

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



	private ClientConsole client = ClientConsole.getInstance();

	@FXML
	void NextOrderAction(ActionEvent event) {
		StringBuilder sent=new StringBuilder();
		sent.append("OneTimeOrders : ");
		String person_id = null;
		String car_id;
		String park_id="111";
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
		end_date_text.setStyle("-fx-text-inner-color: black;");
		start_date_text.setStyle("-fx-text-inner-color: black;");
		////////////<CUSTOMER_ID> <PARKING_ID>  <ENTRY_DATE> <RELEASE_DATE> <E_MAIL> <CAR_NUMBER>
		try
		{
			person_id=person_id_text.getText().trim();
			if( Validator.isValidPersonId(person_id)==false )
				throw new Exception();
			sent.append(person_id+" ");
		}catch (Exception e) {
			person_id_text.setText("invalid input;");
			person_id_text.setStyle("-fx-text-inner-color: red;");
			flag=false;
		}

		try {
			park_id=park_id_text.getSelectionModel().getSelectedItem().toString();
				sent.append(park_id + " ");
		}catch(Exception e)
		{
			sent.append("111" + " ");
		}
		
    	
	
	//		System.out.println("Here: " + sent);

			Calendar cal = Calendar.getInstance();         
	    	 //arrival and leaving date/time check 
	         long leavingTimeInMilliSeconds = 0;
	         long currentTimeInMilliseconds = 0;
	         String leavingSummaryString = "";
	         int leavingTime_HH = 0;
	         int leavingTime_MM = 0;
		     int arrivalTime_HH = 0;
		     int arrivalTime_MM = 0;
		     long arrivalTimeInMilliSeconds = 0;
		     String arrivalSummaryString = "";
		     try {
		    	 //if this is empty an exception will be thrown
		    	 int arrivalYear = start_date_text.getValue().getYear();
		    	 int arrivalMonth = start_date_text.getValue().getMonthValue();
		    	 int arrivalDay = start_date_text.getValue().getDayOfMonth();
		    	 
		    	 //computing current time in milliseconds
		    	 currentTimeInMilliseconds = System.currentTimeMillis();		    	 

		    	 arrivalTime_HH = Integer.parseInt(start_hour_text.getText().toString().trim());
		    	 arrivalTime_MM = Integer.parseInt(start_minute_text.getText().toString().trim());
		    	 if((arrivalTime_HH < 0) || (arrivalTime_HH > 24) || (arrivalTime_MM < 0) || (arrivalTime_MM > 59)) {
		    		 throw new Exception();
		    	 }		    	 
		         cal.clear();
		         cal.set(arrivalYear, arrivalMonth-1, arrivalDay, arrivalTime_HH, arrivalTime_MM, 0);
		         //computing arrival time in milliseconds
		         arrivalTimeInMilliSeconds = cal.getTimeInMillis();
		         
		         //making sure the client didn't enter an older date
		         
		         if(currentTimeInMilliseconds > arrivalTimeInMilliSeconds) {
		    		 throw new Exception();
		         }
		         if(arrivalTime_HH<10 && arrivalTime_MM <10)
					sent.append(start_date_text.getValue()+"/"+"0"+arrivalTime_HH+":"+ "0"+arrivalTime_MM+":00 ");
		         else if (arrivalTime_HH <10)
					sent.append(start_date_text.getValue()+"/"+"0"+arrivalTime_HH+":"+arrivalTime_MM+":00 ");
		         else if (arrivalTime_MM<10)
						sent.append(start_date_text.getValue()+"/"+arrivalTime_HH+":"+ "0"+arrivalTime_MM+":00 ");
		         else 
						sent.append(start_date_text.getValue()+"/"+arrivalTime_HH+":"+arrivalTime_MM+":00 ");

		         
		         arrivalSummaryString = cal.getTime().toString();

		         //if this is empty an exception will be thrown
	        	 int leavingYear = end_date_text.getValue().getYear();
	        	 int leavingMonth = end_date_text.getValue().getMonthValue();
	        	 int leavingDay = end_date_text.getValue().getDayOfMonth();
	        	 		    	 
	        	 leavingTime_HH = Integer.parseInt(end_hour_field.getText().toString().trim());
	        	 leavingTime_MM = Integer.parseInt(end_minute_field.getText().toString().trim());
		    	 if((leavingTime_HH < 0) || (leavingTime_HH > 24) || (leavingTime_MM < 0) || (leavingTime_MM > 59)) {
		    		 throw new Exception();
		    	 }
		    	 
		         cal.clear();
		         cal.set(leavingYear, leavingMonth-1, leavingDay, leavingTime_HH, leavingTime_MM, 0);
		         //computing leaving time in milliseconds
		         leavingTimeInMilliSeconds = cal.getTimeInMillis();

		         //making sure the client didn't enter an older date
		         if(arrivalTimeInMilliSeconds > leavingTimeInMilliSeconds) {
		    		 throw new Exception();
		         }
		         if(leavingTime_HH<10 && leavingTime_MM <10)
					sent.append(end_date_text.getValue()+"/"+"0"+leavingTime_HH+":"+ "0"+leavingTime_MM+":00 ");
		         else if (leavingTime_HH <10)
					sent.append(end_date_text.getValue()+"/"+"0"+leavingTime_HH+":"+leavingTime_MM+":00 ");
		         else if (leavingTime_MM<10)
						sent.append(end_date_text.getValue()+"/"+leavingTime_HH+":"+ "0"+leavingTime_MM+":00 ");
		         else 
						sent.append(end_date_text.getValue()+"/"+leavingTime_HH+":"+leavingTime_MM+":00 ");

		         leavingSummaryString = cal.getTime().toString();
		         
		     } catch(Exception e) {
					end_date_text.setStyle("-fx-text-inner-color: red;");
					start_date_text.setStyle("-fx-text-inner-color: red;");
					start_hour_text.setStyle("-fx-text-inner-color: red;");
					start_minute_text.setStyle("-fx-text-inner-color: red;");
					end_hour_field.setStyle("-fx-text-inner-color: red;");
					end_minute_field.setStyle("-fx-text-inner-color: red;");
		    	flag=false;
		     }
				try {
					email=email_field.getText().trim();
					if(!Validator.isValidEmailAddress(email))
					{
						throw new Exception();

					}
					sent.append(email+" ");
				}catch(Exception e){
					email_field.setText("invalid input");
					email_field.setStyle("-fx-text-inner-color: red;");
					flag=false;
				}

		     try {
					car_id=car_id_text.getText().trim();
					if( Validator.isValidCarNumber(car_id)==false)
						throw new Exception();
					sent.append(car_id+" ");
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
		Stage curr = (Stage)next_order_button.getScene().getWindow();
	//	curr.close();


	}


	@FXML
	void back_order_action(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OrderParkScene.fxml"));
		BorderPane root1 = fxmlLoader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root1));  
		stage.show();
		stage.setOnCloseRequest(e -> Platform.exit());
		Stage curr = (Stage) back_order_button.getScene().getWindow();
		curr.close();
	}

	@FXML
	void email_text(ActionEvent event) {

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

	//	@FXML
	//	void ViewAllComplaints(ActionEvent event) {
	//		String Get = "GET_ALL_COMPLAINT : 333" ;//+ client.ParkingID ;
	//		client.sendRequest(Get);
	//		int hah=0;
	//		while(true)
	//		{
	//			System.out.println("while");
	//			if(client.Done==true)
	//				break;
	//		}
	//		System.out.println(client.Result);
	//		if(client.Result.contains("Failed to get")== false && client.Result.contains("There is no complaint")==false) {
	//			String res=client.Result.replace('|', '\n');
	//			ViewComplaints.setText(res);	
	//		}else {
	//			AlertBox.display(client.Result);
	//		}
	//		client.Done=false;
	//	}	

}
