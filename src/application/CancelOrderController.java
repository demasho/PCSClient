package application;

import client.ChatClient;
import client.ClientConsole;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CancelOrderController {

	@FXML
	private TextField order_id;


	@FXML
	private Button cancelButton;

	private ClientConsole console = ClientConsole.getInstance();
	private ChatClient client=console.getClient();

	@FXML
	void CancelButtonAction(ActionEvent event) {
		String order;
		StringBuilder sent = new StringBuilder();
		sent.append("CANCEL_RESERVATION : ");
		order=order_id.getText().trim();
		sent.append(order);
		AlertBox.display("ביטול חניה", "נא לחכות", "העניין בטיפול");
		client.handleMessageFromClientUI(sent.toString());
		AlertBox.display("ביטול חניה", "הביטול התבצע בהצלחה", "תודה ולהתראות");

	}

}
