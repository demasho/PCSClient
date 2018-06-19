package application;

import client.ChatClient;
import client.ClientConsole;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ComplaintController {

	@FXML
	private TextField person_id_text;

	@FXML
	private TextField order_id_text;

	@FXML
	private TextArea complaint_text;

	@FXML
	private Button complaintButton;

	@FXML
	void complaintButtonClick(MouseEvent event) {
		String person_id = null;
		String parking_id = null;
		String complaint;
		boolean flag=true;
		person_id_text.setStyle("-fx-text-inner-color: black;");
		order_id_text.setStyle("-fx-text-inner-color: black;");
		//////////
		try
		{
			person_id=person_id_text.getText().trim();
			if( Validator.isValidPersonId(person_id)==false )
				throw new Exception();
		}catch (Exception e) {
			person_id_text.setText("invalid input;");
			person_id_text.setStyle("-fx-text-inner-color: red;");
			flag=false;
		}

		try {
			parking_id=order_id_text.getText().trim();
			if( Validator.isValidRequestedPark(parking_id)==false)
				throw new Exception();
		}catch(Exception e){
			order_id_text.setText("invalid input");
			order_id_text.setStyle("-fx-text-inner-color: red;");
			flag=false;
		}

		complaint=complaint_text.getText().trim();

		if(flag==true) {
			StringBuilder sent=new StringBuilder();
			sent.append("SUBMISSION_COMPLAINT : ");
			sent.append(person_id);
			sent.append(" ");
			sent.append(parking_id);
			sent.append(" ");
			sent.append(complaint);
			ClientConsole client=ClientConsole.getInstance();
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
			mylert.getButtonTypes().add(ButtonType.OK);
			mylert.setContentText(client.Result);
			mylert.show();
		}
		else
			AlertBox.display("הגשת תלונה", "הנתונים שגויים", "נא לעדכן את הנתונים");
	}


}
