package com.calculator.enumuse;

public interface OperationStrategy {
    <T extends CalculatorInput> boolean validate(T input);
    <T extends CalculatorInput> int getResult(T input);

}
