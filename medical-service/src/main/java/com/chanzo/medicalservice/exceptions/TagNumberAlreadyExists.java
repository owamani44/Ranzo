package com.chanzo.medicalservice.exceptions;

public class TagNumberAlreadyExists extends RuntimeException {
    public TagNumberAlreadyExists(String message) {
        super(message);
    }
}
