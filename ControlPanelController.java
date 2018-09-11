package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

//Client For Command Pattern
public class ControlPanelController{
	private int temperature = 100;
	private static BorderPane bp = new BorderPane();
	
	public void control(ListView<String> items, ListView<String> items1, VBox combo, VBox combo1, int fire, int sensor, Stage stage, String text, ObservableList<String> item, ObservableList<String> item1)  {
		
  	    //Specifying the values of it's parameter
  	    Text heading = new Text("CONTROL PANEL");
  	    heading.setFill(Color.CRIMSON);
  	    heading.setFont(Font.font("Calibri", FontWeight.BOLD, 80));
  	    bp.setTop(heading);
  	    BorderPane.setAlignment(heading, Pos.TOP_CENTER);
       
        bp.setStyle("-fx-background-color:#FFBF00");
  
        Text status = new Text("Please select status for each Sensor");
        status.setFill(Color.CRIMSON);
        status.setFont(Font.font("Calibri", 40));
        Text s = new Text("Selected Break-In sensor areas:");
        s.setFill(Color.WHITE);
        s.setFont(Font.font("Calibri", 20));
        Text f = new Text("Selected Fire Alarm areas:");
        f.setFill(Color.WHITE);
        f.setFont(Font.font("Calibri", 20));
        
        GridPane lists = new GridPane();
        lists.add(status, 0, 0);
        lists.add(s, 0, 1);
        lists.add(f, 0, 3);
        lists.add(items1, 0, 2);
        lists.add(items, 0, 4);
        lists.add(combo1, 1, 2);
        lists.add(combo, 1, 4);
        bp.setCenter(lists);
        BorderPane.setAlignment(lists, Pos.BOTTOM_CENTER);
        String[] keys =
        {
           
            "1", "2", "3",
            "4", "5", "6",
            "7", "8", "9",
            "*", "0", "#"
        };
        
        GridPane numPad = new GridPane();
        numPad.setAlignment(Pos.CENTER);

        for (int i = 0; i < 12; i++)
        {	
        	
            Button button = new Button(keys[i]);
            button.getStyleClass().add("num-button");
            numPad.add(button, i % 3, (int) Math.ceil(i / 3));
            button.setTextFill(Color.BLACK);
            button.setPrefSize(50, 70);
        }

        Button call = new Button("Call");
        call.setId("call-button");
        call.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        numPad.add(call, 0, 4);
        
        Button emergencyCall = new Button("EMERGENCY CALL");
        emergencyCall.setId("emergencyCall");
        emergencyCall.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        emergencyCall.setStyle("-fx-background-color:#ff0000");
        numPad.add(emergencyCall, 0, 5);
        
        Button people = new Button("PEOPLE");
        people.setId("people");
        people.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        people.setStyle("-fx-background-color:#EDEC8F");
        numPad.add(people, 0, 6);
       
        Button fireButton = new Button("FIRE ALARM SIMULATION");
        fireButton.setOnAction(e->{
        	
         	BreakInAlarm ba = new BreakInAlarm();
        	FireAlarm fa = new FireAlarm();
        	BreakInAlarmActivateCommand bac = new BreakInAlarmActivateCommand(ba);
        	BreakInAlarmDeactivateCommand bad = new BreakInAlarmDeactivateCommand(ba);
        	FireAlarmActivateCommand fac = new FireAlarmActivateCommand(fa);
        	FireAlarmDeactivateCommand fad = new FireAlarmDeactivateCommand(fa);
        	
        	int i=0, j=0;
            for(String each: item) {
           
            	ComboBox<String> co = (ComboBox<String>) combo.getChildren().get(i);
            	if(co.getValue().equalsIgnoreCase("Deactivate")) {
            		CommandInvoker cc = 	new CommandInvoker(fac, fad);
        			cc.setDeactivate(co.getValue(), each);
            	}
            	
            	else {
                		CommandInvoker cc = 	new CommandInvoker(fac, fad);
            			cc.setActive(co.getValue(), each);
                	}
            	i++;
            	}
            
            for(String each: item1) {
                
            	ComboBox<String> co = (ComboBox<String>) combo1.getChildren().get(j);
            	if(co.getValue().equalsIgnoreCase("Deactivate")) {
            		CommandInvoker cc = 	new CommandInvoker(bac, bad);
        			cc.setDeactivate(co.getValue(), each);
            	}
            	
            	else {
                		CommandInvoker cc = 	new CommandInvoker(bac, bad);
            			cc.setActive(co.getValue(), each);
                	}
            	i++;
            	}
            	
            	
        
            
        	if(temperature>90) {
        		SceneFactory fireFactory = new FireAlarmFactory();
            	fireFactory.createEmergencyScene(stage, text, items.getSelectionModel().getSelectedItem(), fire, sensor).showScene();
            	
        	}
        	
        });
        
        
        //Invokes Command Invoker
        Button motionButton = new Button("BREAK-IN ALARM SIMULATION");
        motionButton.setOnAction(e->{
           	BreakInAlarm ba = new BreakInAlarm();
        	FireAlarm fa = new FireAlarm();
        	BreakInAlarmActivateCommand bac = new BreakInAlarmActivateCommand(ba);
        	BreakInAlarmDeactivateCommand bad = new BreakInAlarmDeactivateCommand(ba);
        	FireAlarmActivateCommand fac = new FireAlarmActivateCommand(fa);
        	FireAlarmDeactivateCommand fad = new FireAlarmDeactivateCommand(fa);
        	
        	int i=0, j=0;
            for(String each: item) {
           
            	ComboBox<String> co = (ComboBox<String>) combo.getChildren().get(i);
            	if(co.getValue().equalsIgnoreCase("Deactivate")) {
            		CommandInvoker cc = 	new CommandInvoker(fac, fad);
        			cc.setDeactivate(co.getValue(), each);
            	}
            	
            	else {
                		CommandInvoker cc = 	new CommandInvoker(fac, fad);
            			cc.setActive(co.getValue(), each);
                	}
            	i++;
            	}
            
            for(String each: item1) {
                
            	ComboBox<String> co = (ComboBox<String>) combo1.getChildren().get(j);
            	if(co.getValue().equalsIgnoreCase("Deactivate")) {
            		CommandInvoker cc = 	new CommandInvoker(bac, bad);
        			cc.setDeactivate(co.getValue(), each);
            	}
            	
            	else {
                		CommandInvoker cc = 	new CommandInvoker(bac, bad);
            			cc.setActive(co.getValue(), each);
                	}
            	i++;
            	}
        	SceneFactory breakInFactory = new BreakInAlarmFactory();
        	breakInFactory.createEmergencyScene(stage, text, items1.getSelectionModel().getSelectedItem(), fire, sensor).showScene();
        });
        
        Button customerBill = new Button("BILL CHECK-OUT");
        customerBill.setMaxWidth(100);
        customerBill.setOnAction(e->{
        	ShowBill bill = new ShowBill();
        	try {
				bill.bill(stage, text, sensor, fire);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        });
        
        
        
        HBox buttons = new HBox(fireButton, motionButton, customerBill);
        bp.setBottom(buttons);
        GridPane.setColumnSpan(call, 4);
        GridPane.setHgrow(call, Priority.ALWAYS);
        GridPane.setHgrow(emergencyCall, Priority.ALWAYS);
        GridPane.setColumnSpan(emergencyCall, 4);
        GridPane.setHgrow(people, Priority.ALWAYS);
        GridPane.setColumnSpan(people, 4);
        
        bp.setRight(numPad);
        BorderPane.setAlignment(numPad, Pos.BOTTOM_RIGHT);
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		stage.setWidth(primaryScreenBounds.getWidth());
	    stage.setHeight(primaryScreenBounds.getHeight());
        Scene scene = new Scene(bp, 1450, 700);
        stage.setScene(scene);
        stage.show();
        
        
	}

	
}
	
	
	


	
	
