package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ChainManagerController implements Initializable {
	@FXML
	ChoiceBox cb;
	@FXML
	ChoiceBox cbFloor;
	@FXML
	Button okBtn;
	@FXML
	Button notOk;
	@FXML
	Label label;
	
	String selectedChoice ,selectedChoiceFloor ;
	boolean priceUpdated = false;
	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cb.setItems(FXCollections.observableArrayList(
			    "101", "102", 
			    "103", "104")
			);
		
		if(priceUpdated)
		{
			okBtn.setVisible(true);
			notOk.setVisible(true);
			label.setVisible(true);
		}
		
		cb.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
		      @Override
		      public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
		    	  selectedChoice = (String) (cb.getItems().get((Integer) number2));
		      }
		    });
		
	
		cbFloor.setItems(FXCollections.observableArrayList(
			    "1", "2", 
			    "3")
			);
		cbFloor.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
		      @Override
		      public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
		    	  selectedChoiceFloor = (String) (cbFloor.getItems().get((Integer) number2));
		      }
		    });

	}
	@FXML
	void viewParkClick(ActionEvent ae)
	{
		System.out.println(selectedChoice);
		System.out.println(selectedChoiceFloor);
		try {
			if(selectedChoiceFloor=="1")
				loadFloor1();
			if(selectedChoiceFloor=="2")
				loadFloor2();
			if(selectedChoiceFloor=="3")
				loadFloor3();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@FXML
	void OkAction(ActionEvent ae)
	{
		
	}
	@FXML
	void notOkAction(ActionEvent ae)
	{
		
	}
	
	void setUpdatedPrice()
	{
		priceUpdated = true;
	}
	
	
	public void loadFloor1() throws IOException
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Floor1Scene.fxml"));
		GridPane root1= fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setScene(new Scene(root1));  
    	stage.show();    	
    	stage.setOnCloseRequest(e -> Platform.exit());
	}

	public void loadFloor2() throws IOException
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Floor2Scene.fxml"));
		GridPane root1= fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setScene(new Scene(root1));  
    	stage.show();    	
    	stage.setOnCloseRequest(e -> Platform.exit());
	}

	public void loadFloor3() throws IOException
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Floor3Scene.fxml"));
		GridPane root1= fxmlLoader.load();
    	Stage stage = new Stage();
    	stage.setScene(new Scene(root1));  
    	stage.show();    	
    	stage.setOnCloseRequest(e -> Platform.exit());
	}
}
