package application;

import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;

import client.ClientConsole;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ServiceWorkerController {
	String ParkID;
	@FXML
    private TextField complaintIdText;

    @FXML
    private Button applyBtn;

    @FXML
    private TextField compensationText;
	@FXML
	private BorderPane mainB;

	String complaintId , compensationMoney;
	private ClientConsole client = ClientConsole.getInstance();
	@FXML
	private Button Viewcomp;

	@FXML
	private Text ViewComplaints;

	@FXML
	void applyAction(ActionEvent ae)
	{
		if(!Validator.isNum(complaintIdText.getText().trim()) || 
				!Validator.isNum( compensationText.getText().trim()))
		{
			AlertBox.display("Please Fill all Feilds ");
		}
		else
		{
			complaintId = complaintIdText.getText().trim();
			compensationMoney = compensationText.getText().trim();
			String sent = "HANDLE_COMPLAINT : "+complaintId+" "+compensationMoney ;
			client.sendRequest(sent);
			while(true)
			{
				System.out.println("while");
				if(client.Done==true)
					break;
			}	
			AlertBox.display(client.Result);
			client.Done=false;
		}	


	}
	@FXML
	void ViewAllComplaints(ActionEvent event) {
		String Get = "GET_ALL_COMPLAINT : "+ client.ParkingID ;
		client.sendRequest(Get);
		int hah=0;
		while(true)
		{
			System.out.println("while");
			if(client.Done==true)
				break;
		}
		System.out.println(client.Result);
		if(client.Result.contains("Failed to get")== false && client.Result.contains("There is no complaint")==false) {
			String res=client.Result.replace('|', '\n');
			ViewComplaints.setText(res);	
		}else {
			AlertBox.display(client.Result);
		}
		client.Done=false;
	}	

}
