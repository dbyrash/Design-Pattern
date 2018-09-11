package application;

import javafx.scene.Scene;
import javafx.stage.Stage;

//Creates Fire Alarm Building Product(Concrete Product)
public class FireAlarmBuildingProduct implements BuildingProduct{
	
	private Scene scene;
	private Stage stage;
	
	public FireAlarmBuildingProduct(Scene scene, Stage stage) {
		this.scene = scene;
		this.stage = stage;
	}
	
	public void showScene() {
		stage.setScene(scene);
		stage.show();
	}

}
