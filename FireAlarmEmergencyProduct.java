package application;

import javafx.scene.Scene;
import javafx.stage.Stage;

//Creates the product FireAlarm Emergency Scene(Concrete Product)
public class FireAlarmEmergencyProduct implements EmergencyProduct{
	Scene scene;
	Stage stage;
	public FireAlarmEmergencyProduct(Scene scene, Stage stage) {
		this.stage = stage;
		this.scene = scene;
	}

	public void showScene() {
		stage.setScene(scene);
		stage.show();
	}

}
