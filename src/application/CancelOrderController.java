package application;

import client.ChatClient;
import client.ClientConsole;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CancelOrderController {

	@FXML
	private TextField order_id;
	@FXML
	private Button cancelButton;

	private ClientConsole client = ClientConsole.getInstance();

	@FXML
	void CancelButtonAction(ActionEvent event) {
		String order;
		StringBuilder sent = new StringBuilder();
		sent.append("CANCEL_RESERVATION : ");
		order=order_id.getText().trim();
		sent.append(order);
		client.sendRequest(sent.toString());
		AlertBox.display("Loading .. click OK plese");
		while(client.Done==false)
		{
			if(client.Done==true)
				break;
		}
		AlertBox.display(client.Result);
		client.Done=false;
	}
}
