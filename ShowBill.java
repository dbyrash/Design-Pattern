package application;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


//view for mvc
//observer class for observer class
public class ShowBill implements Observer{

	public void bill(Stage stage, String text, int sensor, int fire) throws ClassNotFoundException, SQLException, IOException {
		
		FileInputStream input = new FileInputStream("logo.png");
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
        border.setStyle("-fx-background-color: #FFFFFF;");
		
		Random rand = new Random();
		int num = rand.nextInt(9000000) + 1000000;
		
		Text head1 = new Text("Billing Details");
		head1.setFont(Font.font ("Calibri", 40));
		head1.setFill(Color.FIREBRICK);
		
		Text serviceId = new Text("Sevice ID:");
		serviceId.setFont(Font.font ("Calibri", 20));
		serviceId.setFill(Color.FIREBRICK);
		
		Text service = new Text(Integer.toString(num));
		service.setFont(Font.font ("Calibri", 20));
		service.setFill(Color.BLACK);
		
		Text name = new Text("Name:");
		name.setFont(Font.font ("Calibri", 20));
		name.setFill(Color.FIREBRICK);
		
		Text address = new Text("Address:");
		address.setFont(Font.font ("Calibri", 20));
		address.setFill(Color.FIREBRICK);
		
		Text contact = new Text("Contact Number:");
		contact.setFont(Font.font ("Calibri", 20));
		contact.setFill(Color.FIREBRICK);
		
		Text er1 = new Text("Emergency Contact1:");
		er1.setFont(Font.font ("Calibri", 20));
		er1.setFill(Color.FIREBRICK);
		
		Text er2 = new Text("Emergency Contact2:");
		er2.setFont(Font.font ("Calibri", 20));
		er2.setFill(Color.FIREBRICK);
		
		Text email = new Text("Email:");
		email.setFont(Font.font ("Calibri", 20));
		email.setFill(Color.FIREBRICK);
		
		Text nameText = new Text();
		nameText.setFont(Font.font ("Calibri", 20));
		nameText.setFill(Color.BLACK);
		
		Text contactText = new Text();
		contactText.setFont(Font.font ("Calibri", 20));
		contactText.setFill(Color.BLACK);
		
		Text er1Text = new Text();
		er1Text.setFont(Font.font ("Calibri", 20));
		er1Text.setFill(Color.BLACK);
		
		Text er2Text = new Text();
		er2Text.setFont(Font.font ("Calibri", 20));
		er2Text.setFill(Color.BLACK);
		
		Text add = new Text("Domicilio Apartments");
		add.setFont(Font.font ("Calibri", 20));
		add.setFill(Color.BLACK);
		
		Text emailText = new Text(text);
		emailText.setFont(Font.font ("Calibri", 20));
		emailText.setFill(Color.BLACK);
		
		Text head2 = new Text("Fire Alarm Details");
		head2.setFont(Font.font ("Calibri", 40));
		head2.setFill(Color.FIREBRICK);
		
		Text head3 = new Text("Motion Sensor Details");
		head3.setFont(Font.font ("Calibri", 40));
		head3.setFill(Color.FIREBRICK);
		
		Text noOfSensors = new Text(Integer.toString(sensor));
		noOfSensors.setFont(Font.font ("Calibri", 20));
		noOfSensors.setFill(Color.BLACK);
		Text noOfFire = new Text(Integer.toString(fire));
		noOfFire.setFont(Font.font ("Calibri", 20));
		noOfFire.setFill(Color.BLACK);
		Text sensors = new Text("Number of Break-In Alarms:");
		sensors.setFont(Font.font ("Calibri", 20));
		sensors.setFill(Color.FIREBRICK);
		Text fires = new Text("Number of Fire Alarms:");
		fires.setFont(Font.font ("Calibri", 20));
		fires.setFill(Color.FIREBRICK);
		
		Class.forName("com.mysql.cj.jdbc.Driver");
  		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/USER?verifyServerCertificate=false&useSSL=true","root","root");
  	    ResultSet rs = null;
  	    PreparedStatement pst = null;
      	String sql = "select name, contact, emergency1, emergency2 from USERINFO where email = ?";
      	pst = conn.prepareStatement(sql);
        pst.setString(1, text);
        rs = pst.executeQuery();
		
        
		if(rs.next()) {
			nameText.setText(rs.getString("name"));
			contactText.setText(rs.getString("contact"));
			er1Text.setText(rs.getString("emergency1"));
			er2Text.setText(rs.getString("emergency2"));
		}
		VBox motion = new VBox();
		VBox fireSensor = new  VBox();
		
		FireFileObservable ff = new FireFileObservable();
		motion  = ff.searchSensor(motion);
		fireSensor = ff.searchFire(fireSensor);
		
		
		
        int costFire = 1000;
        int costMotion = 5000;
        //Bill For User Details and Total Cost
        Text cost = new Text("Total Cost:");
		cost.setFont(Font.font ("Calibri", FontWeight.BOLD, 40));
		cost.setFill(Color.FIREBRICK);
		Text totalCosts = new Text(Integer.toString(costFire*fire + costMotion*sensor));
		totalCosts.setFont(Font.font ("Calibri", FontWeight.BOLD, 40));
		totalCosts.setFill(Color.BLACK);
		
		VBox vBox0 = new VBox(10);
		vBox0.getChildren().addAll(serviceId, name, address, contact, er1, er2, email, cost);
		VBox vBox = new VBox(10);
		vBox.getChildren().addAll(service, nameText, add, contactText, er1Text, er2Text, emailText, totalCosts);
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.TOP_CENTER);
		pane.setVgap(15);
		pane.setHgap(50);
		pane.setMaxSize(600, 500);
		pane.add(head1, 0, 0);
		GridPane.setColumnSpan(head1, 2);
		GridPane.setHalignment(head1, HPos.CENTER);
		pane.add(vBox0, 0, 1);
		pane.add(vBox, 1, 1);
		pane.setStyle("-fx-background-color: #FFFFFF;");
		
		//Bill for Fire Alarm
		
		Text fireSelected = new Text("ID's of areas selected for Fire Alarm sensors:");
		fireSelected.setFont(Font.font ("Calibri", 20));
		fireSelected.setFill(Color.FIREBRICK);
		
		Text costOfEachFireAlarmText = new Text("Cost of each Fire Alarm: ");
		costOfEachFireAlarmText.setFont(Font.font ("Calibri", 20));
		costOfEachFireAlarmText.setFill(Color.FIREBRICK);
		
		Text costOfEachFireAlarm = new Text("$"+Integer.toString(costFire));
		costOfEachFireAlarm.setFont(Font.font ("Calibri", 20));
		costOfEachFireAlarm.setFill(Color.BLACK);
		
		Text totalCostFireText = new Text("Cost of Fire Alarms:");
		totalCostFireText.setFont(Font.font ("Calibri", FontWeight.BOLD, 20));
		
		totalCostFireText.setFill(Color.FIREBRICK);
		
		Text totalCostFire = new Text("$"+Integer.toString(costFire*fire));
		totalCostFire.setFont(Font.font ("Calibri",FontWeight.BOLD, 20));
		totalCostFire.setFill(Color.BLACK);
		
		HBox hb = new HBox(200);
		hb.getChildren().addAll(fires, noOfFire);
		HBox hb1 = new HBox();
		hb1.getChildren().addAll(fireSelected, fireSensor);
		HBox hb2 = new HBox(160);
		hb2.getChildren().addAll(costOfEachFireAlarmText, costOfEachFireAlarm);
		HBox hb3 = new HBox(200);
		hb3.getChildren().addAll(totalCostFireText, totalCostFire);
		hb3.setLayoutY(1000);
		
		VBox vBox1 = new VBox(40);
		vBox1.getChildren().addAll(hb, hb1, hb2, hb3);	
		GridPane pane1 = new GridPane();
		pane1.setAlignment(Pos.TOP_CENTER);
		pane1.setVgap(15);
		pane1.setHgap(30);
		pane1.setMaxSize(600, 500);
		pane1.add(head2, 0, 0);
		GridPane.setColumnSpan(head2, 2);
		GridPane.setHalignment(head2, HPos.CENTER);
		pane1.add(vBox1, 0, 1);
		//pane1.add(vBox2, 1, 1);
		pane1.setStyle("-fx-background-color: #FBBBB9;");
		
		
		//Bill For Break-In Alarm
		
		Text breakInSelected = new Text("ID's of areas selected for Break-In sensors:");
		breakInSelected.setFont(Font.font ("Calibri", 20));
		breakInSelected.setFill(Color.FIREBRICK);
		
		Text costOfEachMotionText = new Text("Cost of each Break-In Alarm: ");
		costOfEachMotionText.setFont(Font.font ("Calibri", 20));
		costOfEachFireAlarmText.setFill(Color.FIREBRICK);
		
		Text costOfEachMotionAlarm = new Text("$"+Integer.toString(costMotion));
		costOfEachMotionAlarm.setFont(Font.font ("Calibri", 20));
		costOfEachFireAlarm.setFill(Color.BLACK);
		
		Text totalCostMotionText = new Text("Cost of Break-In Alarms:");
		totalCostMotionText.setFont(Font.font ("Calibri", FontWeight.BOLD, 20));
		
		totalCostMotionText.setFill(Color.FIREBRICK);
		
		Text totalCostMotion = new Text("$"+Integer.toString(costMotion*sensor));
		totalCostMotion.setFont(Font.font ("Calibri",FontWeight.BOLD, 20));
		totalCostMotion.setFill(Color.BLACK);
		
		HBox hb4 = new HBox(200);
		hb4.getChildren().addAll(sensors, noOfSensors);
		HBox hb5 = new HBox(100);
		hb5.getChildren().addAll(breakInSelected, motion);
		HBox hb6 = new HBox(200);
		hb6.getChildren().addAll(costOfEachMotionText, costOfEachMotionAlarm);
		HBox hb7 = new HBox(250);
		hb7.getChildren().addAll(totalCostMotionText, totalCostMotion);
		
		VBox vBox3 = new VBox(30);
		vBox3.getChildren().addAll(hb4, hb5, hb6, hb7);	
		
		GridPane pane2 = new GridPane();
		pane2.setAlignment(Pos.TOP_CENTER);
		pane2.setVgap(15);
		pane2.setHgap(30);
		pane2.setMaxSize(600, 500);
		pane2.add(head3, 0, 0);
		GridPane.setColumnSpan(head3, 2);
		GridPane.setHalignment(head3, HPos.CENTER);
		pane2.add(vBox3, 0, 1);
		
		
		pane2.setStyle("-fx-background-color: #FBBBB9;");

		
		border.setLeft(pane1);
		border.setCenter(pane2);
		BorderPane.setAlignment(pane2, Pos.TOP_CENTER);
		border.setRight(pane);
	
	    Scene scene = new Scene(border);   
	      //Adding scene to the stage 
	      stage.setScene(scene); 
	         
	      //Displaying the contents of the stage 
	      stage.show(); 

	      	
	   		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
