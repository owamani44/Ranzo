package com.chanzo.animalregistryservice.exceptions;

public class AnimalNotFound extends RuntimeException {
    public AnimalNotFound(String message) {
        super(message);
    }
}
