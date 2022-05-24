package com.weather.spring.rest.exeption_handling;

public class ServiceException extends RuntimeException{

    public ServiceException(String message) {
        super(message);
    }
}
