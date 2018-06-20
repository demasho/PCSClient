package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class ServiceWorkerController  {

	@FXML
	TextField complaintIdText;
	@FXML
	TextField compensationText;
	
	String complaintId , compensationMoney;
	
	@FXML
	void applyAction(ActionEvent ae)
	{
		if(!Validator.isNum(complaintIdText.getText().trim()) || 
				!Validator.isNum( compensationText.getText().trim()))
		{
			AlertBox.display("please enter a number ");
		}
		else
		{
			complaintId = complaintIdText.getText().trim();
			compensationMoney = compensationText.getText().trim();
		}
		
		
		
	}
	
	

}
