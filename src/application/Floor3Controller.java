package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Floor3Controller implements Initializable {
	
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
	Label floorNumLbl;
	
	/*
	 
		A - Green - Available
		P-  Aqua  - Parked
		B-  Red   - bad
	 */
	
	char mat[][] = { { 'A', 'A', 'A', 'A' },
    				{ 'A', 'A', 'A', 'A' },
    				{ 'A', 'A', 'A', 'A' } };
	
	Rectangle m[][] ;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/********* initialize park status ***************
		rec1.setFill(Color.GREEN);
		rec2.setFill(Color.GREEN);
		rec3.setFill(Color.GREEN);
		rec4.setFill(Color.GREEN);
		rec5.setFill(Color.GREEN);
		rec6.setFill(Color.GREEN);
		rec7.setFill(Color.GREEN);
		rec8.setFill(Color.GREEN);
		rec9.setFill(Color.GREEN);
		rec10.setFill(Color.GREEN);
		rec11.setFill(Color.GREEN);
		rec12.setFill(Color.GREEN);
		*/
		m = new Rectangle[3][4];
		m[0][0] = rec1;
		m[0][1] = rec2;
		m[0][2] = rec3;
		m[0][3] = rec4;
		m[1][0] = rec5;
		m[1][1] = rec6;
		m[1][2] = rec7;
		m[1][3] = rec8;
		m[2][0] = rec9;
		m[2][1] = rec10;
		m[2][2] = rec11;
		m[2][3] = rec12;
		
		

		
	//	setdisabledPark(1, 1);

		
	}
	
	public void setdisabledPark(int x , int y)
	{
		m[x][y].setFill(Color.RED);
	}
	
	public void setAvailable(int x , int y)
	{
		m[x][y].setFill(Color.GREEN);
	}
	
	public void setParkedplace(int x , int y)
	{
		m[x][y].setFill(Color.AQUA);
	}

}
