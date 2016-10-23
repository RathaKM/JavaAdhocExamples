package com.calculator.enumuse;

public class CalculatorInput {
    private int operand1, operand2;
    private String operator;

    public CalculatorInput(String operator, int operand1, int operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
    }

    public int getOperand1() {
        return operand1;
    }

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
