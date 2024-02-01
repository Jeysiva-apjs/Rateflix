package com.jey.rateflix.exception;

public class MovieNotFoundException extends RuntimeException{

    public MovieNotFoundException(String type, String value) {
        super("Movie with " + type + " " +  value + " not found");
    }
    
}
