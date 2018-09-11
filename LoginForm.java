package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.Window;

//Proxy for Proxy pattern
//Single Access Point Pattern
public class LoginForm implements EntrySubject{
	Stage window;
	
	public void display(Stage stage, String a) throws FileNotFoundException{
		window = stage;
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		window.setWidth(primaryScreenBounds.getWidth());
	    window.setHeight(primaryScreenBounds.getHeight());
	    
	    
	    
		//GridPane with 10px padding around edge
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(15);
        grid.setHgap(10);
        grid.setMaxHeight(500);
        grid.setMaxWidth(500);
     
      	FileInputStream input = new FileInputStream("Welcome logo.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
      	      
      	//setting the fit height and width of the image view 
      	imageView.setFitHeight(1000); 
      	imageView.setFitWidth(1000); 
      	      
      	//Setting the preserve ratio of the image view 
      	imageView.setPreserveRatio(true); 
        

        BorderPane border = new BorderPane();
        border.setTop(imageView);
        BorderPane.setAlignment(imageView, Pos.TOP_CENTER);
        BorderPane.setMargin(imageView, new Insets(10, 10, 10, 10));

        Text head = new Text("Login Form");
        grid.add(head, 0, 0);
        GridPane.setColumnSpan(head, 2);
        GridPane.setHalignment(head, HPos.CENTER);
        head.setFont(Font.font ("Calibri", FontWeight.BOLD, 40));
        head.setFill(Color.FIREBRICK);
        
        //Name Label - constrains use (child, column, row)
        Label nameLabel = new Label("Email Id");
        nameLabel.setFont(Font.font ("Calibri", 30));
        nameLabel.setTextFill(Color.FIREBRICK);

        grid.add(nameLabel, 0, 1);

        //Name Input
        TextField nameInput = new TextField();
        grid.add(nameInput, 1, 1);
        nameInput.setPrefSize(250, 40);

        //Password Label
        Label passLabel = new Label("Password");
        passLabel.setFont(Font.font ("Calibri", 30));
        passLabel.setTextFill(Color.FIREBRICK);
        PasswordField passInput = new PasswordField();
        grid.add(passLabel, 0, 2);

        //Password Input
  
        grid.add(passInput, 1, 2);
        passInput.setPrefSize(250, 40);

        //Login
        Button loginButton = new Button("Log In");
        loginButton.setPrefSize(100, 50);
    
        
        grid.add(loginButton, 1, 3);
        grid.setAlignment(Pos.CENTER);
        border.setCenter(grid);
        //Sign up
        Text newUser = new Text("New User?");
        grid.add(newUser, 0, 4);
        newUser.setFont(Font.font ("Calibri", 20));
        newUser.setFill(Color.FIREBRICK);
        Button signUpButton = new Button("Sign Up");
        signUpButton.setPrefSize(100, 50);
        loginButton.setStyle("-fx-background-radius: 10, 10, 10, 10; -fx-background-color: #FDEEF4;");
        signUpButton.setStyle("-fx-background-radius: 10, 10, 10, 10; -fx-background-color: #FDEEF4;");
  
        
        signUpButton.setOnAction(e->{
        	RegistrationForm rf = new RegistrationForm();
        	try {
				rf.display(window, nameInput.getText());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	
        });
        
        grid.add(signUpButton, 1, 4);
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
      	    @Override
      	    public void handle(ActionEvent event) {
      	    	try{
      	    		Class.forName("com.mysql.cj.jdbc.Driver");
      	    		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/USER?verifyServerCertificate=false&useSSL=true","root","root");
      	    	    ResultSet rs = null;
      	    	    PreparedStatement pst = null;
      	        	String sql = "select * from USERINFO where email = ? and password = ?";
      	        	pst = conn.prepareStatement(sql);
      	            pst.setString(1, nameInput.getText());
      	            pst.setString(2, passInput.getText());
      	            rs = pst.executeQuery();
      	            if (rs.next())
      	            {
      	            	SceneFactory fireFactory = new FireAlarmFactory();
      	            	fireFactory.createBuildingScene(window, nameInput.getText()).showScene();
      	            	showAlert(Alert.AlertType.INFORMATION, grid.getScene().getWindow(),"",ButtonType.OK, 
      	            	        "Please Select Fire Sensor Alarms ");
					           
      	            }
      	            else
      	            {
      	            	showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), 
					            "Form Error!", "Wrong UserName/Password");
      	            }
      	          conn.close();

        	}catch(Exception e){ System.out.println(e);}
        }});
        
        
        Scene scene = new Scene(border, 1000, 400);
        border.setStyle("-fx-background-color: #FFFFFF;");
        grid.setStyle("-fx-background-color:#FBBBB9;");
        window.setScene(scene);
        window.show();
		
	}
	private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
	
private void showAlert(Alert.AlertType alertType, Window owner, String title , ButtonType button, String message) {
		
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.showAndWait();

    }
	
}
