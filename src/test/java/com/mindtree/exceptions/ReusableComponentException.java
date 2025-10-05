package com.mindtree.exceptions;

@SuppressWarnings("serial")
public class ReusableComponentException extends Exception {

    public ReusableComponentException(String message) {
        super(message);
    }

    public ReusableComponentException(String message, Throwable cause) {
        super(message, cause);
    }
}
