package Capstone;

/*
 * Natarajan, C. (2026). GradeBookApp Sprint 1 User Interface [Java source code].
 * Bellevue University.
 * CIS505-T301 Intermediate Java Programming.
 *
 * References
 * Liang, Y. D. (2019). Introduction to Java programming and data structures,
 *     comprehensive version (12th ed.). Pearson.
 * Oracle. (2024). JavaFX documentation.
 *     https://openjfx.io/
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/*
 * This class creates the GradeBookApp graphical user interface.
 * Input: User interaction with the graphical interface.
 * Output: Display of the GradeBookApp user interface window.
 */
public class NatarajanGradeBookApp extends Application {

    // Global constant for the application window width in pixels.
    private final int WINDOW_WIDTH = 650;

    // Global constant for the application window height in pixels.
    private final int WINDOW_HEIGHT = 550;

    /*
     * This method builds and displays the JavaFX application window.
     * Input: JavaFX primary stage object provided by the runtime.
     * Output: Fully rendered user interface window shown on screen.
     */
    @Override
    public void start(Stage lPrimaryStage) {

        // This section creates the application title label.
        Label lTitleLabel = new Label("GradeBook Application");
        lTitleLabel.setFont(new Font("Arial", 24));

        // This section creates labels for each student form field.
        Label lFirstNameLabel = new Label("First Name:");
        Label lLastNameLabel  = new Label("Last Name:");
        Label lCourseLabel    = new Label("Course:");
        Label lGradeLabel     = new Label("Grade:");

        // This section creates text fields for first name, last name, and course input.
        TextField lFirstNameField = new TextField();
        lFirstNameField.setPromptText("Enter first name");

        TextField lLastNameField = new TextField();
        lLastNameField.setPromptText("Enter last name");

        TextField lCourseField = new TextField();
        lCourseField.setPromptText("Enter course name");

        // This section creates the grade selection ComboBox with valid grade options.
        ComboBox<String> lGradeComboBox = new ComboBox<>();
        lGradeComboBox.getItems().addAll("A", "B", "C", "D", "F");
        lGradeComboBox.setPromptText("Select Grade");

        // This section creates the three action buttons for the application.
        Button lSaveButton  = new Button("Save Grade Entry");
        Button lClearButton = new Button("Clear Form");
        Button lViewButton  = new Button("View Grades");

        lSaveButton.setPrefWidth(140);
        lClearButton.setPrefWidth(140);
        lViewButton.setPrefWidth(140);

        // This section creates the results area label and display field.
        Label lResultsLabel = new Label("Results Area:");

        TextArea lResultsArea = new TextArea();
        lResultsArea.setEditable(false);
        lResultsArea.setPrefHeight(200);
        lResultsArea.setWrapText(true);

        // This section creates the GridPane layout and sets its spacing.
        GridPane lFormGrid = new GridPane();
        lFormGrid.setPadding(new Insets(20));
        lFormGrid.setHgap(15);
        lFormGrid.setVgap(15);

        // This section adds each label and input control to the GridPane.
        lFormGrid.add(lFirstNameLabel, 0, 0);
        lFormGrid.add(lFirstNameField, 1, 0);

        lFormGrid.add(lLastNameLabel, 0, 1);
        lFormGrid.add(lLastNameField, 1, 1);

        lFormGrid.add(lCourseLabel, 0, 2);
        lFormGrid.add(lCourseField, 1, 2);

        lFormGrid.add(lGradeLabel, 0, 3);
        lFormGrid.add(lGradeComboBox, 1, 3);

        // This section creates the horizontal button container and centers it.
        HBox lButtonBox = new HBox(15);
        lButtonBox.setAlignment(Pos.CENTER);
        lButtonBox.getChildren().addAll(
                lSaveButton,
                lClearButton,
                lViewButton
        );

        // This section assembles all components into the main vertical layout.
        VBox lRoot = new VBox(20);
        lRoot.setPadding(new Insets(20));
        lRoot.setAlignment(Pos.TOP_CENTER);

        lRoot.getChildren().addAll(
                lTitleLabel,
                lFormGrid,
                lButtonBox,
                lResultsLabel,
                lResultsArea
        );

        // This section creates the JavaFX scene with the root layout and window dimensions.
        Scene lScene = new Scene(
                lRoot,
                WINDOW_WIDTH,
                WINDOW_HEIGHT
        );

        // This section configures the stage title, attaches the scene, and displays the window.
        lPrimaryStage.setTitle("GradeBookApp - Sprint 1");
        lPrimaryStage.setScene(lScene);
        lPrimaryStage.show();
    }

    /*
     * This method serves as the program entry point and launches the JavaFX application.
     * Input: Command-line arguments passed at runtime.
     * Output: Execution of the JavaFX application lifecycle.
     */
    public static void main(String[] lArguments) {
        launch(lArguments);
    }

}