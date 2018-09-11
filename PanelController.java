package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//Controller for MVC
public class PanelController {
	private ObservableList<String> item = FXCollections.observableArrayList();
	private ListView<String> items = new ListView<String>(item);
	private ObservableList<String> item1 = FXCollections.observableArrayList();
	private ListView<String> items1 = new ListView<String>(item1);
	private int sensor = 0, fire = 0;
	
	public void update(Stage stage, String text) {
		VBox combo = new VBox();
		VBox combo1 = new VBox();
		String line = "";
        
        try {
        	BufferedReader bReader = new BufferedReader(new FileReader("check.txt"));
			while ((line = bReader.readLine()) != null) {
				if("Swimming Pool".equals(line)) {
					combo1.getChildren().add(comboBox(line));
					sensor++;
					
					
					}
				if("Garden Sensor".equals(line)) {
					combo1.getChildren().add(comboBox(line));
					sensor++;
					
					
					}
				if("Garden Fire".equals(line)) {
					combo.getChildren().add(comboBox(line));
					fire++;
					
					}
				if("BA-1".equals(line)) {
					combo1.getChildren().add(comboBox(line));
					sensor++;
					
					
					}
				if("BA-2".equals(line)) {
					combo1.getChildren().add(comboBox(line));
					sensor++;
					
					
					}
				if("BA-3".equals(line)) {
					combo1.getChildren().add(comboBox(line));
					sensor++;
					
					}
				if("BA-4".equals(line)) {
					combo1.getChildren().add(comboBox(line));
					sensor++;
					
					}
				if("BA-1 B1 F1".equals(line)) {
					combo.getChildren().add(comboBox(line));
					fire++;
					
					
					}
				if("BA-1 B1 F2".equals(line)) {
					combo.getChildren().add(comboBox(line));
					fire++;
				
					}
				if("BA-1 B1 F3".equals(line)) {
					combo.getChildren().add(comboBox(line));
					fire++;
					
					}
				if("BA-1 B2 F1".equals(line)) {
					
					combo.getChildren().add(comboBox(line));
					fire++;
					
					}
				if("BA-1 B2 F2".equals(line)) {
					
					combo.getChildren().add(comboBox(line));
					fire++;
					
					}
				if("BA-1 B2 F3".equals(line)) {
				
					combo.getChildren().add(comboBox(line));
					fire++;
					
					}
				if("BA-2 B1 F1".equals(line)) {
				
					combo.getChildren().add(comboBox(line));
					fire++;
					
					}
				if("BA-2 B1 F2".equals(line)) {
				
					combo.getChildren().add(comboBox(line));
					fire++;
					
					}
				if("BA-2 B1 F3".equals(line)) {
				
					combo.getChildren().add(comboBox(line));
					fire++;
					}
				if("BA-2 B2 F1".equals(line)) {
					
					combo.getChildren().add(comboBox(line));
					fire++;
					}
				if("BA-2 B2 F2".equals(line)) {
				
					combo.getChildren().add(comboBox(line));
					fire++;
					}
				if("BA-2 B2 F3".equals(line)) {
				
					combo.getChildren().add(comboBox(line));
					fire++;
			
					}
				if("BA-3 B1 F1".equals(line)) {
			
					combo.getChildren().add(comboBox(line));
					fire++;
					
					}
				if("BA-3 B1 F2".equals(line)) {
				
					combo.getChildren().add(comboBox(line));
					fire++;
					
					}
				if("BA-3 B1 F3".equals(line)) {
				
					combo.getChildren().add(comboBox(line));
					fire++;
					}
				if("BA-3 B2 F1".equals(line)) {
				
					combo.getChildren().add(comboBox(line));
					fire++;
					}
				if("BA-3 B2 F2".equals(line)) {
					
					combo.getChildren().add(comboBox(line));
					
					fire++;
					}
				if("BA-3 B2 F3".equals(line)) {
				
					combo.getChildren().add(comboBox(line));
					fire++;
					
					}
				
				if("BA-4 B1 F1".equals(line)) {
				
					combo.getChildren().add(comboBox(line));
					fire++;
				
					}
				if("BA-4 B1 F2".equals(line)) {
				
					combo.getChildren().add(comboBox(line));
					fire++;
					
					}
				if("BA-4 B1 F3".equals(line)) {
				
					combo.getChildren().add(comboBox(line));
					fire++;
					
					}
				if("BA-4 B2 F1".equals(line)) {
					
					combo.getChildren().add(comboBox(line));
					fire++;
				
					}
				if("BA-4 B2 F2".equals(line)) {
				
					combo.getChildren().add(comboBox(line));
					fire++;
				
					}
				if("BA-4 B2 F3".equals(line)) {
				
					combo.getChildren().add(comboBox(line));
					fire++;
					
					}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        FireFileObservable ff  = new FireFileObservable();
        item = ff.setListFire(item);
        item1 = ff.setListSensor(item1);
        items1.setItems(item1);
        items.setItems(item);
        ControlPanelController cp = new ControlPanelController();
        cp.control(items, items1, combo, combo1, fire, sensor, stage, text, item, item1);
        
	}
	public ComboBox<String> comboBox(String line) {
		ComboBox<String> myComboBox = new ComboBox<String>();
	    myComboBox.getItems().addAll("7:00 - 19:00", "10:00 - 22:00", "18:00 - 6:00", "Deactivate");
	    myComboBox.setEditable(true); 
	    myComboBox.setStyle("-fx-alignment: center");
	    return myComboBox;
	}
}
