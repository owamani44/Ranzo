package com.chanzo.weightrecordservice.exceptions;

public class TagNumberAlreadyExists extends RuntimeException {
    public TagNumberAlreadyExists(String message) {
        super(message);
    }
}
