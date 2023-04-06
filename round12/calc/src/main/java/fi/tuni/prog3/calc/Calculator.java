package fi.tuni.prog3.calc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * JavaFX Calculator
 */
public class Calculator extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(Calculator.class.getResource("calculator.fxml"));
        scene = new Scene(loader.load(), 640, 480);
        stage.setScene(scene);
        //set the title of the window
        stage.setTitle("Calculator");
        //show the window
        stage.show();
    }

        
    @FXML
    private TextField fieldOp1;
    @FXML
    private TextField fieldOp2;
    @FXML
    private Label fieldRes;
    
    @FXML
    private void handleAdd(ActionEvent event) {
        double op1 = Double.parseDouble(fieldOp1.getText());
        double op2 = Double.parseDouble(fieldOp2.getText());
        double res = op1 + op2;
        fieldRes.setText(Double.toString(res));
    }

    @FXML
    private void handleSub(ActionEvent event) {
        double op1 = Double.parseDouble(fieldOp1.getText());
        double op2 = Double.parseDouble(fieldOp2.getText());
        double res = op1 - op2;
        fieldRes.setText(Double.toString(res));
    }

    @FXML
    private void handleMul(ActionEvent event) {
        double op1 = Double.parseDouble(fieldOp1.getText());
        double op2 = Double.parseDouble(fieldOp2.getText());
        double res = op1 * op2;
        fieldRes.setText(Double.toString(res));
    }

    @FXML
    private void handleDiv(ActionEvent event) {
        double op1 = Double.parseDouble(fieldOp1.getText());
        double op2 = Double.parseDouble(fieldOp2.getText());
        //check for division by zero
        if (op2 == 0) {
            fieldRes.setText("Division by zero!");
            return;
        }
        double res = op1 / op2;
        fieldRes.setText(Double.toString(res));
    }
    
    public static void main(String[] args) {
        launch();
    }

}