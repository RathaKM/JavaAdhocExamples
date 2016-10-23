package com.calculator.enumuse;

import constants.OperationType;
import org.junit.Assert;
import org.junit.Test;

import javax.management.OperationsException;
import java.util.HashSet;
import java.util.Set;

public class CalculatorTest {

    @Test
    public void testCalculatorOperationForADD() {
        Set<OperationStrategy> calculatorStrategies = new HashSet<OperationStrategy>();
        calculatorStrategies.add(CalculatorOperationStrategy.ADD);
        calculatorStrategies.add(CalculatorOperationStrategy.SUBTRACTION);
        calculatorStrategies.add(CalculatorOperationStrategy.MULTIPLICATION);
        calculatorStrategies.add(ExtendedCalculatorOperationStrategy.DIVISION);

        CalculatorInput input = new CalculatorInput("+", 10, 5);
        CalculatorContext ctxCalculator = new CalculatorContext(calculatorStrategies);
        Assert.assertEquals(15, ctxCalculator.execute(input));
    }

    @Test
    public void testCalculatorOperationForSUB() {
        Set<OperationStrategy> calculatorStrategies = new HashSet<OperationStrategy>();
        calculatorStrategies.add(CalculatorOperationStrategy.ADD);
        calculatorStrategies.add(CalculatorOperationStrategy.SUBTRACTION);
        calculatorStrategies.add(CalculatorOperationStrategy.MULTIPLICATION);
        calculatorStrategies.add(ExtendedCalculatorOperationStrategy.DIVISION);

        CalculatorInput input = new CalculatorInput("-", 10, 5);
        CalculatorContext ctxCalculator = new CalculatorContext(calculatorStrategies);
        Assert.assertEquals(5, ctxCalculator.execute(input));
    }

    @Test
    public void testCalculatorOperationForMUL() {
        Set<OperationStrategy> calculatorStrategies = new HashSet<OperationStrategy>();
        calculatorStrategies.add(CalculatorOperationStrategy.ADD);
        calculatorStrategies.add(CalculatorOperationStrategy.SUBTRACTION);
        calculatorStrategies.add(CalculatorOperationStrategy.MULTIPLICATION);
        calculatorStrategies.add(ExtendedCalculatorOperationStrategy.DIVISION);

        CalculatorInput input = new CalculatorInput("*", 10, 5);
        CalculatorContext ctxCalculator = new CalculatorContext(calculatorStrategies);
        Assert.assertEquals(50, ctxCalculator.execute(input));
    }

    @Test(expected = InvalidOperationException.class)
    public void testCalculatorOperationUnsupported() {
        Set<OperationStrategy> calculatorStrategies = new HashSet<OperationStrategy>();
        calculatorStrategies.add(CalculatorOperationStrategy.ADD);
        calculatorStrategies.add(CalculatorOperationStrategy.SUBTRACTION);
        //Now, we decided not to support multiplication
        //calculatorStrategies.add(CalculatorOperation.MULTIPLICATION);
        calculatorStrategies.add(ExtendedCalculatorOperationStrategy.DIVISION);

        CalculatorInput input = new CalculatorInput("*", 10, 5);
        CalculatorContext ctxCalculator = new CalculatorContext(calculatorStrategies);
        ctxCalculator.execute(input);
    }

    @Test
    public void testCalculatorOperationForDIV() {
        Set<OperationStrategy> calculatorStrategies = new HashSet<OperationStrategy>();
        calculatorStrategies.add(CalculatorOperationStrategy.ADD);
        calculatorStrategies.add(CalculatorOperationStrategy.SUBTRACTION);
        calculatorStrategies.add(CalculatorOperationStrategy.MULTIPLICATION);
        calculatorStrategies.add(ExtendedCalculatorOperationStrategy.DIVISION);

        CalculatorInput input = new CalculatorInput("/", 10, 5);
        CalculatorContext ctxCalculator = new CalculatorContext(calculatorStrategies);
        Assert.assertEquals(2, ctxCalculator.execute(input));
    }

}
