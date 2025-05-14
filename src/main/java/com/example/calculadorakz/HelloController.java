package com.example.calculadorakz;

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
    void buttonHistoric() {
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
    void buttonBackspace() {
        try {
            String text = txtResults.getText();
            String backspace = text.substring(0, text.length() - 1);
            txtResults.setText(backspace);
        } catch (StringIndexOutOfBoundsException e) {
            setNullTxt();
        }
    }

    @FXML
    void buttonC() {
        setNullTxt();
        posteriorNumber.setText("");
        clearAtributes();
    }

    @FXML
    void buttonPercent() {
        numberTwo = Double.parseDouble(txtResults.getText());

        if (operationMath.equals("/") && numberTwo == 0) {
            alert("Error", "Zero não pode ser o Divisor, escolha outro número!");
            setNullTxt();
            return;
        }
        txtResults.setText(String.valueOf(controller.calculatePerCent(numberOne, numberTwo, operationMath)));
        posteriorNumber.setText((numberOne) + operationMath + numberTwo + "%");
    }

    @FXML
    void buttonEqual() {
        numberTwo = Double.parseDouble(txtResults.getText());

        if (operationMath.equals("/") && numberTwo == 0) {
            alert("Error", "Zero não pode ser o Divisor, escolha outro número!");
            return;
        }
        txtResults.setText(String.valueOf(controller.calculate(numberOne, numberTwo, operationMath)));
        posteriorNumber.setText((numberOne) + operationMath + numberTwo + " =");
        FunctionDB.input(txtResults.getText(), posteriorNumber.getText());
        clearAtributes();
    }

    @FXML
    void buttonPow() {
        operationSQ = "x²";
        if (operationMath.isEmpty()) {
            converse();
            posteriorNumber.setText(numberOne + "²");
            txtResults.setText(String.valueOf(controller.calculateSQ(numberOne, operationSQ)));
            clearAtributes();
        } else {
            numberOne = Double.parseDouble(posteriorNumber.getText());
            numberTwo = Double.parseDouble(txtResults.getText());
            posteriorNumber.setText(numberOne + operationMath + numberTwo + "²=");
            txtResults.setText(String.valueOf(controller.calculate_SQ(numberOne, numberTwo, operationMath, operationSQ)));
            clearAtributes();
        }
        FunctionDB.input(txtResults.getText(), posteriorNumber.getText());
    }

    @FXML
    void buttonSQRT() {
        operationSQ = "√";
        if (operationMath.isEmpty()) {
            converse();
            posteriorNumber.setText("√" + numberOne);
            txtResults.setText(String.valueOf(controller.calculateSQ(numberOne, operationSQ)));
            clearAtributes();
        } else {
            numberOne = Double.parseDouble(posteriorNumber.getText());
            numberTwo = Double.parseDouble(txtResults.getText());
            posteriorNumber.setText(numberOne + operationMath + "√" + numberTwo + "=");
            System.out.println("Operacao M" + operationMath + "\nOperacao SQ" + operationSQ);
            txtResults.setText(String.valueOf(controller.calculate_SQ(numberOne, numberTwo, operationMath, operationSQ)));
            System.out.println(controller.calculate_SQ(numberOne, numberTwo, operationMath, operationSQ));
            clearAtributes();
        }
        FunctionDB.input(txtResults.getText(), posteriorNumber.getText());
    }

    @FXML
    void buttonDiv() {
        converse();
        operationMath = "/";
    }

    @FXML
    void buttonMulti() {
        converse();
        operationMath = "*";
    }

    @FXML
    void buttonSub() {
        converse();
        operationMath = "-";
    }

    @FXML
    void buttonSum() {
        converse();
        operationMath = "+";
    }

    @FXML
    void buttonPoint() {
        txtResults.appendText(".");
    }

    @FXML
    void buttonEight() {
        txtResults.appendText("8");
    }

    @FXML
    void buttonFive() {
        txtResults.appendText("5");
    }

    @FXML
    void buttonFour() {
        txtResults.appendText("4");
    }

    @FXML
    void buttonNine() {
        txtResults.appendText("9");
    }

    @FXML
    void buttonOne() {
        txtResults.appendText("1");
    }

    @FXML
    void buttonSeven() {
        txtResults.appendText("7");
    }

    @FXML
    void buttonSix() {
        txtResults.appendText("6");
    }

    @FXML
    void buttonThree() {
        txtResults.appendText("3");
    }

    @FXML
    void buttonTwo() {
        txtResults.appendText("2");
    }

    @FXML
    void buttonZero() {
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