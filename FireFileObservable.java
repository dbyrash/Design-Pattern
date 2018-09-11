package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Observable;

import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


//Model for MVC
//Observable Class for Observor
public class FireFileObservable extends Observable{
	
	//Creates the Text File
	public void checks(CheckBox cb, CheckBox cb1, CheckBox cb2, CheckBox cb3, CheckBox cb4, CheckBox cb5, CheckBox cb6, CheckBox cb7, CheckBox cb8, CheckBox cb9, CheckBox cb10, CheckBox cb11, CheckBox cb12, CheckBox cb13, CheckBox cb14, CheckBox cb15, CheckBox cb16, CheckBox cb17, CheckBox cb18, CheckBox cb19, CheckBox cb20, CheckBox cb21, CheckBox cb22, CheckBox cb23, CheckBox cb24) throws IOException
	{	
		File file = new File("check.txt");
		file.delete();
        FileWriter fr = null;
        BufferedWriter br = null;
        fr = new FileWriter(file);
        br = new BufferedWriter(fr);
		
		if(cb.isSelected()) {
			br.write(cb.getId());	
			br.newLine();
		}
		if(cb1.isSelected()) {
			br.write(cb1.getId());
			br.newLine();
		}
		if(cb2.isSelected()) {
			br.write(cb2.getId());
			br.newLine();
		}
		if(cb3.isSelected()) {
			br.write(cb3.getId());
			br.newLine();
		}
		if(cb4.isSelected()) {
			br.write(cb4.getId());
			br.newLine();
		}
		if(cb5.isSelected()) {
			br.write(cb5.getId());
			br.newLine();
		}
		if(cb6.isSelected()) {
			br.write(cb6.getId());
			br.newLine();
		}
		if(cb7.isSelected()) {
			br.write(cb7.getId());
			br.newLine();
		}
		if(cb8.isSelected()) {
			br.write(cb8.getId());
			br.newLine();
		}
		if(cb9.isSelected()) {
			br.write(cb9.getId());
			br.newLine();
		}
		if(cb10.isSelected()) {
			br.write(cb10.getId());
			br.newLine();
		}
		if(cb11.isSelected()) {
			br.write(cb11.getId());
			br.newLine();
		}
		if(cb12.isSelected()) {
			br.write(cb12.getId());
			br.newLine();
		}
		if(cb13.isSelected()) {
			br.write(cb13.getId());
			br.newLine();
		}
		if(cb14.isSelected()) {
			br.write(cb14.getId());
			br.newLine();
		}
		if(cb15.isSelected()) {
			br.write(cb15.getId());
			br.newLine();
		}
		if(cb16.isSelected()) {
			br.write(cb16.getId());
			br.newLine();
		}
		if(cb17.isSelected()) {
			br.write(cb17.getId());
			br.newLine();
		}
		if(cb18.isSelected()) {
			br.write(cb18.getId());
			br.newLine();
		}
		if(cb19.isSelected()) {
			br.write(cb19.getId());
			br.newLine();
		}
		if(cb20.isSelected()) {
			br.write(cb20.getId());
			br.newLine();
		}
		if(cb21.isSelected()) {
			br.write(cb21.getId());
			br.newLine();
		}
		if(cb22.isSelected()) {
			br.write(cb22.getId());
			br.newLine();
		}
		if(cb23.isSelected()) {
			br.write(cb23.getId());
			br.newLine();
		}
		if(cb24.isSelected()) {
			br.write(cb24.getId());
			br.newLine();
		}

		br.close();
		fr.close();
	
	}
	
	//Creates the text File
	public void checks(CheckBox cb, CheckBox cb1, CheckBox cb2, CheckBox cb3, CheckBox cb4, CheckBox cb5) throws IOException
	{	
		
        FileWriter fr = new FileWriter("check.txt", true);
        BufferedWriter br = new BufferedWriter(fr);
		
		if(cb.isSelected()) {
			br.write(cb.getId());	
			br.newLine();
		}
		if(cb1.isSelected()) {
			br.write(cb1.getId());
			br.newLine();
		}
		if(cb2.isSelected()) {
			br.write(cb2.getId());
			br.newLine();
		}
		if(cb3.isSelected()) {
			br.write(cb3.getId());
			br.newLine();
		}
		if(cb4.isSelected()) {
			br.write(cb4.getId());
			br.newLine();
		}
		if(cb5.isSelected()) {
			br.write(cb5.getId());
			br.newLine();
		}
		

		br.close();
		fr.close();
	
	}
	
	//Searches the text File
	public VBox searchSensor(VBox motion) {
		String line = "";
		BufferedReader bReader;
	
        try {
        	bReader = new BufferedReader(new FileReader("check.txt"));
			while ((line = bReader.readLine()) != null) {
				if("Swimming Pool".equals(line)) {
					motion.getChildren().add(new Text(line));
					}
				if("Garden Sensor".equals(line)) {
					
					motion.getChildren().add(new Text(line));
					}
				
				if("BA-1".equals(line)) {
					
					motion.getChildren().add(new Text(line));
					
					}
				if("BA-2".equals(line)) {
					
					motion.getChildren().add(new Text(line));
					
					}
				if("BA-3".equals(line)) {
					motion.getChildren().add(new Text(line));
					
					}
				if("BA-4".equals(line)) {
					
					motion.getChildren().add(new Text(line));
					}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return motion;
	}
	
	//Searches the text File
	public VBox searchFire(VBox fireSensor) {
		String line = "";
		BufferedReader bReader;
	
		try {
			bReader = new BufferedReader(new FileReader("check.txt"));
			while ((line = bReader.readLine()) != null) {
			if("BA-1 B1 F1".equals(line)) {
				
				fireSensor.getChildren().add(new Text(line));
				
				}
			if("Garden Fire".equals(line)) {
				
				fireSensor.getChildren().add(new Text(line));
				}
			if("BA-1 B1 F2".equals(line)) {
				
				fireSensor.getChildren().add(new Text(line));

				}
			if("BA-1 B1 F3".equals(line)) {
				
				fireSensor.getChildren().add(new Text(line));

				}
			if("BA-1 B2 F1".equals(line)) {
				
				fireSensor.getChildren().add(new Text(line));

				}
			if("BA-1 B2 F2".equals(line)) {
				
				fireSensor.getChildren().add(new Text(line));

				}
			if("BA-1 B2 F3".equals(line)) {
				fireSensor.getChildren().add(new Text(line));

				
				}
			if("BA-2 B1 F1".equals(line)) {
				
				fireSensor.getChildren().add(new Text(line));

				}
			if("BA-2 B1 F2".equals(line)) {
				
				fireSensor.getChildren().add(new Text(line));
				
				}
			if("BA-2 B1 F3".equals(line)) {
				fireSensor.getChildren().add(new Text(line));
				
				}
			if("BA-2 B2 F1".equals(line)) {
				fireSensor.getChildren().add(new Text(line));

				}
			if("BA-2 B2 F2".equals(line)) {
				fireSensor.getChildren().add(new Text(line));
				
				}
			if("BA-2 B2 F3".equals(line)) {
				
				fireSensor.getChildren().add(new Text(line));

				}
			if("BA-3 B1 F1".equals(line)) {
				fireSensor.getChildren().add(new Text(line));
				
				
				}
			if("BA-3 B1 F2".equals(line)) {
				
				fireSensor.getChildren().add(new Text(line));

				}
			if("BA-3 B1 F3".equals(line)) {
				fireSensor.getChildren().add(new Text(line));
				
				}
			if("BA-3 B2 F1".equals(line)) {
				fireSensor.getChildren().add(new Text(line));

				}
			if("BA-3 B2 F2".equals(line)) {
				fireSensor.getChildren().add(new Text(line));

				}
			if("BA-3 B2 F3".equals(line)) {
				
				fireSensor.getChildren().add(new Text(line));

				}
			
			if("BA-4 B1 F1".equals(line)) {
				fireSensor.getChildren().add(new Text(line));

			
				}
			if("BA-4 B1 F2".equals(line)) {
				
				fireSensor.getChildren().add(new Text(line));

				}
			if("BA-4 B1 F3".equals(line)) {
				fireSensor.getChildren().add(new Text(line));

				
				}
			if("BA-4 B2 F1".equals(line)) {
				
				fireSensor.getChildren().add(new Text(line));

				}
			if("BA-4 B2 F2".equals(line)) {
				fireSensor.getChildren().add(new Text(line));

			
				}
			if("BA-4 B2 F3".equals(line)) {
				fireSensor.getChildren().add(new Text(line));

				
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fireSensor;
	}
	
	//Creates Observable List using text file
	public ObservableList<String> setListFire(ObservableList<String> item) {
		String line = "";
        int fire =0;
        try {
        	BufferedReader bReader = new BufferedReader(new FileReader("check.txt"));
			while ((line = bReader.readLine()) != null) {
				
				if("Garden Fire".equals(line)) {
					item.add("Fire Alarm Sensor at Garden Area");
					
					}
				
				if("BA-1 B1 F1".equals(line)) {
					item.add("Fire Alarm Sensor at Building Area 1 Building 1 Floor 1");
					
					
					}
				if("BA-1 B1 F2".equals(line)) {
					item.add("Fire Alarm Sensor at Building Area 1 Building 1 Floor 2");
				
					}
				if("BA-1 B1 F3".equals(line)) {
					item.add("Fire Alarm Sensor at Building Area 1 Building 1 Floor 3");
					
					}
				if("BA-1 B2 F1".equals(line)) {
					item.add("Fire Alarm Sensor at Building Area 1 Building 2 Floor 1");
				
					}
				if("BA-1 B2 F2".equals(line)) {
					item.add("Fire Alarm Sensor at Building Area 1 Building 2 Floor 2");
	
					}
				if("BA-1 B2 F3".equals(line)) {
					item.add("Fire Alarm Sensor at Building Area 1 Building 2 Floor 3");
				
					}
				if("BA-2 B1 F1".equals(line)) {
					item.add("Fire Alarm Sensor at Building Area 2 Building 1 Floor 1");
				
					
					}
				if("BA-2 B1 F2".equals(line)) {
					item.add("Fire Alarm Sensor at Building Area 2 Building 1 Floor 2");
				
					}
				if("BA-2 B1 F3".equals(line)) {
					item.add("Fire Alarm Sensor at Building Area 2 Building 1 Floor 3");
				
					}
				if("BA-2 B2 F1".equals(line)) {
					item.add("Fire Alarm Sensor at Building Area 2 Building 2 Floor 1");
					
					}
				if("BA-2 B2 F2".equals(line)) {
					item.add("Fire Alarm Sensor at Building Area 2 Building 2 Floor 2");
				
					}
				if("BA-2 B2 F3".equals(line)) {
					item.add("Fire Alarm Sensor at Building Area 2 Building 2 Floor 3");
				
					}
				if("BA-3 B1 F1".equals(line)) {
					item.add("Fire Alarm Sensor at Building Area 3 Building 1 Floor 1");
				
					}
				if("BA-3 B1 F2".equals(line)) {
					item.add("Fire Alarm Sensor at Building Area 3 Building 1 Floor 2");
				
					}
				if("BA-3 B1 F3".equals(line)) {
					item.add("Fire Alarm Sensor at Building Area 3 Building 1 Floor 3");
				
					}
				if("BA-3 B2 F1".equals(line)) {
					item.add("Fire Alarm Sensor at Building Area 3 Building 2 Floor 1");
					
					}
				if("BA-3 B2 F2".equals(line)) {
					item.add("Fire Alarm Sensor at Building Area 3 Building 2 Floor 2");
				
					}
				if("BA-3 B2 F3".equals(line)) {
					item.add("Fire Alarm Sensor at Building Area 3 Building 2 Floor 3");
					
					}
				
				if("BA-4 B1 F1".equals(line)) {
					item.add("Fire Alarm Sensor at Building Area 4 Building 1 Floor 1");
					
					}
				if("BA-4 B1 F2".equals(line)) {
					item.add("Fire Alarm Sensor at Building Area 4 Building 1 Floor 2");
					
					}
				if("BA-4 B1 F3".equals(line)) {
					item.add("Fire Alarm Sensor at Building Area 4 Building 1 Floor 3");
					
					}
				if("BA-4 B2 F1".equals(line)) {
					item.add("Fire Alarm Sensor at Building Area 4 Building 2 Floor 1");
				
					}
				if("BA-4 B2 F2".equals(line)) {
					item.add("Fire Alarm Sensor at Building Area 4 Building 2 Floor 2");
					
					}
				if("BA-4 B2 F3".equals(line)) {
					item.add("Fire Alarm Sensor at Building Area 4 Building 2 Floor 3");
					
					}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return item;
	}
	
	//Creates Observable list using text file
	public ObservableList<String> setListSensor(ObservableList<String> item1) {
		String line ="";
	
		try {
			BufferedReader bReader = new BufferedReader(new FileReader("check.txt"));
			while ((line = bReader.readLine()) != null) {
				if("Swimming Pool".equals(line)) {
					item1.add("Break-in Sensor at Swimming Pool");
			
					}
				if("Garden Sensor".equals(line)) {
					item1.add("Break-in Sensor at Garder Area");
					}
					
				if("BA-1".equals(line)) {
					item1.add("Break-in Sensor at Building Area 1");
			
					}
				if("BA-2".equals(line)) {
					item1.add("Break-in Sensor at Building Area 2");

					
					}
				if("BA-3".equals(line)) {
					item1.add("Break-in Sensor at Building Area 3");
					
					}
				if("BA-4".equals(line)) {
					item1.add("Break-in Sensor at Building Area 4");
					
					}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return item1;
	}
}
