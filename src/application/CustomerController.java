package application;

import java.io.IOException;
import java.net.URL;

import com.sun.javafx.tk.Toolkit.Task;

import client.ChatClient;
import client.ClientConsole;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CustomerController {

    @FXML
    private GridPane gridPane;

    @FXML
    private Button orderButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button complaintButton;
    
    @FXML
    private Button payButton;
    
    @FXML
    private Button pricesButton;
    
    
    @FXML
    void CancelButtonClick(MouseEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CancelOrderScene.fxml"));
    	BorderPane root1 = fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setScene(new Scene(root1));  
    	stage.show();
    	stage.setOnCloseRequest(e -> Platform.exit());
    }

    @FXML
    void ComplaintButtonClick(MouseEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ComplaintScene.fxml"));
    	BorderPane root1 = fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setScene(new Scene(root1));  
    	stage.show();    	
    	stage.setOnCloseRequest(e -> Platform.exit());   
    }

    @FXML
    void OrderButtonClick(MouseEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("OrderParkScene.fxml"));
    	BorderPane root1 = fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setScene(new Scene(root1));  
    	stage.show();
    	stage.setOnCloseRequest(e -> Platform.exit()); 	
    }
    
    @FXML
    void PayButtonClick(MouseEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PayScene.fxml"));
    	BorderPane root1 = fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setScene(new Scene(root1));  
    	stage.show();
    	stage.setOnCloseRequest(e -> Platform.exit());
    }
    @FXML
    void ShowPricesClick(MouseEvent event) throws IOException{ 	
    	PriceTable prices = new PriceTable();
    	prices.start(new Stage());   	
    }

}
