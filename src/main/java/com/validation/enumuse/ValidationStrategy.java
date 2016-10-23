package com.validation.enumuse;

import constants.ValidationType;

public interface ValidationStrategy {
    <T extends UserInput> boolean validate(T input);
    ValidationType getValidationType();
}
