package com.validator.enumuse;

import com.validation.enumuse.*;
import constants.ValidationType;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class ValidatorTest {

    @Test
    public void testValidatorForDOB() {
        Set<ValidationStrategy> strategies = new LinkedHashSet<ValidationStrategy>();
        strategies.add(UserValidationStrategy.DATE_OF_BIRTH);
        strategies.add(UserValidationStrategy.CITY);
        strategies.add(UserValidationStrategy.ZIP);
        strategies.add(UserValidationStrategy.COUNTRY);
        strategies.add(UserValidationStrategy.SSN);
        strategies.add(UserValidationStrategy.CREDIT_CARD_NUMBER);
        strategies.add(UserValidationStrategy.BANK_ROUTING_NUMBER);
        strategies.add(UserValidationStrategy.BANK_ACCOUNT_NUMBER);
        strategies.add(UserValidationStrategy.BANK_NAME);
        strategies.add(UserValidationStrategy.BANK_CITY);
        strategies.add(UserValidationStrategy.BANK_ZIP);
        strategies.add(UserValidationStrategy.BANK_COUNTRY);

        UserInput input = new UserInput();
        input.setUserValid(true);
        input.setDateOfBirth("");
        UserValidationContext ctxUser = new UserValidationContext(strategies);
        Assert.assertEquals(ValidationType.DATE_OF_BIRTH, ctxUser.execute(input));
    }

    @Test
    public void testValidatorForCITY() {
        Set<ValidationStrategy> strategies = new LinkedHashSet<ValidationStrategy>();
        strategies.add(UserValidationStrategy.DATE_OF_BIRTH);
        strategies.add(UserValidationStrategy.CITY);
        strategies.add(UserValidationStrategy.ZIP);
        strategies.add(UserValidationStrategy.COUNTRY);
        strategies.add(UserValidationStrategy.SSN);
        strategies.add(UserValidationStrategy.CREDIT_CARD_NUMBER);
        strategies.add(UserValidationStrategy.BANK_ROUTING_NUMBER);
        strategies.add(UserValidationStrategy.BANK_ACCOUNT_NUMBER);
        strategies.add(UserValidationStrategy.BANK_NAME);
        strategies.add(UserValidationStrategy.BANK_CITY);
        strategies.add(UserValidationStrategy.BANK_ZIP);
        strategies.add(UserValidationStrategy.BANK_COUNTRY);

        UserInput input = new UserInput();
        input.setUserValid(true);
        input.setDateOfBirth("01/01/1990");
        input.setCity("");
        UserValidationContext ctxUser = new UserValidationContext(strategies);
        Assert.assertEquals(ValidationType.CITY, ctxUser.execute(input));
    }

    @Test
    public void testValidatorForUNSUPPORTED_DOB() {
        Set<ValidationStrategy> strategies = new LinkedHashSet<ValidationStrategy>();
        //strategies.add(UserValidation.DATE_OF_BIRTH);
        strategies.add(UserValidationStrategy.CITY);
        strategies.add(UserValidationStrategy.ZIP);

        UserInput input = new UserInput();
        input.setUserValid(true);
        input.setDateOfBirth("");
        input.setCity("");
        input.setZip("");
        UserValidationContext ctxUser = new UserValidationContext(strategies);
        Assert.assertEquals(ValidationType.CITY, ctxUser.execute(input));
    }

    @Test
    public void testValidatorForGetList() {
        Set<ValidationStrategy> strategies = new LinkedHashSet<ValidationStrategy>();
        strategies.add(UserValidationStrategy.DATE_OF_BIRTH);
        strategies.add(UserValidationStrategy.CITY);
        strategies.add(UserValidationStrategy.ZIP);
        strategies.add(UserValidationStrategy.COUNTRY);
        strategies.add(UserValidationStrategy.SSN);
        strategies.add(UserValidationStrategy.CREDIT_CARD_NUMBER);
        strategies.add(UserValidationStrategy.BANK_ROUTING_NUMBER);
        strategies.add(UserValidationStrategy.BANK_ACCOUNT_NUMBER);
        strategies.add(UserValidationStrategy.BANK_NAME);
        strategies.add(UserValidationStrategy.BANK_CITY);
        strategies.add(UserValidationStrategy.BANK_ZIP);
        strategies.add(UserValidationStrategy.BANK_COUNTRY);

        UserInput input = new UserInput();
        input.setUserValid(true);
        input.setDateOfBirth("01/01/1990");
        input.setCity("SanJose");
        input.setZip("");
        input.setCountry("USA");
        input.setSsn("");
        input.setBankAdded(true);
        input.setCreditCardAdded(true);
        input.setCreditCardNumber("");
        input.setBankRoutingNumber("");
        input.setBankAccountNumber("");
        input.setBankName("");
        input.setBankCity("");
        input.setBankZip("");
        input.setBankCountry("");
        UserValidationContext ctxUser = new UserValidationContext(strategies);
        Object[] arrResultActual = ctxUser.executeAndGetList(input).toArray();
        Object[] arrResultExpected = {ValidationType.ZIP, ValidationType.SSN, ValidationType.CREDIT_CARD_NUMBER, ValidationType.BANK_ROUTING_NUMBER, ValidationType.BANK_ACCOUNT_NUMBER, ValidationType.BANK_NAME, ValidationType.BANK_CITY, ValidationType.BANK_ZIP, ValidationType.BANK_COUNTRY};

        Assert.assertArrayEquals(arrResultExpected, arrResultActual);
    }

    @Test
    public void testValidatorForAllValidAndGetList() {
        Set<ValidationStrategy> strategies = new LinkedHashSet<ValidationStrategy>();
        strategies.add(UserValidationStrategy.DATE_OF_BIRTH);
        strategies.add(UserValidationStrategy.CITY);
        strategies.add(UserValidationStrategy.ZIP);
        strategies.add(UserValidationStrategy.COUNTRY);
        strategies.add(UserValidationStrategy.SSN);
        strategies.add(UserValidationStrategy.CREDIT_CARD_NUMBER);
        strategies.add(UserValidationStrategy.BANK_ROUTING_NUMBER);
        strategies.add(UserValidationStrategy.BANK_ACCOUNT_NUMBER);
        strategies.add(UserValidationStrategy.BANK_NAME);
        strategies.add(UserValidationStrategy.BANK_CITY);
        strategies.add(UserValidationStrategy.BANK_ZIP);
        strategies.add(UserValidationStrategy.BANK_COUNTRY);

        UserInput input = new UserInput();
        input.setUserValid(true);
        input.setDateOfBirth("01/01/1990");
        input.setCity("SanJose");
        input.setZip("95131");
        input.setCountry("USA");
        input.setSsn("123-45-6789");
        input.setBankAdded(true);
        input.setCreditCardAdded(true);
        input.setCreditCardNumber("123456789");
        input.setBankRoutingNumber("123456789");
        input.setBankAccountNumber("12345678898");
        input.setBankName("Abc");
        input.setBankCity("SanJose");
        input.setBankZip("95131");
        input.setBankCountry("USA");
        UserValidationContext ctxUser = new UserValidationContext(strategies);
        Object[] arrResultActual = ctxUser.executeAndGetList(input).toArray();
        Object[] arrResultExpected = {};
        Assert.assertArrayEquals(arrResultExpected, arrResultActual);
    }

    @Test
    public void testValidatorForAllValid() {
        Set<ValidationStrategy> strategies = new LinkedHashSet<ValidationStrategy>();
        strategies.add(UserValidationStrategy.DATE_OF_BIRTH);
        strategies.add(UserValidationStrategy.CITY);
        strategies.add(UserValidationStrategy.ZIP);
        strategies.add(UserValidationStrategy.COUNTRY);
        strategies.add(UserValidationStrategy.SSN);
        strategies.add(UserValidationStrategy.CREDIT_CARD_NUMBER);
        strategies.add(UserValidationStrategy.BANK_ROUTING_NUMBER);
        strategies.add(UserValidationStrategy.BANK_ACCOUNT_NUMBER);
        strategies.add(UserValidationStrategy.BANK_NAME);
        strategies.add(UserValidationStrategy.BANK_CITY);
        strategies.add(UserValidationStrategy.BANK_ZIP);
        strategies.add(UserValidationStrategy.BANK_COUNTRY);

        UserInput input = new UserInput();
        input.setUserValid(true);
        input.setDateOfBirth("01/01/1990");
        input.setCity("SanJose");
        input.setZip("95131");
        input.setCountry("USA");
        input.setSsn("123-45-6789");
        input.setBankAdded(true);
        input.setCreditCardAdded(true);
        input.setCreditCardNumber("123456789");
        input.setBankRoutingNumber("123456789");
        input.setBankAccountNumber("12345678898");
        input.setBankName("Abc");
        input.setBankCity("SanJose");
        input.setBankZip("95131");
        input.setBankCountry("USA");
        UserValidationContext ctxUser = new UserValidationContext(strategies);
        Assert.assertNull(ctxUser.execute(input));
    }

    @Test
    public void testValidatorForUNSUPPORTED() {
        Set<ValidationStrategy> strategies = new LinkedHashSet<ValidationStrategy>();
        strategies.add(UserValidationStrategy.DATE_OF_BIRTH);
        //strategies.add(UserValidationStrategy.CITY);
        strategies.add(UserValidationStrategy.ZIP);
        //strategies.add(UserValidation.COUNTRY);
        strategies.add(UserValidationStrategy.SSN);
        //strategies.add(UserValidation.CREDIT_CARD_NUMBER);
        strategies.add(UserValidationStrategy.BANK_ROUTING_NUMBER);
        strategies.add(UserValidationStrategy.BANK_ACCOUNT_NUMBER);
        //strategies.add(UserValidation.BANK_NAME);
        //strategies.add(UserValidation.BANK_CITY);
        //strategies.add(UserValidation.BANK_ZIP);
        //strategies.add(UserValidation.BANK_COUNTRY);

        UserInput input = new UserInput();
        input.setUserValid(true);
        input.setDateOfBirth("");
        input.setCity("SanJose");
        input.setZip("95131");
        input.setCountry("USA");
        input.setSsn("");
        input.setBankAdded(true);
        input.setCreditCardAdded(true);
        input.setCreditCardNumber("");
        input.setBankRoutingNumber("123456789");
        input.setBankAccountNumber("");
        input.setBankName("");
        input.setBankCity("");
        input.setBankZip("");
        input.setBankCountry("");
        UserValidationContext ctxUser = new UserValidationContext(strategies);
        Object[] arrResultActual = ctxUser.executeAndGetList(input).toArray();
        Object[] arrResultExpected = {ValidationType.DATE_OF_BIRTH, ValidationType.SSN, ValidationType.BANK_ACCOUNT_NUMBER};
        Assert.assertArrayEquals(arrResultExpected, arrResultActual);
    }

    @Test
    public void testValidatorForExtension() {
        Set<ValidationStrategy> strategies = new LinkedHashSet<ValidationStrategy>();
        strategies.add(UserValidationStrategy.DATE_OF_BIRTH);
        strategies.add(ExtendedValidationStrategy.BANK_ACCOUNT_TYPE);

        UserInput input = new UserInput();
        input.setUserValid(true);
        input.setDateOfBirth("01/01/1994");
        input.setBankAdded(true);
        input.setBankAccountType("");
        UserValidationContext ctxUser = new UserValidationContext(strategies);
        Assert.assertEquals(ValidationType.BANK_ACCOUNT_TYPE, ctxUser.execute(input));
    }
}
