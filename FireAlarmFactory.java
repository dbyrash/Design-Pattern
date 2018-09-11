package application;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

//Concrete Factory for Abstract Factory Pattern
public class FireAlarmFactory implements SceneFactory {
	Stage window;
	Scene scene;
	Group root = new Group();	
	Canvas canvas = new Canvas(3000,3000);
	public int temperature = 90;
	private MediaPlayer mediaPlayer;
	
	Text emergencyCalling = new Text("EMERGENCY CALLING.... - 911");

	//Create Building Scene for Fire Alarm
	public BuildingProduct createBuildingScene(Stage primaryStage, String text2) {
	
			window = primaryStage;	
	    	scene = new Scene(root);
	        root.getChildren().add(canvas);
	        canvas.setStyle("-fx-background-color: #FFFFFF;");
	      	GraphicsContext gc = canvas.getGraphicsContext2D();   //gc is the object
	    	gc.setLineWidth(3.0);
	    	Text text = new Text(700, 80, "COMMUNITY LAYOUT");
	    	text.setFont(new Font("Georgia", 50));
	    	text.setFill(Color.SADDLEBROWN);
	    	
	    	
	    	Text text1 = new Text(650, 850, "Do you want to select the areas for Security Alarms?");
	    	text1.setFont(new Font("Georgia", 20));
	    	text1.setFill(Color.SADDLEBROWN);
	    	
	    	Button yes = new Button("Yes");
	    	yes.setLayoutX(1120);
	    	yes.setLayoutY(830);
	    	
	    	Button no = new Button("No");
	    	no.setLayoutX(1170);
	    	no.setLayoutY(830);
	    	
	    	
	    	//swimming pool
	    	gc.setFill(Color.BLACK);
	    	gc.fillText("SWIMMING POOL", 865, 330);
	    	gc.strokeLine(800, 100, 800, 300);
	    	gc.strokeLine(800, 300, 1050, 300);
	    	gc.strokeLine(1050, 100, 1050, 300);

	    	Ellipse ellipse = new Ellipse(); 
	    	ellipse.setCenterX(930);
	    	ellipse.setCenterY(200);
	    	ellipse.setRadiusX(100);
	    	ellipse.setRadiusY(50);
	    	ellipse.setFill(Color.CORNFLOWERBLUE);

	    	//building 1
	    	gc.setFill(Color.BLACK);
	    	gc.fillText(" BUILDING AREA-1",550,330);
	    	gc.setFill(Color.CADETBLUE);
	    	gc.fillRect(500, 150, 80, 150);
	    	gc.fillRect(630, 150, 80, 150);
	    	gc.strokeLine(530, 280, 530, 300);
	    	gc.strokeLine(555, 280, 555, 300);
	    	gc.strokeLine(530, 280, 555, 280);
	    	
	    	gc.strokeLine(660, 280, 660, 300);
	    	gc.strokeLine(685, 280, 685, 300);
	    	gc.strokeLine(660, 280, 685, 280);
	    	
	    	//APT-1
	    	gc.setFill(Color.SADDLEBROWN);
	    	gc.fillRect(515,180,18,20);
	    	gc.fillRect(550,180,18,20);
	    	CheckBox cb = new CheckBox();
	        cb.setTranslateX(585);
	        cb.setTranslateY(180);
	        cb.setId("BA-1 B1 F3");

	        
	    	gc.fillRect(515,215,18,20);
	    	gc.fillRect(550,215,18,20);
	    	CheckBox cb1 = new CheckBox();
	        cb1.setTranslateX(585);
	        cb1.setTranslateY(215);
	        cb1.setId("BA-1 B1 F2");

	        
	    	gc.fillRect(515,250,18,20);
	    	gc.fillRect(550,250,18,20);
	    	CheckBox cb2 = new CheckBox();
	        cb2.setTranslateX(585);
	        cb2.setTranslateY(250);
	        cb2.setId("BA-1 B1 F1");

	        
	    	//APT-2
	    	gc.fillRect(645,180,18,20);
	    	gc.fillRect(680,180,18,20);
	    	CheckBox cb3 = new CheckBox();
	        cb3.setTranslateX(715);
	        cb3.setTranslateY(180);
	        cb3.setId("BA-1 B2 F3");
	        
	    	gc.fillRect(645,215,18,20);
	    	gc.fillRect(680,215,18,20);
	    	CheckBox cb4 = new CheckBox();
	        cb4.setTranslateX(715);
	        cb4.setTranslateY(215);
	        cb4.setId("BA-1 B2 F2");
	    
	    	gc.fillRect(645,250,18,20);
	    	gc.fillRect(680,250,18,20);
	    	CheckBox cb5 = new CheckBox();
	        cb5.setTranslateX(715);
	        cb5.setTranslateY(250);
	        cb5.setId("BA-1 B2 F1");

	    	
	    	//building 2 
	    	gc.setFill(Color.BLACK);
	    	gc.fillText(" BUILDING AREA-2",1200,330);
	    	gc.setFill(Color.CADETBLUE);
	    	gc.fillRect(1150, 150, 80, 150);
	    	gc.fillRect(1280, 150, 80, 150);
	    	gc.strokeLine(1180, 280, 1180, 300);
	    	gc.strokeLine(1205, 280, 1205, 300);
	    	gc.strokeLine(1205, 280, 1180, 280);
	    	
	    	gc.strokeLine(1310, 280, 1310, 300);
	    	gc.strokeLine(1335, 280, 1335, 300);
	    	gc.strokeLine(1310, 280, 1335, 280);
	    	
	     	//APT-1
	    	gc.setFill(Color.SADDLEBROWN);
	    	gc.fillRect(1165,180,18,20);
	    	gc.fillRect(1200,180,18,20);
	    	CheckBox cb6 = new CheckBox();
	        cb6.setTranslateX(1235);
	        cb6.setTranslateY(180);
	        cb6.setId("BA-2 B1 F3");
	 
	    	gc.fillRect(1165,215,18,20);
	    	gc.fillRect(1200,215,18,20);
	    	CheckBox cb7 = new CheckBox();
	        cb7.setTranslateX(1235);
	        cb7.setTranslateY(215);
	        cb7.setId("BA-2 B1 F2");

	    	gc.fillRect(1165,250,18,20);
	    	gc.fillRect(1200,250,18,20);
	    	CheckBox cb8 = new CheckBox();
	        cb8.setTranslateX(1235);
	        cb8.setTranslateY(250);
	        cb8.setId("BA-2 B1 F1");
	   
	    	
	    	//APT-2
	    	gc.fillRect(1295,180,18,20);
	    	gc.fillRect(1330,180,18,20);
	    	CheckBox cb9 = new CheckBox();
	        cb9.setTranslateX(1365);
	        cb9.setTranslateY(180);
	        cb9.setId("BA-2 B2 F3");

	    	gc.fillRect(1295,215,18,20);
	    	gc.fillRect(1330,215,18,20);
	    	CheckBox cb10 = new CheckBox();
	        cb10.setTranslateX(1365);
	        cb10.setTranslateY(215);
	        cb10.setId("BA-2 B2 F2");

	    	gc.fillRect(1295,250,18,20);
	    	gc.fillRect(1330,250,18,20);
	    	CheckBox cb11 = new CheckBox();
	        cb11.setTranslateX(1365);
	        cb11.setTranslateY(250);
	        cb11.setId("BA-2 B2 F1");
	 
	    	//building 3
	    	gc.setFill(Color.BLACK);
	    	gc.fillText(" BUILDING AREA-3",550,580);
	    	gc.setFill(Color.CADETBLUE);
	    	gc.fillRect(500,650,80,150);
	    	gc.fillRect(630, 650, 80, 150);
	    	gc.strokeLine(530, 780, 530, 800);
	    	gc.strokeLine(555, 780, 555, 800);
	    	gc.strokeLine(530, 780, 555, 780);
	    	
	    	gc.strokeLine(660, 780, 660, 800);
	    	gc.strokeLine(685, 780, 685, 800);
	    	gc.strokeLine(660, 780, 685, 780);
	    	
	    	//APT-1
	    	gc.setFill(Color.SADDLEBROWN);
	    	gc.fillRect(515,680,18,20);
	    	gc.fillRect(550,680,18,20);
	    	CheckBox cb12 = new CheckBox();
	        cb12.setTranslateX(585);
	        cb12.setTranslateY(680);
	        cb12.setId("BA-3 B1 F3");
	        
	    	gc.fillRect(515,715,18,20);
	    	gc.fillRect(550,715,18,20);
	    	CheckBox cb13 = new CheckBox();
	        cb13.setTranslateX(585);
	        cb13.setTranslateY(715);
	        cb13.setId("BA-3 B1 F2");
	        
	    	gc.fillRect(515,750,18,20);
	    	gc.fillRect(550,750,18,20);
	    	CheckBox cb14 = new CheckBox();
	        cb14.setTranslateX(585);
	        cb14.setTranslateY(750);
	        cb14.setId("BA-3 B1 F1");
	        
	    	//APT-2
	    	gc.fillRect(645,680,18,20);
	    	gc.fillRect(680,680,18,20);
	    	CheckBox cb15 = new CheckBox();
	        cb15.setTranslateX(715);
	        cb15.setTranslateY(680);
	        cb15.setId("BA-3 B2 F3");
	        
	    	gc.fillRect(645,715,18,20);
	    	gc.fillRect(680,715,18,20);
	    	CheckBox cb16 = new CheckBox();
	        cb16.setTranslateX(715);
	        cb16.setTranslateY(715);
	        cb16.setId("BA-3 B2 F2");
	        
	    	gc.fillRect(645,750,18,20);
	    	gc.fillRect(680,750,18,20);
	    	CheckBox cb17 = new CheckBox();
	        cb17.setTranslateX(715);
	        cb17.setTranslateY(750);
	        cb17.setId("BA-3 B2 F1");
	    	
	    	//building 4
	    	gc.setFill(Color.BLACK);
	    	gc.fillText(" BUILDING AREA-4",1200,580);
	    	gc.setFill(Color.CADETBLUE);
	    	gc.fillRect(1150,650,80,150);
	    	gc.fillRect(1280, 650, 80, 150);
	    	gc.strokeLine(1180, 780, 1180, 800);
	    	gc.strokeLine(1205, 780, 1205, 800);
	    	gc.strokeLine(1180, 780, 1205, 780);
	    	
	    	gc.strokeLine(1310, 780, 1310, 800);
	    	gc.strokeLine(1335, 780, 1335, 800);
	    	gc.strokeLine(1310, 780, 1335, 780);
	    	
	    	//APT-1
	    	gc.setFill(Color.SADDLEBROWN);
	    	gc.fillRect(1165,680,18,20);
	    	gc.fillRect(1200,680,18,20);
	    	CheckBox cb18 = new CheckBox();
	        cb18.setTranslateX(1235);
	        cb18.setTranslateY(680);
	        cb18.setId("BA-4 B1 F3");
	        
	    	gc.fillRect(1165,715,18,20);
	    	gc.fillRect(1200,715,18,20);
	    	CheckBox cb19 = new CheckBox();
	        cb19.setTranslateX(1235);
	        cb19.setTranslateY(715);
	        cb19.setId("BA-4 B1 F2");
	        
	    	gc.fillRect(1165,750,18,20);
	    	gc.fillRect(1200,750,18,20);
	    	CheckBox cb20 = new CheckBox();
	        cb20.setTranslateX(1235);
	        cb20.setTranslateY(750);
	        cb20.setId("BA-4 B1 F1");
	        
	    	//APT-2
	    	gc.fillRect(1295,680,18,20);
	    	gc.fillRect(1330,680,18,20);
	    	CheckBox cb21 = new CheckBox();
	        cb21.setTranslateX(1365);
	        cb21.setTranslateY(680);
	        cb21.setId("BA-4 B2 F3");
	    	
	    	gc.fillRect(1295,715,18,20);
	    	gc.fillRect(1330,715,18,20);
	    	CheckBox cb22 = new CheckBox();
	        cb22.setTranslateX(1365);
	        cb22.setTranslateY(715);
	        cb22.setId("BA-4 B2 F2");
	    	
	    	gc.fillRect(1295,750,18,20);
	    	gc.fillRect(1330,750,18,20);
	    	CheckBox cb23 = new CheckBox();
	        cb23.setTranslateX(1365);
	        cb23.setTranslateY(750);
	        cb23.setId("BA-4 B2 F1");
	    	
	    	
	    	//all strokes
	    	gc.strokeLine(750, 100, 750, 300);
	    	gc.strokeLine(750, 300, 450, 300);
	    	gc.strokeLine(1100, 100, 1100, 300);
	    	gc.strokeLine(1100, 300, 1400, 300);
	    	gc.strokeLine(450, 600, 750, 600);
	    	gc.strokeLine(750, 600, 750, 800);
	    	gc.strokeLine(450, 800, 1400, 800);
	    	gc.strokeLine(450, 100, 450, 800);
	    	gc.strokeLine(450, 100, 1400, 100);
	    	gc.strokeLine(1400, 100, 1400, 800);
	    	gc.strokeLine(1100,600,1400,600);
	    	gc.strokeLine(1100,600,1100,800);
	    	
	    	//garden
	    	gc.setFill(Color.BLACK);
	    	gc.fillText(" MULTIPURPOSE GARDEN ",850,580);
	    	gc.setFill(Color.GREEN);
	    	gc.fillRoundRect(650, 350, 550, 200, 10, 10);
	    	CheckBox cb24 = new CheckBox();
	        cb24.setTranslateX(1030);
	        cb24.setTranslateY(565);
	        cb24.setId("Garden Fire");
	      
	    	yes.setOnAction(e-> {
	    		FireFileObservable ff = new FireFileObservable();
	    		try {
					ff.checks(cb, cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9, cb10, cb11, cb12, cb13, cb14, cb15, cb16, cb17, cb18, cb19, cb20, cb21, cb22, cb23, cb24);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		SceneFactory breakFactory = new BreakInAlarmFactory();
	        	breakFactory.createBuildingScene(primaryStage, text2).showScene();
	        	showAlert(Alert.AlertType.INFORMATION, root.getScene().getWindow(),"",ButtonType.OK, 
	          	        "Please Select Break In Sensor Alarms ");
	    		
	    	});
	        
	        primaryStage.setTitle("SoSafe Securities");
	        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
	        root.getChildren().addAll(ellipse, text, text1, yes, no,cb24, cb,cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8,cb9,cb10,cb11,cb12,cb13,cb14,cb15,cb16,cb17,cb18,cb19,cb20,cb21,cb22,cb23);
	        primaryStage.setWidth(primaryScreenBounds.getWidth());
	        primaryStage.setHeight(primaryScreenBounds.getHeight());
	       	gc.fill();
	    	gc.closePath();
	    	gc.stroke();
	    	return new FireAlarmBuildingProduct(scene, primaryStage);
	    	
		}
	
	
	//displays alert box
	private void showAlert(Alert.AlertType alertType, Window owner, String title , ButtonType button, String message) {
		
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.showAndWait();

    }

	//plays the sound for alarm
	public void playAlarm()
	{
	    String musicFile = "alarm.mp3";     
	    Media sound = new Media(new File(musicFile).toURI().toString());
	    this.mediaPlayer = new MediaPlayer(sound);
	    mediaPlayer.play();
	}

	//stops the alarm after a time
	public void stopAlarm()
	{
	    this.mediaPlayer.stop();
	}
	
	//creates emergency scene for Fire Alarm
	    public EmergencyProduct createEmergencyScene(Stage primaryStage, String text, String item, int fire, int sensor) {
		
			Rectangle rect = new Rectangle();
			Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
			rect.setWidth(primaryScreenBounds.getWidth());
		    rect.setHeight(primaryScreenBounds.getHeight());
		    emergencyCalling.setFont(Font.font ("Calibri", FontWeight.BOLD, 70));
	        emergencyCalling.setFill(Color.WHITE);
	        emergencyCalling.setTextAlignment(TextAlignment.CENTER);
	        emergencyCalling.setLayoutX(100);
	        emergencyCalling.setLayoutY(200);

		    Timeline timeline = new Timeline(
		            new KeyFrame(Duration.seconds(0.5), e -> rect.setFill(Color.RED)),
		            new KeyFrame(Duration.seconds(1.0), e -> rect.setFill(Color.CRIMSON)),
		            new KeyFrame(Duration.seconds(0), e -> playAlarm()),
		            new KeyFrame(Duration.seconds(2.0), e -> stopAlarm())
		      );

	    timeline.setCycleCount(20);   
	    timeline.play();
	    Button nextScreen = new Button("Stop Alarm");
	    nextScreen.setLayoutX(500);
	    nextScreen.setLayoutY(500);
	    nextScreen.setOnAction(e->{
	    	stopAlarm();
	    	timeline.stop();
	   
	    	ShowBill controlPanel = new ShowBill();
	    	try {
	    		controlPanel.bill(primaryStage, text, fire, sensor);
	    	} catch (ClassNotFoundException | IOException | SQLException e1) {
	    		// TODO Auto-generated catch block
	    		e1.printStackTrace();
	    	}	
	        });
	        
	    Text id = new Text("Fire at " +item);
	    id.setFill(Color.WHITE);
	    id.setFont(Font.font("Calibri", 40));
	    id.setLayoutX(700);
	    id.setLayoutY(700);
	    Pane pane = new Pane(rect);
	    pane.getChildren().addAll(emergencyCalling, nextScreen, id);
	    Scene scene = new Scene(pane, 1450, 700);
	
		return new FireAlarmEmergencyProduct(scene, primaryStage);
	    }	
}


