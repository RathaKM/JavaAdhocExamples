package com.calculator.enumuse;


import constants.OperationType;

public enum ExtendedCalculatorOperationStrategy implements OperationStrategy {

    DIVISION(OperationType.DIVISION) {
        public <T extends CalculatorInput> boolean validate(T input) {
            if(input.getOperator().equals(OperationType.DIVISION.getValue())) {
                return true;
            }
            return false;
        }

        public <T extends CalculatorInput> int getResult(T input) {
            return input.getOperand1() / input.getOperand2();
        }
    };

    private OperationType operation;
    private ExtendedCalculatorOperationStrategy(OperationType operation) {
        this.operation = operation;
    }
}
