package application;


import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class AlertBox {


	public static void display(String title,String header,String message)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(message);
		alert.showAndWait();   		  
	}

	public static void display(String message)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(message);
		alert.showAndWait();   		  
	}

}
