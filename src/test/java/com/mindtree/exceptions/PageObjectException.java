package com.mindtree.exceptions;

@SuppressWarnings("serial")
public class PageObjectException extends Exception {

    public PageObjectException(String message) {
        super(message);
    }

    public PageObjectException(String message, Throwable cause) {
        super(message, cause);
    }
}
