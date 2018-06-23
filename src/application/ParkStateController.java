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
	
	
	public int column_num,savedParks;
	

	public char[][] mat1  ;	
	public char[][] mat2 ;	
	public char[][] mat3 ;	
	
	public ParkStateController() {
		
	}
	
	
	// ex. for data : P(x,y,z) P(x,y,z) P(x,y,z) A(x,y,z) A(x,y,z) A(x,y,z) 2 4
	public  void createPark(String data)
	{
		String[] array = data.split("\\ "); 	
		column_num =  Integer.parseInt(array[array.length-1]);
		savedParks =  Integer.parseInt(array[array.length-2]);
		String[] newArray = new String[array.length-2];
		newArray=Arrays.copyOf(array,array.length-2);
		System.out.println(Arrays.toString(newArray));
		mat1 = new char[3][column_num];
		mat2 = new char[3][column_num];
		mat3 = new char[3][column_num];
		char parkState; // P (Parked) , A (Available) , B (Bad)
		char row,col,floor;
		
	//	System.out.println("hakuna matata");
	//	System.out.println(Arrays.toString(newArray));
	//	System.out.println(availableParks);
	//	System.out.println(column_num);
		
		for (int i = 0; i < newArray.length; i++)
		{
			parkState = (newArray[i]).charAt(0);
			col = (newArray[i]).charAt(2);
			row = (newArray[i]).charAt(4);
			floor = (newArray[i]).charAt(6);
			
			int x = Character.getNumericValue(row);
			int y = Character.getNumericValue(col);
			
			if(floor=='0')
			{
				if(parkState=='P')
				{
					mat1[x][y] = 'P';	
				}
					
				if(parkState=='B')
				{
					mat1[x][y] = 'B';
				}
				
				if(parkState=='A')
				{
					mat1[x][y] = 'A';
				}
				
			}
			if(floor=='1')
			{
				if(parkState=='P')
				{
					mat2[x][y] = 'P';
				}
					
				if(parkState=='B')
				{
					mat2[x][y] = 'B';
				}
				
				if(parkState=='A')
				{
					mat2[x][y] = 'A';
				}
				
			}
			if(floor=='2')
			{
				if(parkState=='P')
				{
					mat3[x][y] = 'P';
				}
					
				if(parkState=='B')
				{
					mat3[x][y] = 'B';
				}
				
				if(parkState=='A')
				{
					mat3[x][y] = 'A';
				}
			}
			
			
		}
		
		
	}
}
