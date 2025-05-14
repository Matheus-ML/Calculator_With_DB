package com.example.calculadorakz;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class HelloController {
    private double numberOne = 0;
    private double numberTwo = 0;
    private String operationMath = "";
    private String operationSQ;
    private CalculatorController controller = new CalculatorController();


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
        setNumberTwo(Double.parseDouble(txtResults.getText()));

        if (getOperationMath().equals("/") && getNumberTwo() == 0) {
            alert("Error", "Zero não pode ser o Divisor, escolha outro número!");
            setNullTxt();
            return;
        }
        txtResults.setText(String.valueOf(getController().calculatePerCent(getNumberOne(), getNumberTwo(), getOperationMath())));
        posteriorNumber.setText((getNumberOne()) + getOperationMath() + getNumberTwo() + "%");
    }

    @FXML
    void buttonEqual() {
        setNumberTwo(Double.parseDouble(txtResults.getText()));

        if (getOperationMath().equals("/") && getNumberTwo() == 0) {
            alert("Error", "Zero não pode ser o Divisor, escolha outro número!");
            return;
        }
        txtResults.setText(String.valueOf(getController().calculate(getNumberOne(), getNumberTwo(), getOperationMath())));
        posteriorNumber.setText((getNumberOne()) + getOperationMath() + getNumberTwo() + " =");
        FunctionDB.input(txtResults.getText(), posteriorNumber.getText());
        clearAtributes();
    }

    @FXML
    void buttonPow() {
        setOperationSQ("x²");
        if (getOperationMath().isEmpty()) {
            converse();
            posteriorNumber.setText(getNumberOne() + "²");
            txtResults.setText(String.valueOf(getController().calculateSQ(getNumberOne(), getOperationSQ())));
            clearAtributes();
        } else {
            setNumberOne(Double.parseDouble(posteriorNumber.getText()));
            setNumberTwo(Double.parseDouble(txtResults.getText()));
            posteriorNumber.setText(getNumberOne() + getOperationMath() + getNumberTwo() + "²=");
            txtResults.setText(String.valueOf(getController().calculate_SQ(getNumberOne(), getNumberTwo(), getOperationMath(), getOperationSQ())));
            clearAtributes();
        }
        FunctionDB.input(txtResults.getText(), posteriorNumber.getText());
    }

    @FXML
    void buttonSQRT() {
        setOperationSQ("√");
        if (getOperationMath().isEmpty()) {
            converse();
            posteriorNumber.setText("√" + getNumberOne());
            txtResults.setText(String.valueOf(getController().calculateSQ(getNumberOne(), getOperationSQ())));
            clearAtributes();
        } else {
            setNumberOne(Double.parseDouble(posteriorNumber.getText()));
            setNumberTwo(Double.parseDouble(txtResults.getText()));
            posteriorNumber.setText(getNumberOne() + getOperationMath() + "√" + getNumberTwo() + "=");
            System.out.println("Operacao M" + getOperationMath() + "\nOperacao SQ" + getOperationSQ());
            txtResults.setText(String.valueOf(getController().calculate_SQ(getNumberOne(), getNumberTwo(), getOperationMath(), getOperationSQ())));
            System.out.println(getController().calculate_SQ(getNumberOne(), getNumberTwo(), getOperationMath(), getOperationSQ()));
            clearAtributes();
        }
        FunctionDB.input(txtResults.getText(), posteriorNumber.getText());
    }

    @FXML
    void buttonDiv() {
        converse();
        setOperationMath("/");
    }

    @FXML
    void buttonMulti() {
        converse();
        setOperationMath("*");
    }

    @FXML
    void buttonSub() {
        converse();
        setOperationMath("-");
    }

    @FXML
    void buttonSum() {
        converse();
        setOperationMath("+");
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
            setNumberOne(Double.parseDouble(txtResults.getText()));
            posteriorNumber.setText(String.valueOf(getNumberOne()));
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
        setNumberOne(0);
        setNumberTwo(0);
        setOperationMath("");
        setOperationSQ("");
    }

    public double getNumberOne() {
        return numberOne;
    }

    public void setNumberOne(double numberOne) {
        this.numberOne = numberOne;
    }

    public double getNumberTwo() {
        return numberTwo;
    }

    public void setNumberTwo(double numberTwo) {
        this.numberTwo = numberTwo;
    }

    public String getOperationMath() {
        return operationMath;
    }

    public void setOperationMath(String operationMath) {
        this.operationMath = operationMath;
    }

    public String getOperationSQ() {
        return operationSQ;
    }

    public void setOperationSQ(String operationSQ) {
        this.operationSQ = operationSQ;
    }

    public CalculatorController getController() {
        return controller;
    }
}