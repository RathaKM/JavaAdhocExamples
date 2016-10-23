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

    /*
    * This method performs validation for fields one by one and return the invalid one if found.
    * Otherwise, it will continue validating remaining fields. If all the fields are valid then will return null.
  	*/
    public ValidationType execute(UserInput userInput) {
        ValidationStrategy userValidation = UserValidationStrategy.UNSUPPORTED;
        for (Iterator<ValidationStrategy> iterator = userValidationStrategies.iterator(); iterator.hasNext();) {
            userValidation = iterator.next();
            if (userValidation.validate(userInput)) {
                return userValidation.getValidationType();
            }
        }
        return null;
    }

    /*
    * This method performs validation for fields one by one and
    * add the invalid one into a list if found and returns that list.
  	*/
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
