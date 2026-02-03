package com.chanzo.medicalservice.exceptions;

public class AnimalNotFound extends RuntimeException {
    public AnimalNotFound(String message) {
        super(message);
    }
}
