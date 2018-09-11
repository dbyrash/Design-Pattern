package application;

import javafx.scene.Scene;
import javafx.stage.Stage;

//Creates BreakIn Building Scene(Concrete Product)
public class BreakInBuildingProduct implements BuildingProduct {

	Stage primaryStage;
	Scene scene;
	
	public BreakInBuildingProduct(Scene scene, Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.scene = scene;
	}

	public void showScene() {
		primaryStage.setScene(scene);
		primaryStage.show();
	}


}
