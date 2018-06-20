package application;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ParkStateController {
/*
	@FXML
	GridPane gridPane;
	@FXML
	Rectangle rec1;
	@FXML
	Rectangle rec2;
	@FXML
	Rectangle rec3;
	@FXML
	Rectangle rec4;
	@FXML
	Rectangle rec5;
	@FXML
	Rectangle rec6;
	@FXML
	Rectangle rec7;
	@FXML
	Rectangle rec8;
	@FXML
	Rectangle rec9;
	@FXML
	Rectangle rec10;
	@FXML
	Rectangle rec11;
	@FXML
	Rectangle rec12;
	@FXML
	Label floorNumLbl; */
	
	
	int max_size=100;
	
	Floor1Controller floor1;
	Floor2Controller floor2;
	Floor3Controller floor3;
	
	public ParkStateController() {
		
		floor1 = new Floor1Controller();
		floor2 = new Floor2Controller();
		floor3 = new Floor3Controller();
		
	}
	
	
	public void setParkSize(int size)
	{
		max_size = size;
	}
	// ex. for data : P(x,y,z) P(x,y,z) P(x,y,z) A(x,y,z) A(x,y,z) A(x,y,z) 2
	public  void createPark(String data)
	{
		
		String[] array = data.split("\\ "); 
		System.out.println(Arrays.toString(array));
		
		int availableParks =  Integer.parseInt(array[array.length-1]);
		
		String[] newArray = new String[array.length-1];
		newArray=Arrays.copyOf(array,array.length-1);
		
		char parkState; // P (Parked) , A (Available) , B (Bad)
		char row,col,floor;
		
	//	System.out.println(Arrays.toString(newArray));
	//	System.out.println(availableParks);
		
		for (int i = 0; i < newArray.length; i++)
		{
			parkState = (newArray[i]).charAt(0);
			row = (newArray[i]).charAt(2);
			col = (newArray[i]).charAt(4);
			floor = (newArray[i]).charAt(6);
			
			if(floor=='1')
			{
				if(parkState=='P')
				{
					System.out.println("el3ab yala");
					int x = Character.getNumericValue(row);
					int y = Character.getNumericValue(col);
					System.out.println(x);
					System.out.println(y);
					floor1.setParkedplace(Character.getNumericValue(row), Character.getNumericValue(col));	
				}
					
				if(parkState=='B')
					floor1.setdisabledPark(Character.getNumericValue(row), Character.getNumericValue(col));
				if(parkState=='A')
					floor1.setAvailable(Character.getNumericValue(row), Character.getNumericValue(col));
				
			}
			if(floor=='2')
			{
				if(parkState=='P')
					floor2.setParkedplace(Character.getNumericValue(row), Character.getNumericValue(col));
				if(parkState=='B')
					floor2.setdisabledPark(Character.getNumericValue(row), Character.getNumericValue(col));
				if(parkState=='A')
					floor2.setAvailable(Character.getNumericValue(row), Character.getNumericValue(col));
				
			}
			if(floor=='3')
			{
				if(parkState=='P')
					floor3.setParkedplace(Character.getNumericValue(row), Character.getNumericValue(col));
				if(parkState=='B')
					floor3.setdisabledPark(Character.getNumericValue(row), Character.getNumericValue(col));
				if(parkState=='A')
					floor3.setAvailable(Character.getNumericValue(row), Character.getNumericValue(col));
				
			}
			
			
		}
		
		
	}
	
	public void loadFloor1() throws IOException
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Floor1Scene.fxml"));
		GridPane root1= fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setScene(new Scene(root1));  
    	stage.show();    	
    	stage.setOnCloseRequest(e -> Platform.exit());
	}

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
}
