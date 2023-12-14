package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Controller class for handling trigonometry lessons in a GUI application.
 */
public class LearnLessonController extends TrigMenu {

    // Define the file directory
    private static final String FILE_DIRECTORY = "C:" + File.separator + "Users" + File.separator + "asalg" + File.separator
            + "eclipse-workspace" + File.separator + "TrigMenuGui" + File.separator + "src" + File.separator + "lesson_files";

    /**
     * Switches to the Learn Lesson view, allowing the user to choose and display trigonometry lessons.
     *
     * @param stage     The primary stage of the application.
     * @param textArea  The TextArea where lesson content will be displayed.
     * @param fileName  The initial lesson file to display.
     */
    public void switchToLearnLessonController(Stage stage, TextArea textArea, String fileName) {
        System.out.println("Switching to Learn Lesson...");

        AnchorPane root = new AnchorPane();

        Text titleText = new Text("Trig Lesson Options");
        titleText.setLayoutY(53.0);
        titleText.setFont(new Font("Goudy Old Style Bold", 42.0));

        // Create a ChoiceBox for lesson selection
        ChoiceBox<String> lessonChoiceBox = new ChoiceBox<>(FXCollections.observableArrayList(
                "Angles in degrees and radians", "Converting between degrees and radians",
                "Calculating arc length and area of sector", "Trig Functions from right triangles"));
        lessonChoiceBox.setLayoutX(21.0);
        lessonChoiceBox.setLayoutY(100.0);

        Text clickOptionText = new Text("Click an option:");
        clickOptionText.setLayoutX(-7.0);
        clickOptionText.setLayoutY(140.0);
        clickOptionText.setFont(new Font("Goudy Old Style Bold", 19.0));

        // Create a Button to display the selected lesson
        Button displayButton = new Button("Display Lesson");
        displayButton.setLayoutX(21.0);
        displayButton.setLayoutY(170.0);

        // Updated ActionListener to display the lesson text
        displayButton.setOnAction(e -> switchToSelectedLesson(textArea, lessonChoiceBox.getValue(), stage));

        root.getChildren().addAll(titleText, lessonChoiceBox, clickOptionText, displayButton);

        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Trig Lesson Options");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Represents a trigonometry lesson with a name and a corresponding file.
     */
    public class Lesson {
        private String name;
        private String fileName;

        public Lesson(String name, String fileName) {
            this.name = name;
            this.fileName = fileName;
        }

        public String getName() {
            return name;
        }

        public String getFileName() {
            return fileName;
        }
    }

    /**
     * Retrieves a Lesson object based on the provided lesson name.
     *
     * @param lesson The name of the lesson.
     * @return The corresponding Lesson object.
     */
    private Lesson getLessonByName(String lesson) {
        switch (lesson) {
            case "Angles in degrees and radians":
                return new Lesson(lesson, "AnglesInDegreesAndRadians.txt.txt");
            case "Converting between degrees and radians":
                return new Lesson(lesson, "ConvertingBetweenDegreesAndRadians.txt");
            case "Calculating arc length and area of sector":
                return new Lesson(lesson, "CalculatingArcLengthAndArea.txt");
            case "Trig Functions from right triangles":
                return new Lesson(lesson, "TrigFunctionsFromRightTriangles.txt");
            default:
                throw new IllegalArgumentException("Invalid lesson: " + lesson);
        }
    }

    /**
     * Displays the selected lesson in a separate stage with a scrollable TextArea.
     *
     * @param textArea     The TextArea to display the lesson content.
     * @param lesson       The name of the selected lesson.
     * @param primaryStage The primary stage of the application.
     */
    private void switchToSelectedLesson(TextArea textArea, String lesson, Stage primaryStage) {
        System.out.println("Switching to " + lesson + "...");
        try {
            Lesson selectedLesson = getLessonByName(lesson);
            String fileName = selectedLesson.getFileName();
            System.out.println("File Name: " + fileName);
            String filePath = FILE_DIRECTORY + File.separator + fileName;

            // Create a new stage for displaying the lesson content
            Stage lessonStage = new Stage();
            lessonStage.setTitle(lesson);

            // Create a ScrollPane and TextArea to display the lesson content
            ScrollPane scrollPane = new ScrollPane();
            TextArea lessonTextArea = new TextArea();
            lessonTextArea.setEditable(false); // Set to true if you want to allow editing
            scrollPane.setContent(lessonTextArea);

            // Load and set the lesson content to the TextArea
            loadLessonContent(lessonTextArea, filePath);

            // Create a scene and set it on the stage
            Scene lessonScene = new Scene(scrollPane, 800, 600);
            lessonStage.setScene(lessonScene);
            lessonStage.initOwner(primaryStage); // Set the owner stage
            lessonStage.initModality(Modality.WINDOW_MODAL); // Set modality to WINDOW_MODAL
            lessonStage.showAndWait(); // Show and wait for the lesson stage
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid lesson: " + lesson);
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error switching to lesson: " + lesson);
            e.printStackTrace();
        }
    }

    /**
     * Loads the content of a lesson file into a TextArea.
     *
     * @param lessonTextArea The TextArea to load the content into.
     * @param filePath       The path of the lesson file.
     */
    private void loadLessonContent(TextArea lessonTextArea, String filePath) {
        System.out.println("Loading file: " + filePath);
        try {
            File file = new File(filePath);

            if (file.exists()) {
                System.out.println("File exists: " + file.getAbsolutePath());
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    StringBuilder content = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        content.append(line).append("\n");
                    }
                    lessonTextArea.setText(content.toString());
                }
            } else {
                System.err.println("File not found: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays the content of a lesson file in the provided TextArea.
     *
     * @param textArea The TextArea to display the lesson content.
     * @param fileName The name of the lesson file.
     */
    public void displayLesson(TextArea textArea, String fileName) {
        System.out.println("Loading file: " + fileName);
        try {
            File file = new File(FILE_DIRECTORY, fileName);

            if (file.exists()) {
                System.out.println("File exists: " + file.getAbsolutePath()); // Add this line
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    StringBuilder content = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        content.append(line).append("\n");
                    }
                    textArea.setText(content.toString());
                }
            } else {
                System.err.println("File not found: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
