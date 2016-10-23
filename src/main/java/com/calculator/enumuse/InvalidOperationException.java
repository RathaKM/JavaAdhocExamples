package com.calculator.enumuse;

public class InvalidOperationException extends RuntimeException {
    public InvalidOperationException(String msg) {
        super(msg);
    }
}
