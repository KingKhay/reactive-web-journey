package com.khaydev.reactive.exception;

public class OperationFailedException extends RuntimeException{
    public OperationFailedException() {
    }

    public OperationFailedException(String message) {
        super(message);
    }
}
