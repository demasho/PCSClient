package application;


import javafx.scene.control.TextField;
import client.ClientConsole;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class AdministratorController {

	@FXML
	private TextField parkingcasualorder;

	@FXML
	private TextField Rsubs;

	@FXML
	private TextField Bsubs;

	@FXML
	private TextField onetimeorder;

	@FXML
	private Button changePricesButton;

	private ClientConsole client = ClientConsole.getInstance();

	@FXML
	void changePricesAction(ActionEvent event) {
		StringBuilder sent = new StringBuilder();
		String bsubs = Bsubs.getText().trim();
		String rsubs = Rsubs.getText().trim();
		String oneorder = onetimeorder.getText().trim();
		String porder = parkingcasualorder.getText().trim();

		sent.append("UPDATING_PRICES : ");
		if(bsubs.isEmpty()==true || rsubs.isEmpty()==true || oneorder.isEmpty()==true || porder.isEmpty()==true) {
			AlertBox.display("missing data");
		}
		else {
			if(Validator.isNum(bsubs)==false || Validator.isNum(rsubs)==false || Validator.isNum(oneorder)==false || Validator.isNum(porder)==false) {
				AlertBox.display("you entered wrong data");
			}else {
				sent.append(oneorder+" ");
				sent.append(porder+" ");
				sent.append(rsubs+" ");
				sent.append(bsubs);
				client.sendRequest(sent.toString());
				AlertBox.display("Loading .. click OK plese");
				while(client.Done==false)
				{
					if(client.Done==true)
						break;
				}
				client.Done=false;				
				AlertBox.display(client.Result);
			}
		}
	}

	@FXML
	void OneParkingButtonClick(ActionEvent event) {

	}

}
