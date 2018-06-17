package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PriceTable extends Application {
	 private TableView table = new TableView();
	 final static ObservableList<PriceTableObject> data = FXCollections.observableArrayList(
			    new PriceTableObject("5 ₪ לשעה", "לפי שעות", "חניה מזדמנת"),
			    new PriceTableObject("4 ₪ לשעה", "לפי שעות", "חניה חד-פעמית מוזמנת"),
			    new PriceTableObject(" 72 שעות של חניה חד-פעמית מוזמנת\r\n" 
			    		, " מחיר קבוע", "מנוי חודשי מלא")
			    
			);
	 
	
	@Override
	public void start(Stage primaryStage) {
		Scene scene = new Scene(new Group());
		primaryStage.setTitle("תמחור");
		primaryStage.setWidth(500);
		primaryStage.setHeight(500);
 
        final Label label = new Label("מחירים");
        label.setFont(new Font("Arial", 20));
        label.setAlignment(Pos.TOP_RIGHT);
 
        table.setEditable(true);
 
        TableColumn valueCol = new TableColumn("ערך\\הערות");
        TableColumn payMethodCol = new TableColumn("אופן תשלום");
        TableColumn parkTypeCol = new TableColumn("סוג חניה");
        
        valueCol.setCellValueFactory(
        	    new PropertyValueFactory<PriceTableObject,String>("value")
        	);
        payMethodCol.setCellValueFactory(
        	    new PropertyValueFactory<PriceTableObject,String>("payMethod")
        	);
        parkTypeCol.setCellValueFactory(
        	    new PropertyValueFactory<PriceTableObject,String>("parkType")
        	);
        
        table.setItems(data);
        table.getColumns().addAll(valueCol, payMethodCol, parkTypeCol);
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPrefWidth(500);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        primaryStage.setScene(scene);
        primaryStage.show();
		
	}
	
	 public static void addToTable(PriceTableObject obj)
	 {
		 data.add(obj);
		 
	 }
	 public static void addToTable(String val, String payMeth, String parkT )
	 {
		 data.add(new PriceTableObject(val,payMeth,parkT));
		 
	 }

	public static void main(String[] args) {
	//	addToTable("50","cash","mezdament");
		launch(args);
	}
}
