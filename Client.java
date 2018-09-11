package application;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

//Client for Proxy Pattern
public class Client extends Application {

    Stage window;
    Scene scene;
	
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
    	File file = new File("status.txt");
    	String text = "";
		file.delete();
    	EntrySubject login = new LoginForm();
    	login.display(primaryStage, text);
    	

    	
    }
}