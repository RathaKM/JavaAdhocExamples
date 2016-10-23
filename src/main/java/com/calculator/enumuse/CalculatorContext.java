package com.calculator.enumuse;

import java.util.Iterator;
import java.util.Set;

public class CalculatorContext {
    private Set<OperationStrategy> strategies;

    public CalculatorContext(Set<OperationStrategy> strategies) {
        this.strategies = strategies;
    }

    public int execute(CalculatorInput calcInput) {
        for (Iterator<OperationStrategy> iterator = strategies.iterator(); iterator.hasNext();) {
            OperationStrategy calcValidation = iterator.next();
            if (calcValidation.validate(calcInput)) {
                return calcValidation.getResult(calcInput);
            }
        }
        throw new InvalidOperationException("Unsupported calculator operation: " + calcInput.getOperator());
    }
}
