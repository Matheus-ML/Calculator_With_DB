package com.example.calculadorakz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class HelloController {
    double numberOne = 0;
    double numberTwo = 0;
    String operationMath = "";
    String operationSQ;
    CalculatorController controller = new CalculatorController();


    @FXML
    void buttonHistoric(ActionEvent event) {
        TextArea text = new TextArea();
        text.setEditable(false);
        text.setWrapText(true);
        text.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-font-family: 'Arial';");
        text.setText(FunctionDB.getHistoric());

        Scene scene = new Scene(text, 250, 300);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private TextField posteriorNumber;

    @FXML
    private TextField txtResults;

    @FXML
    void buttonBackspace(ActionEvent event) {
        try {
            String text = txtResults.getText();
            String backspace = text.substring(0, text.length() - 1);
            txtResults.setText(backspace);
        } catch (StringIndexOutOfBoundsException e) {
            setNullTxt();
        }
    }

    @FXML
    void buttonC(ActionEvent event) {
        setNullTxt();
        posteriorNumber.setText("");
        clearAtributes();
    }

    @FXML
    void buttonPercent(ActionEvent event) {
        numberTwo = Double.parseDouble(txtResults.getText());

        if (operationMath.equals("/") && numberTwo == 0) {
            alert("Error", "Zero não pode ser o Divisor, escolha outro número!");
            setNullTxt();
            return;
        }
        txtResults.setText(String.valueOf(controller.calcularPerCent(numberOne, numberTwo, operationMath)));
        posteriorNumber.setText((numberOne) + operationMath + numberTwo + "%");
    }

    @FXML
    void buttonEqual(ActionEvent event) {
        numberTwo = Double.parseDouble(txtResults.getText());

        if (operationMath.equals("/") && numberTwo == 0) {
            alert("Error", "Zero não pode ser o Divisor, escolha outro número!");
            return;
        }
        txtResults.setText(String.valueOf(controller.calcular(numberOne, numberTwo, operationMath)));
        posteriorNumber.setText((numberOne) + operationMath + numberTwo + "=");
        FunctionDB.input(txtResults.getText(), posteriorNumber.getText());
        clearAtributes();
    }

    @FXML
    void buttonPow(ActionEvent event) {
        operationSQ = "x²";
        if (operationMath.isEmpty()) {
            converse();
            posteriorNumber.setText(numberOne + "²");
            txtResults.setText(String.valueOf(controller.calcularSQ(numberOne, operationSQ)));
            clearAtributes();
        } else {
            numberOne = Double.parseDouble(posteriorNumber.getText());
            numberTwo = Double.parseDouble(txtResults.getText());
            posteriorNumber.setText(numberOne + operationMath + numberTwo + "²=");
            txtResults.setText(String.valueOf(controller.calcular_SQ(numberOne, numberTwo, operationMath, operationSQ)));
            clearAtributes();
        }
        FunctionDB.input(txtResults.getText(), posteriorNumber.getText());
    }

    @FXML
    void buttonSQRT(ActionEvent event) {
        operationSQ = "√";
        if (operationMath.isEmpty()) {
            converse();
            posteriorNumber.setText("√" + numberOne);
            txtResults.setText(String.valueOf(controller.calcularSQ(numberOne, operationSQ)));
            clearAtributes();
        } else {
            numberOne = Double.parseDouble(posteriorNumber.getText());
            numberTwo = Double.parseDouble(txtResults.getText());
            posteriorNumber.setText(numberOne + operationMath + "√" + numberTwo + "=");
            System.out.println("Operacao M" + operationMath + "\nOperacao SQ" + operationSQ);
            txtResults.setText(String.valueOf(controller.calcular_SQ(numberOne, numberTwo, operationMath, operationSQ)));
            System.out.println(controller.calcular_SQ(numberOne, numberTwo, operationMath, operationSQ));
            clearAtributes();
        }
        FunctionDB.input(txtResults.getText(), posteriorNumber.getText());
    }

    @FXML
    void buttonDiv(ActionEvent event) {
        converse();
        operationMath = "/";
    }

    @FXML
    void buttonMulti(ActionEvent event) {
        converse();
        operationMath = "*";
    }

    @FXML
    void buttonSub(ActionEvent event) {
        converse();
        operationMath = "-";
    }

    @FXML
    void buttonSum(ActionEvent event) {
        converse();
        operationMath = "+";
    }

    @FXML
    void buttonPoint(ActionEvent event) {
        txtResults.appendText(".");
    }

    @FXML
    void buttonEight(ActionEvent event) {
        txtResults.appendText("8");
    }

    @FXML
    void buttonFive(ActionEvent event) {
        txtResults.appendText("5");
    }

    @FXML
    void buttonFour(ActionEvent event) {
        txtResults.appendText("4");
    }

    @FXML
    void buttonNine(ActionEvent event) {
        txtResults.appendText("9");
    }

    @FXML
    void buttonOne(ActionEvent event) {
        txtResults.appendText("1");
    }

    @FXML
    void buttonSeven(ActionEvent event) {
        txtResults.appendText("7");
    }

    @FXML
    void buttonSix(ActionEvent event) {
        txtResults.appendText("6");
    }

    @FXML
    void buttonThree(ActionEvent event) {
        txtResults.appendText("3");
    }

    @FXML
    void buttonTwo(ActionEvent event) {
        txtResults.appendText("2");
    }

    @FXML
    void buttonZero(ActionEvent event) {
        txtResults.appendText("0");
    }

    void setNullTxt() {
        txtResults.setText("");
    }

    void converse() {
        try {
            numberOne = Double.parseDouble(txtResults.getText());
            posteriorNumber.setText(String.valueOf(numberOne));
            setNullTxt();
        } catch (NumberFormatException e) {
            System.out.println("Não tem número, coloca algo aí por favor?");
        }
    }

    public static void alert(String title, String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }

    void clearAtributes() {
        numberOne = 0;
        numberTwo = 0;
        operationMath = "";
        operationSQ = "";
    }
}