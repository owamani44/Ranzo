package com.chanzo.weightrecordservice.exceptions;

public class AnimalNotFound extends RuntimeException {
    public AnimalNotFound(String message) {
        super(message);
    }
}
