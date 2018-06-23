package application;

import client.ClientConsole;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;




public class PriceTable extends Application {
	private ClientConsole client = ClientConsole.getInstance();
	String res;
	// GET_UPDATED_PRICES
	boolean priceUpdated;
	
	 private TableView table = new TableView();
	 final static ObservableList<PriceTableObject> data = FXCollections.observableArrayList(
			    new PriceTableObject("5", "לפי שעות", "חניה מזדמנת"),
			    new PriceTableObject("4", "לפי שעות", "חניה חד-פעמית מוזמנת"),
			    new PriceTableObject("72" , " מחיר קבוע", "מנוי חודשי מלא"),
			    new PriceTableObject("100" , " מחיר קבוע", "מנוי עסקי")
			    
			);
	 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void start(Stage primaryStage) {
		/**** if prices are updated ***********/
		client.sendRequest("GET_UPDATED_PRICES :");
		while(true)
		{
			System.out.println("while");
			if(client.Done==true)
				break;
		}
		String[] parts = null  ;
		if(client.Result.contains("New Prices"))
		{
			System.out.println("PRICE TABLE:contains new prices");
			parts=client.Result.split(" ");
			priceUpdated = true;
		}
		else
		{
			 	System.out.println("PRICE TABLE:does not contain new prices");
				priceUpdated = false;
		}
		
		client.Done=false;
		
		System.out.println("client REsUUlt");
		System.out.println(client.Result);
		System.out.println(priceUpdated);
		
		if(priceUpdated)
		{
			
			data.clear();
			
		}
		Scene scene = new Scene(new Group());
		primaryStage.setTitle("תמחור");
		primaryStage.setWidth(500);
		primaryStage.setHeight(500);
 
        final Label label = new Label("מחירים");
        label.setFont(new Font("Arial", 20));
        label.setAlignment(Pos.TOP_RIGHT);
        
        table.setEditable(true);
 
        if(FirstWindow.isCustomer())
        {
        	 table.setEditable(false);
        }
       
 
        TableColumn valueCol = new TableColumn("ערך");
        TableColumn payMethodCol = new TableColumn("אופן תשלום");
        TableColumn parkTypeCol = new TableColumn("סוג חניה");
        
        Callback<TableColumn, TableCell> cellFactory =
                new Callback<TableColumn, TableCell>() {
                    public TableCell call(TableColumn p) {
                       return new EditingCell();
                    }
                };
       
        
        	valueCol.setCellValueFactory(
            	    new PropertyValueFactory<PriceTableObject,String>("value")
            	);
           
        
        
        
        valueCol.setCellFactory(cellFactory);
        
      
        valueCol.setOnEditCommit(new EventHandler<CellEditEvent<PriceTableObject, String>>() {

			@Override
			public void handle(CellEditEvent<PriceTableObject, String> t) {
				((PriceTableObject) t.getTableView().getItems().get(
		                t.getTablePosition().getRow())
		                ).setValue(t.getNewValue());
				
			}

			
		});
        payMethodCol.setCellValueFactory(
        	    new PropertyValueFactory<PriceTableObject,String>("payMethod")
        	);
        payMethodCol.setCellFactory(cellFactory);
        payMethodCol.setOnEditCommit(new EventHandler<CellEditEvent<PriceTableObject, String>>() {

			@Override
			public void handle(CellEditEvent<PriceTableObject, String> t) {
				((PriceTableObject) t.getTableView().getItems().get(
		                t.getTablePosition().getRow())
		                ).setPayMethod(t.getNewValue());
				
			}

			
		});
        parkTypeCol.setCellValueFactory(
        	    new PropertyValueFactory<PriceTableObject,String>("parkType")
        	);
        parkTypeCol.setCellFactory(cellFactory);
        parkTypeCol.setOnEditCommit(new EventHandler<CellEditEvent<PriceTableObject, String>>() {

			@Override
			public void handle(CellEditEvent<PriceTableObject, String> t) {
				((PriceTableObject) t.getTableView().getItems().get(
		                t.getTablePosition().getRow())
		                ).setParkType(t.getNewValue());
				
			}

			
		});
        
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
