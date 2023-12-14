package application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PracticeController extends Application {

	// Functional interface for problem generation
		@FunctionalInterface
	public interface ProblemGenerator {
	    String[] generateProblem();
	}
	

    private Iterator<String[]> lessonProblemSet;
    private int solvedProblemsCount = 0;

    public void setLessonProblemSet(Iterator<String[]> lessonProblemSet) {
        this.lessonProblemSet = lessonProblemSet;
    }

	public PracticeController PracticeProblem;

	// Switches to the Learn Lesson Controller view
	public Scene switchToLearnLessonController(Stage stage) {
	    PracticeProblem = new PracticeController();
	    stage.setTitle("Trig Practice");

	    // Set the returned scene to the stage
	    Scene scene = createLearnLessonScene();
	    stage.setScene(scene);
	    stage.show();

	    return scene;
	}

	// Creates the Learn Lesson scene
	private Scene createLearnLessonScene() {
	    BorderPane borderPane = new BorderPane();
	    borderPane.setPadding(new Insets(10));

	    // Create lesson selection
	    VBox lessonBox = new VBox(10);
	    lessonBox.setPadding(new Insets(10));
	    Label lessonLabel = new Label("Select a Trig Lesson:");
	    ChoiceBox<String> lessonChoiceBox = new ChoiceBox<>();
	    lessonChoiceBox.getItems().addAll("1. Angles in degrees and radians",
	            "2. Converting between degrees and radians", "3. Calculating arc length and area of sector",
	            "4. Trig Functions from right triangles");
	    lessonChoiceBox.setValue("1. Angles in degrees and radians");
	    Button startButton = new Button("Start Lesson");
	   

	    // Create problem display
	    VBox problemBox = new VBox(5);
	    problemBox.setPadding(new Insets(200, 10, 10, 20));
	    Label problemLabel = new Label();
	    TextField answerField = new TextField();
	    Button submitButton = new Button("Submit Answer");
	    problemBox.getChildren().addAll(lessonLabel, lessonChoiceBox, startButton,problemLabel, answerField, submitButton);

	    // Create progress bar
	    ProgressBar progressBar = new ProgressBar(0);
	    progressBar.setPrefWidth(400);

	    // Add components to the border pane
	    borderPane.setTop(lessonBox);
	    borderPane.setCenter(problemBox);
	    borderPane.setBottom(progressBar);

	    // Event handling
	    startButton.setOnAction(e -> {
	        String lessonChoice = lessonChoiceBox.getValue();
	        int lessonNumber = Integer.parseInt(lessonChoice.substring(0, 1));
	        lessonProblemSet = getLessonProblemSet(lessonNumber);
	        displayNextProblem(problemLabel, answerField, progressBar);
	    });

	    submitButton.setOnAction(e -> {
	        String userAnswer = answerField.getText();
	        
	        // Get the current problem
	        String[] currentProblem = (String[]) getNextProblem();

	        // Ensure that the current problem is not null
	        if (currentProblem != null) {
	            String correctAnswer = currentProblem[1]; // Assuming the correct answer is stored at index 1

	            if (checkAnswer(userAnswer, correctAnswer)) {
	                solvedProblemsCount++;
	                // Handle correct answer
	                displayNextProblem(problemLabel, answerField, progressBar);
	            } else {
	                // Handle incorrect answer
	                System.out.println("Incorrect :(");
	            }
	        } else {
	            // Handle the case where there are no more problems
	            System.out.println("No more problems.");
	        }
	    });
	    return new Scene(borderPane, 1300, 450);
	}

	   
	private boolean checkAnswer(String userAnswer, String correctAnswer) {
		 // Normalize and compare the answers (ignoring case and extra spaces)
        return userAnswer.trim().equalsIgnoreCase(correctAnswer.trim());
		
	}

	private void displayNextProblem(Label problemLabel, TextField answerField, ProgressBar progressBar) {
	    if (lessonProblemSet != null && lessonProblemSet.hasNext()) {
	        String[] problem = lessonProblemSet.next();
	        problemLabel.setText("Problem: " + problem[0]);
	        answerField.clear();
	        progressBar.setProgress(getProgress());
	        solvedProblemsCount++; // Increment the counter
	    } else {
	        problemLabel.setText("Congratulations! You've completed the problem set.");
	        progressBar.setProgress(1.0);
	    }
	}	 
	private Object getNextProblem() {
        if (lessonProblemSet != null && lessonProblemSet.hasNext()) {
            String[] problemGenerator = lessonProblemSet.next();
            return problemGenerator.length;
        }
        return null;  // No more problems
    }

	 private double getProgress() {
		    if (lessonProblemSet != null) {
		        int totalProblems = getTotalProblems();
		        int solvedProblems = getSolvedProblems();
		        if (totalProblems > 0) {
		            return (double) solvedProblems / totalProblems;
		        }
		    }
		    return 0.0;
		}
	 
	 private int getTotalProblems() {
		    if (lessonProblemSet != null) {
		        int count = 0;
		        // Iterate through the iterator to count the number of problems
		        while (lessonProblemSet.hasNext()) {
		            lessonProblemSet.next();
		            count++;
		        }
		        // Reset the iterator to its initial state
		        lessonProblemSet = getLessonProblemSet(count);
		        return count;
		    }
		    return 0;
		}

	    private int getSolvedProblems() {
	    	return solvedProblemsCount;
	    }


	
	private Iterator<String[]> getLessonProblemSet(int lessonNumber) {
	    switch (lessonNumber) {
	        case 1:
	            return PracticeProblem.generateAnglesInDegreesAndRadiansProblem();
	        case 2:
	            return PracticeProblem.generateConvertingBetweenDegreesAndRadiansProblem1();
	        case 3:
	            return PracticeProblem.generateArcLengthProblem();
	        case 4:
	            return PracticeProblem.generateAreaOfSectorProblem();
	        default:
	            return null;
	    }
	}

	public Iterator<String[]> generateAnglesInDegreesAndRadiansProblem() {
		List<String[]> problems = new ArrayList<>();

		// Problem 1
		String problem1 = "Find 1 positive and 1 negative cotermial of 45 degrees, below type the NUMBER Degrees. Write the degrees after your number with a space. Ex: 35 Degrees, -67 Degrees";
		String correctAnswer1 = "405 degrees, -315 degrees";
		problems.add(new String[] { problem1, correctAnswer1 });

		// Problem 2
		String problem2 = "Find 1 positive and 1 negative cotermial of 3pi/4 radians, below type the answer in exact value. Ex: pi/2, 4pi/6, 1/2, 11pi/3";
		String correctAnswer2 = "7pi/4, -pi/4";
		problems.add(new String[] { problem2, correctAnswer2 });

		// Problem 3
		String problem3 = "For the angle of 32.16 degrees, find the complementary angle. Insert the number rounded to the nearest hundredth. Write the degrees after your number with a space. Example: 120.45 degrees";
		String correctAnswer3 = "57.84 degrees";
		problems.add(new String[] { problem3, correctAnswer3 });

		// Problem 4
		String problem4 = "For the angle of 11pi/6, find the complementary angle. Type the answer in exact value. Example: pi/2, 4pi/6, 1/2, 11pi/3";
		String correctAnswer4 = "pi/3";
		problems.add(new String[] { problem4, correctAnswer4 });

		// Problem 5
		String problem5 = "For the angle of 21.45 degrees, find the complementary angle. Insert the number rounded to the nearest hundredth. Write the degrees after your number with a space. Example: 120.45 degrees";
		String correctAnswer5 = "68.55 degrees";
		problems.add(new String[] { problem5, correctAnswer5 });

		// Problem 6
		String problem6 = "Find the supplementary angle for 5pi/6. Type the answer in exact value. Example: pi/2, 4pi/6, 1/2, 11pi/3";
		String correctAnswer6 = "pi/6";
		problems.add(new String[] { problem6, correctAnswer6 });

		// Problem 7
		String problem7 = "Find the supplementary angle for 35.23 degrees Type the answer in exact value. Example: pi/2, 4pi/6, 1/2, 11pi/3";
		String correctAnswer7 = "144.77";
		problems.add(new String[] { problem7, correctAnswer7 });

		return problems.iterator();
	}

	// Method to generate problems related to converting between degrees and radians
	public Iterator<String[]> generateConvertingBetweenDegreesAndRadiansProblem1() {

		List<String[]> problems = new ArrayList<>();

		// Problem 1
		String problem1 = "Convert 90 degrees to radians. Type the answer in exact value. Example: pi/2, 4pi/6, 1/2, 11pi/3";
		String correctAnswer1 = "pi/2";
		problems.add(new String[] { problem1, correctAnswer1 });

		// Problem 2
		String problem2 = "Convert 495 degrees to radians. Type the answer in exact value. Example: pi/2, 4pi/6, 1/2, 11pi/3 ";
		String correctAnswer2 = "11pi/4";
		problems.add(new String[] { problem2, correctAnswer2 });

		// Problem 3
		String problem3 = "Convert -5pi/6 radians to degrees. Insert the number rounded to the nearest hundredth if needed. Write the degrees after your number with a space Example: -68 degrees";
		String correctAnswer3 = "-150 degrees";
		problems.add(new String[] { problem3, correctAnswer3 });

		// Problem 4
		String problem4 = "Convert 3pi/2 radians to degrees. Insert the number rounded to the nearest hundredth if needed. Write the degrees after your number with a space Example: -68 degrees";
		String correctAnswer4 = "3pi/2";
		problems.add(new String[] { problem4, correctAnswer4 });

		return problems.iterator();
	}

	// Method to generate problems related to arc length
	public Iterator<String[]> generateArcLengthProblem() {

		List<String[]> problems = new ArrayList<>();

		// Problem 1
		String problem1 = "Find the arc length of a circle with a radius of 4 units and a central angle of 45 degrees. Write the number with it's unit. Example: 3pi inches, pi/2 units, 3pi/4 meters";
		String correctAnswer1 = "2pi units";
		problems.add(new String[] { problem1, correctAnswer1 });

		// Problem 2
		String problem2 = "Find the arc length of a circle with a radius of 6 units and a central angle of 3π/4 radians. Write the number with it's unit. Example: 3pi inches, pi/2 units, 3pi/4 meters";
		String correctAnswer2 = "9pi/4 units";
		problems.add(new String[] { problem2, correctAnswer2 });

		// Problem 3
		String problem3 = "Find the arc length of a circle with a radius of 10 units and a central angle of 120 degrees. Write the number with it's unit. Example: 3pi inches, pi/2 units, 3pi/4 meters";
		String correctAnswer3 = "2pi/3 units";
		problems.add(new String[] { problem3, correctAnswer3 });

		// Problem 4
		String problem4 = "A circle has a radius of 10 inches, and the central angle is 60 degrees. Find the arc length. Write the number with it's unit. Example: 3pi inches, pi/2 units, 3pi/4 meters";
		String correctAnswer4 = "10pi inches";
		problems.add(new String[] { problem4, correctAnswer4 });

		return problems.iterator();
	}

	// Method to generate problems related to the area of a sector
	public Iterator<String[]> generateAreaOfSectorProblem() {

		List<String[]> problems = new ArrayList<>();

		// Problem 1
		String problem1 = "Calculate the area of a sector with a central angle of 60 degrees and a radius of 8 units. Provide your answer rounded to two decimal places. Example. 23.44";
		String correctAnswer1 = "16.75";
		problems.add(new String[] { problem1, correctAnswer1 });

		// Problem 2
		String problem2 = "Calculate the area of a sector with a central angle of π/3 radians and a radius of 6 units. Provide your answer rounded to two decimal places.";
		String correctAnswer2 = "6.28";
		problems.add(new String[] { problem2, correctAnswer2 });

		// Problem 3
		String problem3 = "Calculate the area of a sector with a central angle of 45 degrees and a radius of 10 units. Provide your answer rounded to two decimal places.";
		String correctAnswer3 = "7.07";
		problems.add(new String[] { problem3, correctAnswer3 });

		// Problem 4
		String problem4 = "Calculate the area of a sector with a central angle of 60 degrees and a radius of √3 units. Provide your answer in terms of π";
		String correctAnswer4 = "pi/3";
		problems.add(new String[] { problem4, correctAnswer4 });

		return problems.iterator();
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
	

