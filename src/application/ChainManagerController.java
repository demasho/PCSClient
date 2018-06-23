package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import client.ClientConsole;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ChainManagerController implements Initializable {
	@FXML
	ChoiceBox cb;
	@FXML
	ChoiceBox cbFloor;
	@FXML
	Button okBtn;
	@FXML
	Button notOk;
	@FXML
	Label label;
	
	public static int floorNum;
	int columns;
	public static String parkAssignment;
	
	private ClientConsole client = ClientConsole.getInstance();
	
	String selectedChoice ,selectedChoiceFloor ,allParkings;
	boolean priceUpdated = false;
	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
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
		cb.setItems(FXCollections.observableArrayList(parts));
		
		/****** check if prices were updated *****/
		client.sendRequest("GET_UPDATED_PRICES :");
		while(true)
		{
			System.out.println("while");
			if(client.Done==true)
				break;
		}
		String finalRes = null;
		if(client.Result.contains("New Prices"))
		{
			System.out.println("contains new prices");
			parts=client.Result.split(" ");
			finalRes = client.Result.replace("$", "\n");
			priceUpdated = true;
		}
		else
		{
			 	System.out.println("does not contain new prices");
				priceUpdated = false;
		}
		
		client.Done=false;
		
		
		//New Prices : CasualParking -> 9.0$ OneTimeOrders -> 9.0$ FullMonthlySubscription -> 9.0$ BusinessMonthlySubscription -> 9.0$
		if(priceUpdated)
		{
			System.out.println("in if priceUpdated");
			label.setText(finalRes);
			okBtn.setVisible(true);
			notOk.setVisible(true);
			label.setVisible(true);
		}
		
		cb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
		      @Override
		      public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
		    	  selectedChoice = (String) (cb.getItems().get((Integer) number2));
		      }
		    });
		
	
		cbFloor.setItems(FXCollections.observableArrayList(
			    "1", "2", 
			    "3")
			);
		cbFloor.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
		      @Override
		      public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
		    	  selectedChoiceFloor = (String) (cbFloor.getItems().get((Integer) number2));
		      }
		    });

	}
	@FXML
	void viewParkClick(ActionEvent ae)
	{
		if(selectedChoice==null || selectedChoiceFloor==null)
		{
			AlertBox.display("please select park and floor");
		}
		else {
			parkAssignment = "";

			String Choice =cb.getSelectionModel().getSelectedItem().toString().trim();
			/************ connect with server *****************/
			String request = "PARKING_SNAPSHOT : "+Choice;

			client.sendRequest(request.toString());
				
			while(client.Done==false)
			{
				System.out.println("while");
				if(client.Done==true)
					break;
			}
			//client.Done=false;
			
			if(client.Result.contains("Failed"))
			{
				System.out.println("failed miserably");
				
			}
			else {
				parkAssignment = client.Result;
			} 
			
			columns = Character.getNumericValue( parkAssignment.charAt(parkAssignment.length()-1));
		//	ParkStateController ps = new ParkStateController();
		//	ps.createPark("P(0,0,1) P(1,1,1) P(0,0,2) A(1,1,2) A(0,0,3) A(1,1,3) 2");
			
			try {
				if(selectedChoiceFloor=="1")
				{
					floorNum=1;
					loadFloor(columns);
				}
					
				if(selectedChoiceFloor=="2")
				{
					floorNum=2;
					loadFloor(columns);
				}
					
				if(selectedChoiceFloor=="3")
				{
					floorNum=3;
					loadFloor(columns);
				}
					
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	@FXML
	void OkAction(ActionEvent ae)
	{
		client.sendRequest("APPROVES_PRICES : ");
		label.setText(" ");
	}
	@FXML
	void notOkAction(ActionEvent ae)
	{
		client.sendRequest("NOT_APPROVES_PRICES : ");
		label.setText(" ");
	}
	
	void setUpdatedPrice()
	{
		priceUpdated = true;
	}
	
	
	public void loadFloor(int numberOfCol) throws IOException
	{
		FXMLLoader fxmlLoader = null;
		if(numberOfCol==4)
			fxmlLoader = new FXMLLoader(getClass().getResource("FloorScene4.fxml"));
		if(numberOfCol==5)
			fxmlLoader = new FXMLLoader(getClass().getResource("FloorScene5.fxml"));
		if(numberOfCol==6)
			fxmlLoader = new FXMLLoader(getClass().getResource("FloorScene6.fxml"));
		if(numberOfCol==7)
			fxmlLoader = new FXMLLoader(getClass().getResource("FloorScene7.fxml"));
		if(numberOfCol==8)
			fxmlLoader = new FXMLLoader(getClass().getResource("FloorScene8.fxml"));
		GridPane root1= fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setScene(new Scene(root1));  
    	stage.show();    	
    	stage.setOnCloseRequest(e -> stage.close());
	}

	/*
	public void loadFloor2() throws IOException
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Floor2Scene.fxml"));
		GridPane root1= fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setScene(new Scene(root1));  
    	stage.show();    	
    	stage.setOnCloseRequest(e -> Platform.exit());
	}

	public void loadFloor3() throws IOException
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Floor3Scene.fxml"));
		GridPane root1= fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setScene(new Scene(root1));  
    	stage.show();    	
    	stage.setOnCloseRequest(e -> Platform.exit());
	}
	*/
}
