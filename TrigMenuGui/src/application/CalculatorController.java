package application;

import java.math.BigDecimal;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class CalculatorController extends TrigMenu {
	private TextField userInputField1;
	private TextField userInputField2;
	private TextField radianInputField;
	


    // Method to switch to the CalculatorController view
	public void switchtoCalculatorController(Stage stage) {
		// Create root pane
		AnchorPane root = new AnchorPane();

		// Create Calculator Options text
		Text titleText = new Text("Calculator Options");
		titleText.setLayoutY(53.0);
		titleText.setFont(new Font("Goudy Old Style Bold", 42.0));

		Text option1Text = new Text("1. Converting from radians to degrees");
		option1Text.setLayoutX(21.0);
		option1Text.setLayoutY(116.0);
		option1Text.setFont(new Font("Goudy Old Style Bold", 27.0));

		Text option2Text = new Text("2. Converting from degrees to radians");
		option2Text.setLayoutX(21.0);
		option2Text.setLayoutY(149.0);
		option2Text.setFont(new Font("Goudy Old Style Bold", 27.0));

		Text option3Text = new Text("3. Calculate area of sector");
		option3Text.setLayoutX(21.0);
		option3Text.setLayoutY(182.0);
		option3Text.setFont(new Font("Goudy Old Style Bold", 27.0));

		Text option4Text = new Text("4. Calculating arc length");
		option4Text.setLayoutX(21.0);
		option4Text.setLayoutY(215.0);
		option4Text.setFont(new Font("Goudy Old Style Bold", 27.0));

		Text option5Text = new Text("5. Get Trig Functions from right triangles");
		option5Text.setLayoutX(21.0);
		option5Text.setLayoutY(248.0);
		option5Text.setFont(new Font("Goudy Old Style Bold", 27.0));

		Text clickOptionText = new Text("Click an option:");
		clickOptionText.setLayoutX(-7.0);
		clickOptionText.setLayoutY(330.0);
		clickOptionText.setFont(new Font("Goudy Old Style Bold", 19.0));

		// Create buttons
		Button button1 = new Button("1");
		button1.setLayoutX(171.0);
		button1.setLayoutY(304.0);
		button1.setFont(new Font("Goudy Old Style Bold", 20.0));
		button1.setOnAction(e -> switchToRadianToDegree(stage));

		Button button2 = new Button("2");
		button2.setLayoutX(252.0);
		button2.setLayoutY(305.0);
		button2.setFont(new Font("Goudy Old Style Bold", 20.0));
		button2.setOnAction(e -> switchToOption2(stage));

		Button button3 = new Button("3");
		button3.setLayoutX(328.0);
		button3.setLayoutY(305.0);
		button3.setFont(new Font("Goudy Old Style Bold", 20.0));
		button3.setOnAction(e -> switchToOption3(stage));

		Button button4 = new Button("4");
		button4.setLayoutX(402.0);
		button4.setLayoutY(305.0);
		button4.setFont(new Font("Goudy Old Style Bold", 20.0));
		button4.setOnAction(e -> switchToOption4(stage));

		Button button5 = new Button("5");
		button5.setLayoutX(473.0);
		button5.setLayoutY(305.0);
		button5.setFont(new Font("Goudy Old Style Bold", 20.0));
		button5.setOnAction(e -> switchToOption5(stage));

		// Add nodes to the root pane
		root.getChildren().addAll(titleText, option1Text, option2Text, option3Text, option4Text, option5Text,
				clickOptionText, button1, button2, button3, button4, button5);

		// Create scene and set it on the stage
		Scene scene = new Scene(root, 600, 400);
		stage.setScene(scene);
		stage.setTitle("Calculator Options");
		stage.show();
	}

	// Method to switch to the Radian to Degree view
	private void switchToRadianToDegree(Stage stage) {
	    // Create root pane
	    AnchorPane root = new AnchorPane();

	    // Create "Radian to Degree" text
	    Text titleText = new Text("Radian to Degree");
	    titleText.setLayoutY(53.0);
	    titleText.setFont(new Font("Goudy Old Style Bold", 42.0));

	    // Create instruction text
	    Text instructionText = new Text("Enter your radian (only type in decimal format):");
	    instructionText.setLayoutX(24.0);
	    instructionText.setLayoutY(127.0);
	    instructionText.setFont(new Font("Goudy Old Style Bold", 19.0));

	    // Create TextField
	    TextField textField = new TextField("");
	    textField.setLayoutX(96.0);
	    textField.setLayoutY(298.0);
	    textField.setPrefHeight(30.0);
	    textField.setPrefWidth(436.0);

	    // Create result label
	    TextField resultLabel = new TextField("");
	    resultLabel.setLayoutX(96.0);
	    resultLabel.setLayoutY(200.0);
	    resultLabel.setPrefHeight(26.0);
	    resultLabel.setPrefWidth(436.0);

	    // Create prompt text next to the text field
	    Text promptText = new Text("Enter info");
	    promptText.setLayoutX(24.0);
	    promptText.setLayoutY(298.0);
	    promptText.setFont(new Font("Goudy Old Style Bold", 19.0));

	    // Add nodes to the root pane
	    root.getChildren().addAll(titleText, instructionText, resultLabel, promptText);
	    root.getChildren().addAll(textField);

	    // Creates scene and set it on the stage
	    stage.setScene(new Scene(root, 600, 400));
	    stage.setTitle("Radian to Degree");
	    stage.show();

	    // code for radian to Degree conversion
	    textField.setOnAction(event -> {
	        try {
	            double radians = Double.parseDouble(textField.getText());
	            double degrees = convertRadiansToDegrees(radians);
	            resultLabel.setText("Result: " + degrees + " degrees");
	        } catch (NumberFormatException e) {
	            resultLabel.setText("Invalid input");
	        }
	    });

	    // Sets created AutoCompleteTextField and resultLabel to instance variables
	    this.radianInputField = textField;
	    this.userInputField1 = resultLabel;
	}

	private double convertRadiansToDegrees(double radians) {
	    return radians * 180 / Math.PI;
	}


	// Method to switch to Option 2 view
	private void switchToOption2(Stage stage) {
	    System.out.println("Switching to Option 2...");
	    // Create root pane
	    AnchorPane root = new AnchorPane();

	    // Create "Degree to Radian" text
	    Text titleText = new Text("Degree to Radian");
	    titleText.setLayoutY(53.0);
	    titleText.setFont(new Font("Goudy Old Style Bold", 42.0));

	    // Create instruction text
	    Text instructionText = new Text("Enter Degrees to convert to radians:");
	    instructionText.setLayoutX(24.0);
	    instructionText.setLayoutY(127.0);
	    instructionText.setFont(new Font("Goudy Old Style Bold", 19.0));

	    // Create AutoCompleteTextField
	    TextField textField = new TextField();
	    textField.setLayoutX(96.0);
	    textField.setLayoutY(298.0);
	    textField.setPrefHeight(30.0);
	    textField.setPrefWidth(436.0);

	    // Create result label
	    TextField resultLabel = new TextField("");
	    resultLabel.setLayoutX(96.0);
	    resultLabel.setLayoutY(200.0);
	    resultLabel.setPrefHeight(26.0);
	    resultLabel.setPrefWidth(436.0);

	    // Create prompt text next to the text field
	    Text promptText = new Text("Enter info");
	    promptText.setLayoutX(24.0);
	    promptText.setLayoutY(298.0);
	    promptText.setFont(new Font("Goudy Old Style Bold", 19.0));

	    // Add nodes to the root pane
	    root.getChildren().addAll(titleText, instructionText, resultLabel, promptText);
	    root.getChildren().addAll(textField);

	    // Create scene and set it on the stage
	    // Assume primaryStage is your main stage
	    stage.setScene(new Scene(root, 600, 400));
	    stage.setTitle("Degree to Radian");
	    stage.show();

	    // code for Degree to Radian conversion
	    textField.setOnAction(event -> {
	        try {
	            double degrees = Double.parseDouble(textField.getText());
	            double radians = convertDegreesToRadians(degrees);
	            resultLabel.setText("Result: " + radians + " radians");
	        } catch (NumberFormatException e) {
	            resultLabel.setText("Invalid input");
	        }
	    });

	    // Set the created AutoCompleteTextField and resultLabel to instance variables
	    this.radianInputField = textField;
	    this.userInputField1 = resultLabel;
	}


	// Method to switch to Option 3 view
	private void switchToOption3(Stage stage) {
	    System.out.println("Switching to Option 3...");
	    AnchorPane root = new AnchorPane();

	    // Create "Degree to Radian" text
	    Text titleText = new Text("Calculate area of sector");
	    titleText.setLayoutY(53.0);
	    titleText.setFont(new Font("Goudy Old Style Bold", 42.0));

	    // Create instruction text
	    Text instructionText1 = new Text("Enter angle in radians:");
	    instructionText1.setLayoutX(24.0);
	    instructionText1.setLayoutY(127.0);
	    instructionText1.setFont(new Font("Goudy Old Style Bold", 19.0));

	    // Text field for angle input
	    TextField angleInputField = new TextField();
	    angleInputField.setLayoutX(200.0);
	    angleInputField.setLayoutY(122.0);
	    angleInputField.setPrefHeight(26.0);
	    angleInputField.setPrefWidth(100.0);

	    Text instructionText2 = new Text("Enter radius:");
	    instructionText2.setLayoutX(24.0);
	    instructionText2.setLayoutY(200.0);
	    instructionText2.setFont(new Font("Goudy Old Style Bold", 19.0));

	    // Text field for radius input
	    TextField radiusInputField = new TextField();
	    radiusInputField.setLayoutX(200.0);
	    radiusInputField.setLayoutY(195.0);
	    radiusInputField.setPrefHeight(26.0);
	    radiusInputField.setPrefWidth(100.0);

	    // Button for calculation
	    Button calculateButton = new Button("Calculate");
	    calculateButton.setLayoutX(24.0);
	    calculateButton.setLayoutY(260.0);

	    // Text field for result
	    TextField radianInputField = new TextField();
	    radianInputField.setLayoutX(24.0);
	    radianInputField.setLayoutY(320.0);
	    radianInputField.setPrefHeight(26.0);
	    radianInputField.setPrefWidth(436.0);

	    // Add nodes to the root pane
	    root.getChildren().addAll(titleText, instructionText1, angleInputField, instructionText2, radiusInputField, calculateButton, radianInputField);

	    // Create scene and set it on the stage
	    stage.setScene(new Scene(root, 600, 400));
	    stage.setTitle("Area of Sector");
	    stage.show();

	    // Set an action for the button
	    calculateButton.setOnAction(event -> {
	        try {
	            double angle = Double.parseDouble(angleInputField.getText());
	            double radius = Double.parseDouble(radiusInputField.getText());
	            double area = (angle / 2) * Math.pow(radius, 2);
	            radianInputField.setText("Area of sector: " + area);
	        } catch (NumberFormatException e) {
	            radianInputField.setText("Invalid input");
	        }
	    });
	}


	private void switchToOption4(Stage stage) {
	    System.out.println("Switching to Option 4...");
	    AnchorPane root = new AnchorPane();

	    // Create "Degree to Radian" text
	    Text titleText = new Text("Calculating arc length");
	    titleText.setLayoutY(53.0);
	    titleText.setFont(new Font("Goudy Old Style Bold", 42.0));

	    // Create instruction text for angle
	    Text instructionText1 = new Text("Enter angle in radians:");
	    instructionText1.setLayoutX(24.0);
	    instructionText1.setLayoutY(127.0);
	    instructionText1.setFont(new Font("Goudy Old Style Bold", 19.0));

	    // Text field for angle input
	    TextField angleInputField = new TextField();
	    angleInputField.setLayoutX(200.0);
	    angleInputField.setLayoutY(122.0);
	    angleInputField.setPrefHeight(26.0);
	    angleInputField.setPrefWidth(100.0);

	    // Create instruction text for radius
	    Text instructionText2 = new Text("Enter radius:");
	    instructionText2.setLayoutX(24.0);
	    instructionText2.setLayoutY(200.0);
	    instructionText2.setFont(new Font("Goudy Old Style Bold", 19.0));

	    // Text field for radius input
	    TextField radiusInputField = new TextField();
	    radiusInputField.setLayoutX(200.0);
	    radiusInputField.setLayoutY(195.0);
	    radiusInputField.setPrefHeight(26.0);
	    radiusInputField.setPrefWidth(100.0);

	    // Button for calculation
	    Button calculateButton = new Button("Calculate");
	    calculateButton.setLayoutX(24.0);
	    calculateButton.setLayoutY(260.0);

	    // Text field for result
	    TextField radianInputField = new TextField();
	    radianInputField.setLayoutX(24.0);
	    radianInputField.setLayoutY(320.0);
	    radianInputField.setPrefHeight(26.0);
	    radianInputField.setPrefWidth(436.0);

	    // Add nodes to the root pane
	    root.getChildren().addAll(titleText, instructionText1, angleInputField, instructionText2, radiusInputField, calculateButton, radianInputField);

	    // Create scene and set it on the stage
	    stage.setScene(new Scene(root, 600, 500));
	    stage.setTitle("Arc Length Calculation");
	    stage.show();

	    // Set the resultLabel to radianInputField
	    try {
	        calculateButton.setOnAction(event -> {
	            try {
	                double angle = Double.parseDouble(angleInputField.getText());
	                double radius = Double.parseDouble(radiusInputField.getText());
	                double arcLength = radius * angle;
	                radianInputField.setText("Arc length: " + arcLength);
	            } catch (NumberFormatException e) {
	                radianInputField.setText("Invalid input");
	            }
	        });
	    } catch (NumberFormatException e) {
	        radianInputField.setText("Invalid input");
	    }
	}	
	
	// Method to switch to Option 5 view
	private void switchToOption5(Stage stage) {
	    System.out.println("Switching to Option 5...");
	    AnchorPane root = new AnchorPane();
	    root.setPadding(new Insets(10));

	    // Create UI components
	    Label titleText = new Label("Trigonometric Function Calculator");
	    titleText.setFont(new Font("Goudy Old Style Bold", 20.0));
	    AnchorPane.setTopAnchor(titleText, 10.0);
	    AnchorPane.setLeftAnchor(titleText, 10.0);

	    Label instructionText = new Label("Select side types and enter lengths:");
	    AnchorPane.setTopAnchor(instructionText, 50.0);
	    AnchorPane.setLeftAnchor(instructionText, 10.0);

	    // ComboBoxes for side selection
	    ComboBox<String> firstSideComboBox = new ComboBox<>();
	    firstSideComboBox.getItems().addAll("Opposite", "Adjacent", "Hypotenuse");
	    firstSideComboBox.setValue("Opposite"); // Default selection
	    AnchorPane.setTopAnchor(firstSideComboBox, 90.0);
	    AnchorPane.setLeftAnchor(firstSideComboBox, 10.0);

	    ComboBox<String> secondSideComboBox = new ComboBox<>();
	    secondSideComboBox.getItems().addAll("Opposite", "Adjacent", "Hypotenuse");
	    secondSideComboBox.setValue("Opposite"); // Default selection
	    AnchorPane.setTopAnchor(secondSideComboBox, 130.0);
	    AnchorPane.setLeftAnchor(secondSideComboBox, 10.0);

	    userInputField1 = new TextField();
	    AnchorPane.setTopAnchor(userInputField1, 170.0);
	    AnchorPane.setLeftAnchor(userInputField1, 10.0);

	    userInputField2 = new TextField();
	    AnchorPane.setTopAnchor(userInputField2, 210.0);
	    AnchorPane.setLeftAnchor(userInputField2, 10.0);

	    Button calculateButton = new Button("Calculate Trig Functions");
	    calculateButton.setOnAction(e -> calculateTrigFunction(
	            firstSideComboBox.getValue(),
	            secondSideComboBox.getValue()));
	    AnchorPane.setTopAnchor(calculateButton, 250.0);
	    AnchorPane.setLeftAnchor(calculateButton, 10.0);

	    radianInputField = new TextField();
	    radianInputField.setEditable(false); // Assuming you want to display results only
	    AnchorPane.setTopAnchor(radianInputField, 290.0);
	    AnchorPane.setLeftAnchor(radianInputField, 10.0);

	    // Add components to the root pane
	    root.getChildren().addAll(titleText, instructionText, firstSideComboBox, secondSideComboBox, userInputField1,
	            userInputField2, calculateButton, radianInputField);

	    // Set up the scene
	    Scene scene = new Scene(root, 400, 350);
	    stage.setScene(scene);
	    stage.setTitle("Trigonometric Function Calculator");
	    stage.show();
	}
	

	private void calculateTrigFunction(String firstSideType, String secondSideType) {
	    try {
	        double firstSideLength = Double.parseDouble(userInputField1.getText());
	        double secondSideLength = Double.parseDouble(userInputField2.getText());

	        int firstSideChoice = mapSideTypeToInt(firstSideType);
	        int secondSideChoice = mapSideTypeToInt(secondSideType);
	        
	        System.out.println("First Side Type: " + firstSideType + ", First Side Length: " + firstSideLength);
	        System.out.println("Second Side Type: " + secondSideType + ", Second Side Length: " + secondSideLength);

	        double opposite = 0;
	        double adjacent = 0;
	        double hypotenuse = 0;

	        // gets the first given side and sets it to first side length according to the side type
	        switch (firstSideChoice) {
	            case 1:
	                opposite = firstSideLength;
	                break;
	            case 2:
	                adjacent = firstSideLength;
	                break;
	            case 3:
	                hypotenuse = firstSideLength;
	                break;
	            default:
	                radianInputField.setText("Invalid choice");
	                return;
	        }

	        // gets the second given side and sets it to second side length according to the side type
	        switch (secondSideChoice) {
	            case 1:
	                opposite = secondSideLength;
	                break;
	            case 2:
	                adjacent = secondSideLength;
	                break;
	            case 3:
	                hypotenuse = secondSideLength;
	                break;
	            default:
	                radianInputField.setText("Invalid choice");
	                return;
	        }

	        // Check if either opposite or adjacent is non-zero for calculations
	        if (opposite == 0 && adjacent == 0) {
	            radianInputField.setText("Invalid input: Either Opposite or Adjacent should be non-zero");
	            return;
	        }

	        // Calculate trigonometric functions using the correct sides
	        BigDecimal sinTheta = BigDecimal.valueOf(opposite / hypotenuse);
	        BigDecimal cosTheta = BigDecimal.valueOf(adjacent / hypotenuse);
	        BigDecimal tanTheta = BigDecimal.valueOf(opposite / adjacent);
	        BigDecimal cscTheta = BigDecimal.ONE.divide(sinTheta);
	        BigDecimal secTheta = BigDecimal.ONE.divide(cosTheta);
	        BigDecimal cotTheta = BigDecimal.ONE.divide(tanTheta);

	        // Print the results
	        radianInputField.setText("Trigonometric functions as decimals:\n" +
	                "Sine: " + sinTheta + "\n" +
	                "Cosine: " + cosTheta + "\n" +
	                "Tangent: " + tanTheta + "\n" +
	                "Cosecant: " + cscTheta + "\n" +
	                "Secant: " + secTheta + "\n" +
	                "Cotangent: " + cotTheta);
	    } catch (NumberFormatException e) {
	        radianInputField.setText("Invalid input: Please enter valid numbers");
	    }
	}
	
	// Method to map side type to integer
	private int mapSideTypeToInt(String sideType) {
	    switch (sideType) {
	        case "Opposite":
	            return 1;
	        case "Adjacent":
	            return 2;
	        case "Hypotenuse":
	            return 3;
	        default:
	            return -1; // Invalid choice
	    }
	}


    // Method to convert degrees to radians

	private double convertDegreesToRadians(double degrees) {
		return degrees * Math.PI / 180;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
