package com.rao.usermanagement.exception;

public class PassWordValidationException extends RuntimeException {

    public PassWordValidationException() {
        super("Password Should Contain at least One Upper Case Charcter and One Lower Case Charcter and one Digit ");
    }
}
