package com.chanzo.animalregistryservice.exceptions;

public class TagNumberAlreadyExists extends RuntimeException {
    public TagNumberAlreadyExists(String message) {
        super(message);
    }
}
