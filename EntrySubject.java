package application;

import java.io.FileNotFoundException;

import javafx.stage.Stage;

//Subject for Proxy Pattern
public interface EntrySubject{
	public void display(Stage stage, String text)throws FileNotFoundException;
}
