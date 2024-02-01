package com.jey.rateflix.exception;

public class ReviewNotFoundException extends RuntimeException{

    public ReviewNotFoundException(String type, String value) {
        super("Review with " + type + " " +  value + " not found");
    }

}
