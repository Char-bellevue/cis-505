package Capstone;

/*
 * Natarajan, C. (2026). GradeBookApp Sprint 2 User Interface [Java source code].
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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * This class creates the GradeBookApp graphical user interface and handles
 * all user interaction events for saving, clearing, and viewing grade entries.
 * Input: User interaction with the graphical interface.
 * Output: Display of the GradeBookApp user interface window and results area feedback.
 */
public class NatarajanGradeBookApp extends Application {

    // Global constant for the application window width in pixels.
    private final int WINDOW_WIDTH = 650;

    // Global constant for the application window height in pixels.
    private final int WINDOW_HEIGHT = 550;

    // Global constant for the CSV file name used to store grade records.
    private final String CSV_FILE_NAME = "grades.csv";

    // Global constant for the CSV header row matching the required column format.
    private final String CSV_HEADER = "firstName,lastName,course,grade";

    /*
     * This method builds and displays the JavaFX application window.
     * Input: JavaFX primary stage object provided by the runtime.
     * Output: Fully rendered and interactive user interface window shown on screen.
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

        // This section attaches the Save button event handler.
        lSaveButton.setOnAction(lEvent ->
                handleSave(lFirstNameField,
                           lLastNameField,
                           lCourseField,
                           lGradeComboBox,
                           lResultsArea)
        );

        // This section attaches the Clear button event handler.
        lClearButton.setOnAction(lEvent ->
                handleClear(lFirstNameField,
                            lLastNameField,
                            lCourseField,
                            lGradeComboBox,
                            lResultsArea)
        );

        // This section attaches the View Grades button event handler.
        lViewButton.setOnAction(lEvent ->
                handleViewGrades(lResultsArea)
        );

        // This section creates the JavaFX scene with the root layout and window dimensions.
        Scene lScene = new Scene(
                lRoot,
                WINDOW_WIDTH,
                WINDOW_HEIGHT
        );

        // This section configures the stage title, attaches the scene, and displays the window.
        lPrimaryStage.setTitle("GradeBookApp - Sprint 2");
        lPrimaryStage.setScene(lScene);
        lPrimaryStage.show();
    }

    /*
     * This method handles the Save Grade Entry button click event.
     * It reads all four form fields, validates that none are empty,
     * creates a Student object, and writes the record to grades.csv.
     * Input: All four form field controls and the results TextArea.
     * Output: Confirmation or error message displayed in the results area;
     *         new record appended to grades.csv on disk.
     */
    private void handleSave(TextField lFirstNameField,
                            TextField lLastNameField,
                            TextField lCourseField,
                            ComboBox<String> lGradeComboBox,
                            TextArea lResultsArea) {

        // This section reads the current values from each form field.
        String lFirstName = lFirstNameField.getText().trim();
        String lLastName  = lLastNameField.getText().trim();
        String lCourse    = lCourseField.getText().trim();
        String lGrade     = lGradeComboBox.getValue();

        // This section validates that all four fields have been filled in before saving.
        if (lFirstName.isEmpty() || lLastName.isEmpty()
                || lCourse.isEmpty() || lGrade == null) {
            lResultsArea.setText("All fields must be filled in before saving.");
            return;
        }

        // This section creates a Student object using the parameterized constructor.
        Student lStudent = new Student(lFirstName, lLastName, lCourse, lGrade);

        // This section determines whether the file already exists before opening it,
        // so the header row is written only once when a new file is created.
        File lCsvFile       = new File(CSV_FILE_NAME);
        boolean lIsNewFile  = !lCsvFile.exists() || lCsvFile.length() == 0;

        // This section writes the student record to grades.csv in append mode.
        try (BufferedWriter lWriter =
                     new BufferedWriter(new FileWriter(lCsvFile, true))) {

            if (lIsNewFile) {
                lWriter.write(CSV_HEADER);
                lWriter.newLine();
            }

            lWriter.write(lStudent.toString());
            lWriter.newLine();

            lResultsArea.setText(
                    "Grade entry saved successfully:\n  "
                    + lFirstName + " " + lLastName
                    + " | " + lCourse + " | " + lGrade
            );

        } catch (IOException lException) {
            lResultsArea.setText(
                    "Error saving grade entry: " + lException.getMessage()
            );
        }
    }

    /*
     * This method handles the Clear Form button click event.
     * It resets all form fields to their default empty state simultaneously.
     * Input: All four form field controls and the results TextArea.
     * Output: All form fields and the results area are cleared.
     */
    private void handleClear(TextField lFirstNameField,
                             TextField lLastNameField,
                             TextField lCourseField,
                             ComboBox<String> lGradeComboBox,
                             TextArea lResultsArea) {

        // This section clears each text field and resets the ComboBox to its unselected state.
        lFirstNameField.clear();
        lLastNameField.clear();
        lCourseField.clear();
        lGradeComboBox.setValue(null);
        lGradeComboBox.setPromptText("Select Grade");
        lResultsArea.clear();
    }

    /*
     * This method handles the View Grades button click event.
     * It opens grades.csv and displays every line in the results area.
     * If the file does not exist or is empty, a friendly message is shown instead.
     * Input: The results TextArea control.
     * Output: All saved grade records displayed in the results area,
     *         or an informational message if no records exist yet.
     */
    private void handleViewGrades(TextArea lResultsArea) {

        File lCsvFile = new File(CSV_FILE_NAME);

        // This section handles the case where the file has not been created yet.
        if (!lCsvFile.exists()) {
            lResultsArea.setText("No grade records found. Save an entry first.");
            return;
        }

        // This section reads every line from grades.csv and builds the display string.
        StringBuilder lDisplayText = new StringBuilder();

        try (BufferedReader lReader =
                     new BufferedReader(new FileReader(lCsvFile))) {

            String lLine = lReader.readLine();

            // This section handles an empty file with no content written to it.
            if (lLine == null) {
                lResultsArea.setText("No grade records found. Save an entry first.");
                return;
            }

            // This section appends every line from the file including the header row.
            while (lLine != null) {
                lDisplayText.append(lLine).append("\n");
                lLine = lReader.readLine();
            }

            lResultsArea.setText(lDisplayText.toString());

        } catch (IOException lException) {
            lResultsArea.setText(
                    "Error reading grade records: " + lException.getMessage()
            );
        }
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