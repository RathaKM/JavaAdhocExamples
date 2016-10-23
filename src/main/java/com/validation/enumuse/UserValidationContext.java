package com.validation.enumuse;

import com.calculator.enumuse.InvalidOperationException;
import constants.ValidationType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class UserValidationContext {
    private Set<ValidationStrategy> userValidationStrategies;

    public UserValidationContext(Set<ValidationStrategy> userValidationStrategies) {
        this.userValidationStrategies = userValidationStrategies;
    }

    public ValidationType execute(UserInput userInput) {
        ValidationStrategy userValidation = UserValidationStrategy.UNSUPPORTED;
        for (Iterator<ValidationStrategy> iterator = userValidationStrategies.iterator(); iterator.hasNext();) {
            userValidation = iterator.next();
            if (userValidation.validate(userInput)) {
                return userValidation.getValidationType();
            }
        }
        throw new InvalidOperationException("Unsupported user validation: " + userValidation);
    }

    public List<ValidationType> executeAndGetList(UserInput userInput) {
        ValidationStrategy userValidation = UserValidationStrategy.UNSUPPORTED;
        List<ValidationType> validatedTypes = new ArrayList<ValidationType>();
        for (Iterator<ValidationStrategy> iterator = userValidationStrategies.iterator(); iterator.hasNext();) {
            userValidation = iterator.next();
            if (userValidation.validate(userInput)) {
                validatedTypes.add(userValidation.getValidationType());
            }
        }
        return validatedTypes;
    }
}
