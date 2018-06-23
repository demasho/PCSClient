package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class FloorController7 implements Initializable {
	
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
	Rectangle rec13;
	@FXML
	Rectangle rec14;
	@FXML
	Rectangle rec15;
	@FXML
	Rectangle rec16;
	@FXML
	Rectangle rec17;
	@FXML
	Rectangle rec18;
	@FXML
	Rectangle rec19;
	@FXML
	Rectangle rec20;
	@FXML
	Rectangle rec21;
	@FXML
	Label floorNumLbl;
	@FXML
	Label savedParksLbl;
	/*
	 
		A - Green - Available
		P-  Aqua  - Parked
		B-  Red   - bad
	 */
	
	char mat[][] = { { 'A', 'A', 'A', 'A','A','A' ,'A' },
    				{ 'A', 'A', 'A', 'A','A' ,'A','A' },
    				{ 'A', 'A', 'A', 'A' ,'A','A','A' } };
	
	Rectangle  m[][] = new Rectangle[3][7] ;
	
	ParkStateController ps;
	int columns;
	public FloorController7()
	{
		ps = new ParkStateController();
		ps.createPark(ChainManagerController.parkAssignment);
		columns  = ps.column_num;
		System.out.println("floor1 c'tor");
		 m = new Rectangle[3][columns] ;
		 mat = new char[3][columns];
	}
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
		
		/*/
		m[0][0] = rec1;
		m[0][1] = rec2;
		m[0][2] = rec3;
		m[0][3] = rec4;
		m[0][4] = rec5;
		m[0][5] = rec6;
		m[0][6] = rec7;
		m[1][0] = rec8;
		m[1][1] = rec9;
		m[1][2] = rec10;
		m[1][3] = rec11;
		m[1][4] = rec12;
		m[1][5] = rec13;
		m[1][6] = rec14;
		m[2][0] = rec15;
		m[2][1] = rec16;
		m[2][2] = rec17;
		m[2][3] = rec18;
		m[2][4] = rec19;
		m[2][6] = rec20;
		m[2][5] = rec21;
		
		
		
		
		

		if(ChainManagerController.floorNum==1)
		{
			mat = ps.mat1; 
			floorNumLbl.setText("1");
		}
		if(ChainManagerController.floorNum==2)
		{
			mat = ps.mat2; 
			floorNumLbl.setText("2");
		}
		if(ChainManagerController.floorNum==3)
		{
			mat = ps.mat3; 
			floorNumLbl.setText("3");
		}
		
		columns = ps.column_num;
		
		for(int i=0; i<mat.length; i++) 
		{
			for(int j=0; j<mat[i].length; j++)
			{
				if(mat[i][j]=='A')
					m[i][j].setFill(Color.GREEN);
				if(mat[i][j]=='B')
					m[i][j].setFill(Color.RED);
				if(mat[i][j]=='P')
					m[i][j].setFill(Color.AQUA);
			}
		}
		
		savedParksLbl.setText(Integer.toString(ps.savedParks));

		
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
