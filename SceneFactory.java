package application;

import javafx.stage.Stage;

//Abstract Factory for abstract factory pattern and builds a Scene
public interface SceneFactory {
	
	//Builds Building Scene
	public BuildingProduct createBuildingScene(Stage stage, String text);
	//Builds Emergency Scene
	public EmergencyProduct createEmergencyScene(Stage stage, String text, String text1, int fire, int sensor);
}
