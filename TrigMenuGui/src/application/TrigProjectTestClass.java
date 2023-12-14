package application;

import javafx.stage.Stage;

public class TrigProjectTestClass extends TrigMenu {

	public static void main(String[] args) {
		launch(args); // Launches the JavaFX application
	}

	@Override
	public void start(Stage stage) {

        // Create an instance of TrigProjectTestClass
		TrigProjectTestClass trigProject = new TrigProjectTestClass();
		// Switch to the TrigMenu
		trigProject.switchToTrigMenu(stage);
	}
}