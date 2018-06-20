package application;

import java.io.IOException;

import client.ChatClient;
import client.ChatIF;
import client.ClientConsole;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PayController {


	@FXML
	private TextField order_id_text;
	@FXML
	private TextField creditnumber;
	@FXML
	private Button next_order_button;

	@FXML
	private Button back_order_button;

	@FXML
	private Text loading_text;

	@FXML
	private Button payButton;

	@FXML
	private Label payment;

	private ClientConsole client = ClientConsole.getInstance();

	private String order;
	@FXML
	void getPayment(ActionEvent event) {
		StringBuilder sent=new StringBuilder();
		order=order_id_text.getText().trim();
		sent.append("GET_PAYMENT : ");
		sent.append(order);
		client.sendRequest(sent.toString());
		javafx.scene.control.Alert mylert = new Alert(Alert.AlertType.INFORMATION," Operation in Progress");
		mylert.getButtonTypes().clear();
		mylert.setResizable(true);
		mylert.getDialogPane().setPrefSize(480, 170);
		mylert.show();		
		while(client.Done==false)
		{
			if(client.Done==true)
				break;
		}
		client.Done=false;
		if(client.Result.contains("failed"))
		{
			mylert.getButtonTypes().add(ButtonType.OK);
			mylert.setContentText(client.Result);
			mylert.show();
		}else {
			mylert.getButtonTypes().add(ButtonType.OK);
			mylert.setContentText("got Payment");
			mylert.show();
			payButton.setDisable(false);
			payButton.setVisible(true);
			payment.setVisible(true);
			payment.setText(client.Result);
		}
	}


	@FXML
	void pay(ActionEvent event) {
		StringBuilder sent=new StringBuilder();
		javafx.scene.control.Alert mylert = new Alert(Alert.AlertType.INFORMATION," Operation in Progress");
		if(creditnumber.getText().isEmpty()==false&& creditnumber.getText().length()> 10 && Validator.isNum(creditnumber.getText())==true) {
			sent.append("PAY_ANDOUT : ");
			sent.append(order);
			client.sendRequest(sent.toString());
			mylert.setResizable(true);
			mylert.getDialogPane().setPrefSize(480, 170);
			mylert.show();
			while(client.Done==false)
			{
				if(client.Done==true)
					break;
			}
			client.Done=false;
			mylert.close();
			mylert.setContentText(client.Result);
			mylert.show();
		}
		else {
			mylert.setContentText("your credit card number WRONG!");
			mylert.show();
		}
	}

	@FXML
	void NextOrderAction(ActionEvent event) {
		//    	client.handleMessageFromClientUI(sent.toString());
		//    	client.handleMessageFromServer(msg);
		// server answer
		//loading_text.setVisible(false);

	}

	@FXML
	void back_order_action(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CustomerScene.fxml"));
		GridPane root1 = fxmlLoader.load();
		Stage stage = new Stage();
		stage.setScene(new Scene(root1));  
		stage.show();
		stage.setOnCloseRequest(e -> Platform.exit());
	}

}

