package com.jey.rateflix;

import java.util.List;

import java.util.ArrayList;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jey.rateflix.exception.ErrorResponse;
import com.jey.rateflix.exception.MovieNotFoundException;
import com.jey.rateflix.exception.ReviewNotFoundException;



@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler({MovieNotFoundException.class, ReviewNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(RuntimeException ex) {
        String error = ex.getMessage();
        ErrorResponse errorResponse = new ErrorResponse(List.of(error));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
                List<String> errors = new ArrayList<>();
                ex.getBindingResult().getAllErrors().forEach((error) -> errors.add(error.getDefaultMessage()));
                return new ResponseEntity<>(new ErrorResponse(errors), HttpStatus.BAD_REQUEST);
    }


    
    
}
