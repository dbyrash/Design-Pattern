package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FireAlarm {
	public void activate(String line, String value) {
		try {
       	 FileWriter file = new FileWriter("status.txt", true);
       	 BufferedWriter br = new BufferedWriter(file);
       	 br.write(line +" Status = Activated From " +value);
       	 br.newLine();
       	br.close();
       	file.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
}
	public void deactivate(String line) {
		try {
       	 FileWriter file = new FileWriter("status.txt", true);
       	 BufferedWriter br = new BufferedWriter(file);
       	 br.write(line +" Status = Deactivate");
       	 br.newLine();
       	br.close();
       	file.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
}
}
