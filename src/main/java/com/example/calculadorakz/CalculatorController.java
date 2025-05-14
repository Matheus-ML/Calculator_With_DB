package com.example.calculadorakz;

public class CalculatorController {

    public double calculate(double numberOne, double numberTwo, String operationMath) {
        return switch (operationMath) {
            case "+" -> numberOne + numberTwo;
            case "-" -> numberOne - numberTwo;
            case "/" -> numberOne / numberTwo;
            case "*" -> numberOne * numberTwo;
            default -> 0;
        };
    }

    //Calcula a Potência e Raiz quadrada, quando não tiver operação matemática, ou seja, um calculo de apenas 1 número.
    public double calculateSQ(double numberOne, String operationMath) {
        return switch (operationMath) {
            case "x²" -> numberOne * numberOne;
            case "√" -> Math.sqrt(numberOne);
            default -> 0;
        };
    }

    //Calcula Potência e Raiz quadrada, quando for ser usada após uma operação matemática como soma e multiplicação.
    public double calculate_SQ(double numberOne, double numberTwo, String operationMath, String operationSQ) {
        return switch (operationMath) {
            case "+" -> numberOne + calculateSQ(numberTwo, operationSQ);
            case "-" -> numberOne - calculateSQ(numberTwo, operationSQ);
            case "/" -> numberOne / calculateSQ(numberTwo, operationSQ);
            case "*" -> numberOne * calculateSQ(numberTwo, operationSQ);
            default -> 0;
        };

    }

    public double calculatePerCent(double numberOne, double numberTwo, String operationMath) {
        return switch (operationMath) {
            case "+" -> numberOne + (numberTwo / 100 * numberOne);
            case "-" -> numberOne - (numberTwo / 100 * numberOne);
            case "/" -> numberOne / (numberTwo / 100);
            case "*" -> numberOne * (numberTwo / 100);
            default -> 0;
        };
    }

}
