package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

//Real Subject for Proxy Pattern
public class RegistrationForm{
	Stage window;
	ListView<String> plantList;
	private final String EMAIL_PATTERN = 
			"^[A-Za-z0-9+_.-]+@(.+)$";
	private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
	private Matcher matcher;
	
	public void display(Stage stage, String text) throws FileNotFoundException{
		window = stage;
		
		FileInputStream input = new FileInputStream("logo.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);

	    //setting the fit height and width of the image view 
	    imageView.setFitHeight(800); 
	    imageView.setFitWidth(800); 
	    //Setting the preserve ratio of the image view 
	    imageView.setPreserveRatio(true); 
	      		
	    BorderPane border = new BorderPane();
        border.setTop(imageView);
        BorderPane.setAlignment(imageView, Pos.TOP_CENTER);
        BorderPane.setMargin(imageView, new Insets(10, 10, 10, 10));
        
		//Label for name 
        Text nameLabel = new Text("Name"); 
        nameLabel.setFont(Font.font ("Calibri", 30));
        nameLabel.setFill(Color.FIREBRICK);
   
        //Text field for name 
        TextField nameText = new TextField(); 
        nameText.setPrefSize(250, 40);
         
        //Label for email
        Text emailLabel = new Text("Email"); 
        emailLabel.setFont(Font.font ("Calibri", 30));
        emailLabel.setFill(Color.FIREBRICK);
        
        //Text field for email
        TextField emailText = new TextField(); 
        emailText.setPrefSize(250, 40);
        
        //Label for name 
        Text passwordLabel = new Text("Password"); 
        passwordLabel.setFont(Font.font ("Calibri", 30));
        passwordLabel.setFill(Color.FIREBRICK);
        
        //Text field for password 
        PasswordField passwordText = new PasswordField();
        passwordText.setPrefSize(250, 40);
        
      //Label for contact 
        Text contact = new Text("Phone Number"); 
        contact.setFont(Font.font ("Calibri", 30));
        contact.setFill(Color.FIREBRICK);
        
      //Label for name 
        Text ec1 = new Text("Emergency Contact 1"); 
        ec1.setFont(Font.font ("Calibri", 30));
        ec1.setFill(Color.FIREBRICK);
        
      //Label for name 
        Text ec2 = new Text("Emergency Contact 2"); 
        ec2.setFont(Font.font ("Calibri", 30));
        ec2.setFill(Color.FIREBRICK);
        
      //Text field for contact
        TextField pn = new TextField(); 
        pn.setPrefSize(250, 40);
        
      //Text field for emergency contact 1
        TextField emergency1 = new TextField(); 
        emergency1.setPrefSize(250, 40);
        
      //Text field for emergency contact 2
        TextField emergency2 = new TextField(); 
        emergency2.setPrefSize(250, 40);
        
        //Button for register 
        Button buttonRegister = new Button("Register");  
        buttonRegister.setStyle("-fx-background-radius: 10, 10, 10, 10; -fx-background-color: #FDEEF4;");
        buttonRegister.setPrefSize(100, 50);
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(20);
        grid.setHgap(10);
        grid.setMaxHeight(500);
        grid.setMaxWidth(700);
        grid.setAlignment(Pos.CENTER);

       
        //root.setAlignment(Pos.TOP_CENTER); 
        Text head = new Text("Registration Form");
        grid.add(head, 0, 0);
        GridPane.setColumnSpan(head, 2);
        GridPane.setHalignment(head, HPos.CENTER);
        head.setFont(Font.font ("Calibri", FontWeight.BOLD, 40));
        head.setFill(Color.FIREBRICK);
        
        
        border.setCenter(grid);
    	
         
        //Arranging all the nodes in the grid 
        grid.add(nameLabel, 0, 1); 
        grid.add(nameText, 1, 1); 
        grid.add(emailLabel, 0, 2);       
        grid.add(emailText, 1, 2); 
        grid.add(passwordLabel, 0, 3);       
        grid.add(passwordText, 1, 3); 
        grid.add(contact, 0, 4);       
        grid.add(pn, 1, 4);
        grid.add(ec1, 0, 5);       
        grid.add(emergency1, 1, 5);
        grid.add(ec2, 0, 6);       
        grid.add(emergency2, 1, 6);
        grid.add(buttonRegister, 1, 7); 
        
      
 
         
        buttonRegister.setOnAction(new EventHandler<ActionEvent>() {
      	    @Override
      	    public void handle(ActionEvent event) {
      	    	try{
      	    		Class.forName("com.mysql.cj.jdbc.Driver");
      	    		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/USER?verifyServerCertificate=false&useSSL=true","root","root");
      	    	    PreparedStatement Pstatement=connection.prepareStatement("insert into USERINFO values(?,?,?,?,?,?)");
      	    	    //Specifying the values of it's parameter
      	    	    Pstatement.setString(1,nameText.getText());
                  	Pstatement.setString(2,emailText.getText());
                  	Pstatement.setString(3,passwordText.getText());
                  	Pstatement.setString(4,pn.getText());
                  	Pstatement.setString(5,emergency1.getText());
                  	Pstatement.setString(6,emergency2.getText());
                  	Pstatement.executeUpdate();
                  	
                  	 PreparedStatement st = connection.prepareStatement("select * from USERINFO order by email desc");
                     ResultSet r1 = st.executeQuery();
                     String emailId = emailText.getText();
                      if(r1.next()) 
                      {
           
                        if(emailId.equalsIgnoreCase(r1.getString("email"))) 
                        {
                        	showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), 
                      	            "Form Error!",ButtonType.OK, "Email Address already exists.");
                      	            return;
                        }
                      }
                  	
                  	if(nameText.getText().isEmpty()) {
          	            showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), 
          	            "Form Error!",ButtonType.OK, "Please enter your name");
          	            return;
          	        }
          	        if(emailText.getText().isEmpty()) {
          	            showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), 
          	            "Form Error!",ButtonType.OK, "Please enter your email id");
          	            return;
          	        }
          	        if(passwordText.getText().isEmpty()) {
          	            showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), 
          	            "Form Error!", ButtonType.OK,"Please enter a password");
          	            return;
          	        }
          	      if(pn.getText().isEmpty()) {
        	            showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), 
        	            "Form Error!", ButtonType.OK,"Please enter your Contact Number");
        	            return;
        	        }
          	    if(emergency1.getText().isEmpty()) {
      	            showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), 
      	            "Form Error!", ButtonType.OK,"Please enter emergency contact");
      	            return;
      	        }
          	  if(emergency2.getText().isEmpty()) {
    	            showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), 
    	            "Form Error!", ButtonType.OK,"Please enter one  more emergency contact");
    	            return;
    	        }
          	if(pn.getText().length()!=10) {
	            showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), 
	            "Form Error!", ButtonType.OK,"Please enter valid Contact Number");
	            return;
	        }
  	    if(emergency1.getText().length()!=10) {
	            showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), 
	            "Form Error!", ButtonType.OK,"Please enter valid emergency contact");
	            return;
	        }
  	  if(emergency2.getText().length()!=10) {
            showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), 
            "Form Error!", ButtonType.OK,"Please enter valid emergency contact 2");
            return;
        }
          	        if(validate(emailText.getText()) == false) {
          	     
          	        	showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), 
          	    	            "Form Error!",ButtonType.OK, "Please enter valid Email Address");
          	    	            return;
          	        }
          	        if(passwordText.getText().length()<6) {
          	        	showAlert(Alert.AlertType.ERROR, grid.getScene().getWindow(), 
          	    	            "Form Error!", ButtonType.OK,"Your password should be atleast 6 characters long");
          	    	            return;
          	        }
          	        
          	      showAlert(Alert.AlertType.INFORMATION, grid.getScene().getWindow(), 
		          	        " ",ButtonType.OK, "Registration Successful!");
          	      	SceneFactory fireFactory = new FireAlarmFactory();
	            	fireFactory.createBuildingScene(window, text).showScene();
          	      showAlert(Alert.AlertType.INFORMATION, grid.getScene().getWindow(),"",ButtonType.OK, 
		          	        "Please Select Fire Sensor Alarms ");
          	        
                        
      	          connection.close();

        	}catch(Exception e){ System.out.println(e);}
        }});
        
              
         
        //Creating a scene object 
        Scene scene = new Scene(border, 1000, 400);
        border.setStyle("-fx-background-color: #FFFFFF;");
        grid.setStyle("-fx-background-color:#FBBBB9;");
        window.setScene(scene);
        window.show();
		
	}
	
	private void showAlert(Alert.AlertType alertType, Window owner, String title , ButtonType button, String message) {
	
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.showAndWait();

    }
    
    public boolean validate(final String email) {
 	   
 		matcher = pattern.matcher(email);
 		return matcher.matches();

    }

}
