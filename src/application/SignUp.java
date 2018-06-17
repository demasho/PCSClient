package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class SignUp extends Application {
	String firstName, lastName , email , position , organization , signUpString ,workerId ,password;
	
	public String getData()
	 {
		 return signUpString;
	 }
	@Override
	public void start(Stage primaryStage) {
		
		
		
		primaryStage.setTitle("יצירת משתמש חדש");
		 GridPane grid = new GridPane();
		 grid.setStyle("-fx-background-color: #336DFF;");
		 grid.setAlignment(Pos.CENTER);
		 grid.setHgap(10);
		 grid.setVgap(10);
		 grid.setPadding(new Insets(25, 25, 25, 25));
		 
		 Text scenetitle = new Text("רישום");
		 scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		 grid.add(scenetitle, 0, 0, 2, 1);
		

		 /************ first name ***************/
		 Label fNamelbl = new Label("שם פרטי:");
		 grid.add(fNamelbl, 1, 1);

		 TextField fNameTextField = new TextField();
		 grid.add(fNameTextField, 0, 1);
		 
		 /************ last name ***************/
		 Label lNamelbl = new Label("שם משפחה:");
		 grid.add(lNamelbl, 1, 2);
		
		 TextField lNameTextField = new TextField();
		 grid.add(lNameTextField, 0, 2);
		
		 /************ email ***************/
		 Label emailLbl = new Label("דואר אלקטרוני:");
		 grid.add(emailLbl, 1, 3);

		 TextField emailTextField = new TextField();
		 grid.add(emailTextField, 0, 3);
		 
		 /************ תפקיד ***************/
		 Label positionLbl = new Label("תפקיד:");
		 grid.add(positionLbl, 1, 4);
		 TextField positionTextField = new TextField();
		 grid.add(positionTextField, 0, 4);
		 
		 /************  השתייכות ארגונית ***************/
		 Label organizationLbl = new Label("השתייכות ארגונית:");
		 grid.add(organizationLbl, 1, 5);
		 TextField organizationTextField = new TextField();
		 grid.add(organizationTextField, 0, 5);
		 
		 
		 /************  סיסמא ***************/
		 Label passwordLbl= new Label("סיסמא:");
		 grid.add(passwordLbl, 1, 6);
		 PasswordField pwBox = new PasswordField();
		 grid.add(pwBox, 0, 6);
		 
		 /************  worker id ***************/
		 Label idLbl= new Label("מספר עובד:");
		 grid.add(idLbl, 1, 7);
		 TextField idTextField = new TextField();
		 grid.add(idTextField, 0, 7);
		 
		

		 
		 
		 Button signInBtn = new Button("התחבר");
		 HBox hbBtn = new HBox(10);
		 hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		 hbBtn.getChildren().add(signInBtn);
		 grid.add(hbBtn, 1, 8);
		 
		 final Text actiontarget = new Text();
	        grid.add(actiontarget, 1, 10);
	        
	        signInBtn.setOnAction(new EventHandler<ActionEvent>() {
	        	 
	            @Override
	            public void handle(ActionEvent e) {
	                actiontarget.setFill(Color.FIREBRICK);
	                actiontarget.setText("Signing up.. ");
	                
	               
		           	 	
	                
	                firstName = fNameTextField.getText();
	                lastName = lNameTextField.getText();
	                email  = emailTextField.getText();
	                position = positionTextField.getText();
	                organization = organizationTextField.getText();
	                workerId = idTextField.getText();
	                password = pwBox.getText();
	                
	                if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() ||
	                		position.isEmpty() || organization.isEmpty() || workerId.isEmpty()|| password.isEmpty())
	                {
	                	 actiontarget.setText("please fill all fields.. ");
	                	 signUpString = "missing data";
	                }
	                
	                else 
	                {
	                	signUpString = "signup:" + firstName + " " + lastName + " " + email+ " " + position +
	                			" " + organization + " " + workerId + " " + password;
	                }
	                
	                System.out.println(signUpString);
	                
	            }
	        });


	    
		 Scene scene = new Scene(grid, 300, 400);
		 primaryStage.setScene(scene);
	        primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
