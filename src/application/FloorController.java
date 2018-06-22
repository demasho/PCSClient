package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class FloorController implements Initializable {
	
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
	
	Rectangle  m[][];
	
	ParkStateController ps;
	
	int columns;
	
	public FloorController()
	{
		ps = new ParkStateController();
		ps.createPark(ChainManagerController.parkAssignment);
		columns  = ps.column_num;
		System.out.println("floor1 c'tor");
		 m = new Rectangle[3][columns] ;
		 /*
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
			*/
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		/*
		System.out.println("floor1 init");
		
		for(int i=0; i<m.length; i++) 
		{
			for(int j=0; j<m[i].length; j++)
			{
				m[i][j];
			}
		}
		*/
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
	        
		
	//	setdisabledPark(1, 1);

		
	}
	
	public void setdisabledPark(int x , int y)
	{
		mat[x][y] = 'B';
	}
	
	public void setAvailable(int x , int y)
	{
		mat[x][y] = 'A';
	}
	
	public void setParkedplace(int x , int y)
	{
		mat[x][y] = 'P';
	}

}
