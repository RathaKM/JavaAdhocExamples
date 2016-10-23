package com.validation.enumuse;

import constants.ValidationType;

public enum ExtendedValidationStrategy implements ValidationStrategy {

    BANK_ACCOUNT_TYPE (ValidationType.BANK_ACCOUNT_TYPE) {
        public <T extends UserInput> boolean validate(T input) {
            if(input.isUserValid() && input.isBankAdded() && input.getBankAccountType().isEmpty() ) {
                return true;
            }
            return false;
        }
    };

    private ValidationType validationType;

    private ExtendedValidationStrategy(ValidationType validationType) {
        this.validationType = validationType;
    }

    public ValidationType getValidationType() {
        return validationType;
    }
}
