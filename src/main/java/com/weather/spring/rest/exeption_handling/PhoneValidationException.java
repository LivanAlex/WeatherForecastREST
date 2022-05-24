package com.weather.spring.rest.exeption_handling;

public class PhoneValidationException extends RuntimeException{

    public PhoneValidationException(String message) {
        super(message);
    }
}
