
package com.calculator.enumuse;

import constants.OperationType;

import java.util.Iterator;
import java.util.Set;

public enum CalculatorOperationStrategy implements OperationStrategy {

    ADD(OperationType.ADDITION) {
        public <T extends CalculatorInput> boolean validate(T input) {
            if(input.getOperator().equals(OperationType.ADDITION.getValue())) {
                return true;
            }
            return false;
        }

        public <T extends CalculatorInput> int getResult(T input) {
            return input.getOperand1() + input.getOperand2();
        }
    },
    SUBTRACTION(OperationType.SUBTRACTION) {
        public <T extends CalculatorInput> boolean validate(T input) {
            if(input.getOperator().equals(OperationType.SUBTRACTION.getValue())) {
                return true;
            }
            return false;
        }
        public <T extends CalculatorInput> int getResult(T input) {
            return input.getOperand1() - input.getOperand2();
        }
    },
    MULTIPLICATION(OperationType.MULTIPLICATION) {
        public <T extends CalculatorInput> boolean validate(T input) {
            if(input.getOperator().equals(OperationType.MULTIPLICATION.getValue())) {
                return true;
            }
            return false;
        }
        public <T extends CalculatorInput> int getResult(T input) {
            return input.getOperand1() * input.getOperand2();
        }
//    },
//    DIVISION(OperationType.DIVISION) {
//        public <T extends CalculatorInput> boolean validate(T input) {
//            if(input.getOperator().equals(OperationType.DIVISION.getValue())) {
//                return true;
//            }
//            return false;
//        }
//        public <T extends CalculatorInput> int getResult(T input) {
//            return input.getOperand1() / input.getOperand2();
//        }
    };


    private OperationType operation;

    private CalculatorOperationStrategy(OperationType operation) {
        this.operation = operation;
    }

}
