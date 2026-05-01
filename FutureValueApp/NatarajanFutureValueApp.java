package FutureValueApp;

/*
    Natarajan, C. (2026). CIS 505 Intermediate Java Programming.
        Bellevue University.
*/

/**
 * Represents a JavaFX application that calculates the future value of an
 * investment based on monthly payment, interest rate, and number of years.
 */

import javafx.application.Application;
import javafx.geometry.HPos;
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
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class NatarajanFutureValueApp extends Application {

    // Purpose: Stores the text field for the monthly payment input.
    private TextField gTxtMonthlyPayment = new TextField();

    // Purpose: Stores the text field for the interest rate input.
    private TextField gTxtInterestRate = new TextField();

    // Purpose: Stores the text area for displaying the future value result.
    private TextArea gTxtAreaResult = new TextArea();

    // Purpose: Stores the label for the monthly payment field.
    private Label gLblMonthlyPayment = new Label("Monthly Payment:");

    // Purpose: Stores the label for the interest rate field.
    private Label gLblInterestRate = new Label("Interest Rate:");

    // Purpose: Stores the label that displays the interest rate format hint.
    private Label gLblInterestRateFormat = new Label("Enter 11.1% as 11.1");

    // Purpose: Stores the label for the years combo box.
    private Label gLblYears = new Label("Years:");

    // Purpose: Stores the label for the result text area.
    private Label gLblResult = new Label("Future Value:");

    // Purpose: Stores the combo box for selecting the number of years.
    private ComboBox<Integer> gCboYears = new ComboBox<>();

    // Purpose: Stores the button that clears all input and output fields.
    private Button gBtnClear = new Button("Clear");

    // Purpose: Stores the button that triggers the future value calculation.
    private Button gBtnCalculate = new Button("Calculate");

    // Purpose:  Serves as the entry point for the JavaFX application.
    // Input:    primaryStage - the primary Stage object provided by JavaFX.
    // Output:   None.
    @Override
    public void start(Stage primaryStage) {

        // Purpose: Creates a new GridPane layout pane for organizing the controls.
        GridPane lPane = new GridPane();

        // Purpose: Sets the alignment of the grid pane to the center of the scene.
        lPane.setAlignment(Pos.CENTER);

        // Purpose: Sets the padding of the grid pane with specific insets on each side.
        lPane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));

        // Purpose: Sets the horizontal gap between columns in the grid pane.
        lPane.setHgap(5.5);

        // Purpose: Sets the vertical gap between rows in the grid pane.
        lPane.setVgap(5.5);

        // Purpose: Adds the monthly payment label to the grid pane at column 0, row 0.
        lPane.add(gLblMonthlyPayment, 0, 0);

        // Purpose: Adds the monthly payment text field to the grid pane at column 1, row 0.
        lPane.add(gTxtMonthlyPayment, 1, 0);

        // Purpose: Adds the interest rate label to the grid pane at column 0, row 1.
        lPane.add(gLblInterestRate, 0, 1);

        // Purpose: Adds the interest rate text field to the grid pane at column 1, row 1.
        lPane.add(gTxtInterestRate, 1, 1);

        // Purpose: Sets the text fill of the interest rate format label to red.
        gLblInterestRateFormat.setTextFill(Color.RED);

        // Purpose: Adds the interest rate format label to the grid pane at column 1, row 2.
        lPane.add(gLblInterestRateFormat, 1, 2);

        // Purpose: Aligns the interest rate format label to the right within its cell.
        GridPane.setHalignment(gLblInterestRateFormat, HPos.RIGHT);

        // Purpose: Adds the years label to the grid pane at column 0, row 3.
        lPane.add(gLblYears, 0, 3);

        // Purpose: Adds the years combo box to the grid pane at column 1, row 3.
        lPane.add(gCboYears, 1, 3);

        // Purpose: Creates an HBox container to hold the clear and calculate buttons.
        HBox lActionBtnContainer = new HBox();

        // Purpose: Sets the padding of the button container with specific insets.
        lActionBtnContainer.setPadding(new Insets(15, 0, 15, 30));

        // Purpose: Sets the spacing between buttons in the container to 10.
        lActionBtnContainer.setSpacing(10);

        // Purpose: Adds the clear button to the button container.
        lActionBtnContainer.getChildren().add(gBtnClear);

        // Purpose: Adds the calculate button to the button container.
        lActionBtnContainer.getChildren().add(gBtnCalculate);

        // Purpose: Adds the button container to the grid pane at column 1, row 4.
        lPane.add(lActionBtnContainer, 1, 4);

        // Purpose: Adds the result label to the grid pane at column 0, row 5.
        lPane.add(gLblResult, 0, 5);

        // Purpose: Adds the result text area to the grid pane spanning both columns at row 6.
        lPane.add(gTxtAreaResult, 0, 6, 2, 1);

        // Purpose: Creates a new scene with the grid pane as the root node.
        Scene lScene = new Scene(lPane);

        // Purpose: Sets the title of the primary stage to the application name.
        primaryStage.setTitle("Natarajan Future Value App");

        // Purpose: Sets the scene on the primary stage for display.
        primaryStage.setScene(lScene);

        // Purpose: Displays the primary stage window to the user.
        primaryStage.show();
    }

    // Purpose:  Launches the JavaFX application.
    // Input:    args - command-line arguments passed to the application.
    // Output:   None.
    public static void main(String[] args) {
        launch(args);
    }
}