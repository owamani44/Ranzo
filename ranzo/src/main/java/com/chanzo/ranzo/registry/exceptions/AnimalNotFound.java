package com.chanzo.ranzo.registry.exceptions;

public class AnimalNotFound extends RuntimeException {
    public AnimalNotFound(String message) {
        super(message);
    }
}
