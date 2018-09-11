package application;

import javafx.scene.Scene;
import javafx.stage.Stage;

//Creates BreakIn Emergency Scene(Concrete Product)
public class BreakInEmergencyProduct implements EmergencyProduct{

	Scene scene;
	Stage stage;
	
	public BreakInEmergencyProduct(Scene scene, Stage stage) {
		this.scene = scene;
		this.stage = stage;
	}

	@Override
	public void showScene() {
		stage.setScene(scene);
		stage.show();
		
	}

}
