package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class KyoskerController {

	String disabledParkId,sizeParkId,savedParkId,parkSize,parkPlace,orderId;
	@FXML
	TextField parkIdText1;
	@FXML
	TextField parkIdText2;
	@FXML
	TextField parkIdText3;
	@FXML
	TextField placeText;
	@FXML
	TextField sizeText;
	@FXML
	TextField orderIdText;
	
	
	@FXML
	void disabledParksClick(ActionEvent ae)
	{
		if(!Validator.isNum(parkIdText1.getText().trim()) )
		{
			AlertBox.display("please enter a number ");
		}
		else
			disabledParkId = parkIdText1.getText().trim();
		
		parkPlace = placeText.getText().trim();
		
	}
	@FXML
	void parkSizeClick(ActionEvent ae)
	{
		if(!Validator.isNum(parkIdText2.getText().trim()) ||
				!Validator.isNum(sizeText.getText().trim()))
		{
			AlertBox.display("please enter a number ");
		}
		else
		{
			sizeParkId = parkIdText2.getText().trim();
			parkSize = sizeText.getText().trim();
		}
		
	}
	@FXML
	void saveParkClick(ActionEvent ae)
	{
		if(!Validator.isNum(parkIdText3.getText().trim()) ||
				!Validator.isNum(orderIdText.getText().trim()))
		{
			AlertBox.display("please enter a number ");
		}
		else {
			savedParkId = parkIdText3.getText().trim();
			orderId =orderIdText.getText().trim();
		}
		
	}

}
