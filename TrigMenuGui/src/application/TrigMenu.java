package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TrigMenu extends Application {

	@Override
	public void start(Stage stage) {
		// Create root pane
		AnchorPane root = new AnchorPane();

		// Create "Begin!" button
		Button beginButton = new Button("Begin!");
		beginButton.setLayoutX(240.0);
		beginButton.setLayoutY(240.0);
		beginButton.setFont(new Font("Goudy Old Style", 27.0));
		beginButton.setOnAction(e -> switchToTrigMenu(stage));

		// Create welcome text
		Text welcomeText = new Text("Welcome to Trig Help!");
		welcomeText.setLayoutX(84.0);
		welcomeText.setLayoutY(100.0);
		welcomeText.setFont(new Font("Goudy Old Style Bold", 57.0));

		// Add nodes to the root pane
		root.getChildren().addAll(beginButton, welcomeText);

		// Create scene and set it on the stage
		Scene scene = new Scene(root, 650, 400);
		stage.setScene(scene);
		stage.setTitle("Welcome");

		// Show the stage
		stage.show();
	}

	protected void switchToTrigMenu(Stage stage) {

		AnchorPane root = new AnchorPane();

		Text text1 = new Text("1. Practice");
		text1.setFont(new Font("Goudy Old Style Bold", 34.0));
		text1.setLayoutX(87.0);
		text1.setLayoutY(104.0);
		text1.setStyle("#514848");
		text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
		text1.setStrokeWidth(0.0);
		text1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
		text1.setWrappingWidth(420.13671875);

		Text text2 = new Text("2. Learn Lesson");
		text2.setFont(new Font("Goudy Old Style Bold", 34.0));
		text2.setLayoutX(87.0);
		text2.setLayoutY(143.0);
		text2.setStyle("#514848");
		text2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
		text2.setStrokeWidth(0.0);
		text2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
		text2.setWrappingWidth(420.13671875);

		Text text3 = new Text("3. Calculator");
		text3.setFont(new Font("Goudy Old Style Bold", 34.0));
		text3.setLayoutX(87.0);
		text3.setLayoutY(182.0);
		text3.setStyle("#514848");
		text3.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
		text3.setStrokeWidth(0.0);
		text3.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
		text3.setWrappingWidth(420.13671875);

		Text text4 = new Text("Main Menu:");
		text4.setFont(new Font("Goudy Old Style Bold", 33.0));
		text4.setLayoutX(57.0);
		text4.setLayoutY(65.0);
		text4.setStyle("#514848");
		text4.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
		text4.setStrokeWidth(0.0);
		text4.setWrappingWidth(420.13671875);

		Button button1 = new Button("1");
		button1.setLayoutX(115.0);
		button1.setLayoutY(253.0);
		button1.setFont(new Font("Goudy Old Style", 29.0));

		Button button2 = new Button("2");
		button2.setLayoutX(280.0);
		button2.setLayoutY(253.0);
		button2.setFont(new Font("Goudy Old Style", 29.0));

		Button button3 = new Button("3");
		button3.setLayoutX(462.0);
		button3.setLayoutY(253.0);
		button3.setFont(new Font("Goudy Old Style", 29.0));

		button1.setOnAction(e -> handleButtonSelection(1, stage));
		button2.setOnAction(e -> handleButtonSelection(2, stage));
		button3.setOnAction(e -> handleButtonSelection(3, stage));

		root.getChildren().addAll(text1, text2, text3, text4, button1, button2, button3);

		Scene scene = new Scene(root, 600, 400);
		stage.setScene(scene);
		stage.setTitle("Trig Menu Welcome");
		stage.show();
	}

	private void handleButtonSelection(int choice, Stage stage) {
		switch (choice) {
		case 1:
			// Redirect to Practice submenu
			PracticeController practiceproblem = new PracticeController();
			practiceproblem.switchToLearnLessonController(stage);
			break;
		case 2:
			// Redirect to Learn Lesson submenu
			LearnLessonController learnLesson = new LearnLessonController();
			learnLesson.switchToLearnLessonController(stage, null, null);
			break;
		case 3:
			// Redirect to Calculator submenu
			CalculatorController calculator = new CalculatorController();
			calculator.switchtoCalculatorController(stage);
			break;
		default:
			// Handle unexpected button selection
			break;
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
