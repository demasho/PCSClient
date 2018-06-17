package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CancelOrderController {

    @FXML
    private Button cancelButton;

    @FXML
    void CancelButtonAction(ActionEvent event) {
    	AlertBox.display("Loading", "Loading .....", "Please Wait");
    }

}
