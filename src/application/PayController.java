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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PayController {

  
    @FXML
    private TextField order_id_text;

    @FXML
    private Button next_order_button;

    @FXML
    private Button back_order_button;

    @FXML
    private Text loading_text;

    @FXML
    private Button payButton;
    
	private ClientConsole console = ClientConsole.getInstance();
	private ChatClient client=console.getClient();


    @FXML
    void NextOrderAction(ActionEvent event) {
    	loading_text.setVisible(true);
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

