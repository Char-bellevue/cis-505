package Module_8;

/*
    Natarajan, C. (2026). CIS 505 Intermediate Java Programming.
        Bellevue University.
*/

/**
 * Represents an enhanced JavaFX application that calculates the future value
 * of an investment based on monthly payment, interest rate, and number of years.
 * Extends the base FutureValueApp with calculation and clear functionality.
 */

import java.text.SimpleDateFormat;
import java.util.Date;
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

public class NatarajanEnhancedFutureValueApp extends Application {

    // Purpose: Stores the text field for the monthly payment input.
    private TextField gTxtMonthlyPayment = new TextField();

    // Purpose: Stores the text field for the interest rate input.
    private TextField gTxtInterestRate = new TextField();

    // Purpose: Stores the text area for displaying the future value result.
    private TextArea gTxtResults = new TextArea();

    // Purpose: Stores the label for the monthly payment field.
    private Label gLblMonthlyPayment = new Label("Monthly Payment:");

    // Purpose: Stores the label for the interest rate field.
    private Label gLblInterestRate = new Label("Interest Rate:");

    // Purpose: Stores the label that displays the interest rate format hint.
    private Label gLblInterestRateFormat = new Label("Enter 11.1% as 11.1");

    // Purpose: Stores the label for the years combo box.
    private Label gLblYears = new Label("Years:");

    // Purpose: Stores the label that displays the future value calculation date.
    private Label gLblFutureValueDate = new Label("");

    // Purpose: Stores the combo box for selecting the number of years.
    private ComboBox<Integer> gCbYears = new ComboBox<>();

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

        // Purpose: Populates the years combo box with values from 1 to 25.
        for (int lYear = 1; lYear <= 25; lYear++) {
            gCbYears.getItems().add(lYear);
        }

        // Purpose: Adds the years combo box to the grid pane at column 1, row 3.
        lPane.add(gCbYears, 1, 3);

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

        // Purpose: Adds the future value date label to the grid pane at column 0, row 5.
        lPane.add(gLblFutureValueDate, 0, 5, 2, 1);

        // Purpose: Adds the results text area to the grid pane at column 0, row 6.
        lPane.add(gTxtResults, 0, 6, 2, 1);

        // Purpose: Sets the clear button action to call the clearFormFields method.
        gBtnClear.setOnAction(e -> clearFormFields());

        // Purpose: Sets the calculate button action to call the calculateResults method.
        gBtnCalculate.setOnAction(e -> calculateResults());

        // Purpose: Creates a new scene with the grid pane as the root node.
        Scene lScene = new Scene(lPane);

        // Purpose: Sets the title of the primary stage to the application name.
        primaryStage.setTitle("Natarajan Future Value App");

        // Purpose: Sets the scene on the primary stage for display.
        primaryStage.setScene(lScene);

        // Purpose: Displays the primary stage window to the user.
        primaryStage.show();
    }

    // Purpose:  Clears all form fields and resets the combo box to its default state.
    // Input:    None.
    // Output:   None.
    private void clearFormFields() {

        // Purpose: Clears the monthly payment text field by setting its text to empty.
        gTxtMonthlyPayment.setText("");

        // Purpose: Clears the interest rate text field by setting its text to empty.
        gTxtInterestRate.setText("");

        // Purpose: Clears the results text area by setting its text to empty.
        gTxtResults.setText("");

        // Purpose: Clears the future value date label by setting its text to empty.
        gLblFutureValueDate.setText("");

        // Purpose: Resets the years combo box value to zero.
        gCbYears.setValue(0);
    }

    // Purpose:  Collects user input values and calculates the future value by calling
    //           the FinanceCalculator class, then displays the result and today's date.
    // Input:    None.
    // Output:   None.
    private void calculateResults() {

        // Purpose: Retrieves the monthly payment value entered by the user.
        double lMonthlyPayment = Double.parseDouble(gTxtMonthlyPayment.getText());

        // Purpose: Retrieves the interest rate value entered by the user.
        double lRate = Double.parseDouble(gTxtInterestRate.getText());

        // Purpose: Retrieves the number of years selected by the user.
        int lYears = gCbYears.getValue();

        // Purpose: Calls the FinanceCalculator to compute the future value.
        double lFutureValue = FinanceCalculator.calculateFutureValue(lMonthlyPayment, lRate, lYears);

        // Purpose: Sets the future value date label to show today's date.
        gLblFutureValueDate.setText("Calculation as of " + getTodaysDate());

        // Purpose: Sets the results text area to display the calculated future value.
        gTxtResults.setText("The future value is $" + String.format("%,.2f", lFutureValue));
    }

    // Purpose:  Returns today's date formatted as MM/dd/yyyy using SimpleDateFormat.
    // Input:    None.
    // Output:   Returns today's date as a formatted String.
    private String getTodaysDate() {

        // Purpose: Creates a SimpleDateFormat object with the MM/dd/yyyy pattern.
        SimpleDateFormat lDateFormat = new SimpleDateFormat("MM/dd/yyyy");

        // Purpose: Returns today's date formatted as a string.
        return lDateFormat.format(new Date());
    }

    // Purpose:  Launches the JavaFX application.
    // Input:    args - command-line arguments passed to the application.
    // Output:   None.
    public static void main(String[] args) {
        launch(args);
    }
}