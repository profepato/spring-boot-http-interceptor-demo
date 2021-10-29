package com.example.demo.model.exceptions;

public class NotAllowedHttpMethodException extends Exception {
    public NotAllowedHttpMethodException(String message) {
        super(message);
    }
}
