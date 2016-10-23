
package com.validation.enumuse;

import com.calculator.enumuse.CalculatorInput;
import com.calculator.enumuse.InvalidOperationException;
import constants.ValidationType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public enum UserValidationStrategy implements ValidationStrategy {

    DATE_OF_BIRTH (ValidationType.DATE_OF_BIRTH) {
        public <T extends UserInput> boolean validate(T input) {
            if(input.isUserValid() && input.getDateOfBirth().isEmpty() ) {
                return true;
            }
            return false;
        }
    },

    CITY (ValidationType.CITY) {
        public <T extends UserInput> boolean validate(T input) {
            if(input.isUserValid() && input.getCity().isEmpty() ) {
                return true;
            }
            return false;
        }
    },

    ZIP (ValidationType.ZIP) {
        public <T extends UserInput> boolean validate(T input) {
            if(input.isUserValid() && input.getZip().isEmpty() ) {
                return true;
            }
            return false;
        }
    },

    COUNTRY (ValidationType.COUNTRY) {
        public <T extends UserInput> boolean validate(T input) {
            if(input.isUserValid() && input.getCountry().isEmpty() ) {
                return true;
            }
            return false;
        }
    },

    SSN (ValidationType.SSN) {
        public <T extends UserInput> boolean validate(T input) {
            if(input.isUserValid() && input.getSsn().isEmpty() ) {
                return true;
            }
            return false;
        }
    },

    CREDIT_CARD_NUMBER (ValidationType.CREDIT_CARD_NUMBER) {
        public <T extends UserInput> boolean validate(T input) {
            if(input.isUserValid() && input.isCreditCardAdded() && input.getCreditCardNumber().isEmpty() ) {
                return true;
            }
            return false;
        }
    },

    BANK_ROUTING_NUMBER (ValidationType.BANK_ROUTING_NUMBER) {
        public <T extends UserInput> boolean validate(T input) {
            if(input.isUserValid() && input.isBankAdded() && input.getBankRoutingNumber().isEmpty() ) {
                return true;
            }
            return false;
        }
    },

    BANK_ACCOUNT_NUMBER (ValidationType.BANK_ACCOUNT_NUMBER) {
        public <T extends UserInput> boolean validate(T input) {
            if(input.isUserValid() && input.isBankAdded() && input.getBankAccountNumber().isEmpty() ) {
                return true;
            }
            return false;
        }
    },

    BANK_NAME (ValidationType.BANK_NAME) {
        public <T extends UserInput> boolean validate(T input) {
            if(input.isUserValid() && input.isBankAdded() && input.getBankName().isEmpty() ) {
                return true;
            }
            return false;
        }
    },

    BANK_CITY (ValidationType.BANK_CITY) {
        public <T extends UserInput> boolean validate(T input) {
            if(input.isUserValid() && input.isBankAdded() && input.getBankCity().isEmpty() ) {
                return true;
            }
            return false;
        }
    },

    BANK_ZIP (ValidationType.BANK_ZIP) {
        public <T extends UserInput> boolean validate(T input) {
            if(input.isUserValid() && input.isBankAdded() && input.getBankZip().isEmpty() ) {
                return true;
            }
            return false;
        }
    },

    BANK_COUNTRY (ValidationType.BANK_COUNTRY) {
        public <T extends UserInput> boolean validate(T input) {
            if(input.isUserValid() && input.isBankAdded() && input.getBankCountry().isEmpty() ) {
                return true;
            }
            return false;
        }
    },

    UNSUPPORTED (ValidationType.UNSUPPORTED) {
        public <T extends UserInput> boolean validate(T input) {
            return false;
        }
    };

    private ValidationType validationType;

    private UserValidationStrategy(ValidationType validationType) {
        this.validationType = validationType;
    }

    public ValidationType getValidationType() {
        return validationType;
    }
}
