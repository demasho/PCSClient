package application;


import java.net.URL;
import java.util.ResourceBundle;

import client.ClientConsole;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class KyoskerController {

	String disabledParkId,sizeParkId,savedParkId,enterParkId
	,colParkSize,floorNum,rowNum,columnNum,orderId1,orderId2,carId;
	private ClientConsole client = ClientConsole.getInstance();
	@FXML
	private Button parkSizeBtn;

	@FXML
	private Button disabledParksBtn;

	@FXML
	private TextField rowText;

	@FXML
	private TextField columnText;

	@FXML
	private Button entercarBtn;

	@FXML
	private TextField orderId1Text;

	@FXML
	private TextField orderId2Text;


	@FXML
	private TextField parkIdText1;

	@FXML
	private TextField colsizeText;

	@FXML
	private TextField parkIdText2;

	@FXML
	private TextField parkIdText3;

	@FXML
	private TextField parkIdText4;

	@FXML
	private TextField floorText;

	@FXML
	private Button saveParkBtn;

	@FXML
	private TextField caridText;


	@FXML
	void disabledParksClick(ActionEvent ae)
	{
		disabledParkId = parkIdText1.getText().trim();
		floorNum = floorText.getText().trim();
		rowNum = rowText.getText().trim() ;
		columnNum = columnText.getText().trim();
		if(!Validator.isNum(disabledParkId) || !Validator.isNum(floorNum)
				||!Validator.isNum(rowNum)||!Validator.isNum(columnNum) )
		{
			AlertBox.display("please enter a number ");
		}
		else{
			client.sendRequest("DISABLED_PLACES_SYSTEM : "+disabledParkId+" "
		+"("+rowNum+","+columnNum+","+floorNum+")");
			javafx.scene.control.Alert mylert = new Alert(Alert.AlertType.INFORMATION," Operation in Progress");
			mylert.setResizable(true);
			mylert.getDialogPane().setPrefSize(480, 170);
			mylert.show();
			while(client.Done==false)
			{
				if(client.Done==true)
					break;
			}
			mylert.setContentText(client.Result);
			mylert.show();

		}

	}
	@FXML
	void parkSizeClick(ActionEvent ae)
	{
		if(!Validator.isNum(parkIdText2.getText().trim()) ||
				!Validator.isNum(colsizeText.getText().trim()))
		{
			AlertBox.display("please enter a number ");
		}
		else
		{
			sizeParkId = parkIdText2.getText().trim();
			colParkSize = colsizeText.getText().trim();
			client.sendRequest("INIT_SIZE_OF_PARKING : "+sizeParkId+" "+colParkSize);
			javafx.scene.control.Alert mylert = new Alert(Alert.AlertType.INFORMATION," Operation in Progress");
			mylert.setResizable(true);
			mylert.getDialogPane().setPrefSize(480, 170);
			mylert.show();
			while(client.Done==false)
			{
				if(client.Done==true)
					break;
			}
			mylert.setContentText(client.Result);
			mylert.show();
		}
	}

	@FXML
	void enterParkClick(ActionEvent event) {

		if(!Validator.isNum(parkIdText3.getText().trim()) ||
				!Validator.isNum(orderId1Text.getText().trim()))
		{
			AlertBox.display("please enter a number ,"+parkIdText3.getText().trim()
					+","+orderId1Text.getText().trim());
		}
		else {
			enterParkId = parkIdText3.getText().trim();
			orderId1 =orderId1Text.getText().trim();
			carId = caridText.getText().trim();
			client.sendRequest("INSERT_CAR : "+enterParkId+" "+orderId1+" "+carId);
			javafx.scene.control.Alert mylert = new Alert(Alert.AlertType.INFORMATION," Operation in Progress");
			mylert.setResizable(true);
			mylert.getDialogPane().setPrefSize(480, 170);
			mylert.show();
			while(client.Done==false)
			{
				if(client.Done==true)
					break;
			}
			mylert.setContentText(client.Result);
			mylert.show();
		}		  
	}
	
	@FXML
	void saveParkClick(ActionEvent event)
	{
		if(!Validator.isNum(parkIdText4.getText().trim()) ||
				!Validator.isNum(orderId2Text.getText().trim()))
		{
			AlertBox.display("please enter a number ");
		}
		else {
			savedParkId = parkIdText4.getText().trim();
			orderId2 =orderId2Text.getText().trim();
			client.sendRequest("SAVING_PARKING_SPACE : "+savedParkId+" "+orderId2);
			javafx.scene.control.Alert mylert = new Alert(Alert.AlertType.INFORMATION," Operation in Progress");
			mylert.setResizable(true);
			mylert.getDialogPane().setPrefSize(480, 170);
			mylert.show();
			while(client.Done==false)
			{
				if(client.Done==true)
					break;
			}
			mylert.setContentText(client.Result);
			mylert.show();
		}
	}
}



