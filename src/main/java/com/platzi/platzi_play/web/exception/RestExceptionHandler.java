package com.platzi.platzi_play.web.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.platzi.platzi_play.domain.exception.MovieAlreadyExistsException;
import com.platzi.platzi_play.domain.exception.MovieNoExistsException;

@RestControllerAdvice 
public class RestExceptionHandler {
    
    @ExceptionHandler(MovieAlreadyExistsException.class)
    public ResponseEntity<Error> handlerException(MovieAlreadyExistsException ex) {
        Error error = new Error("movie-already-exists", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MovieNoExistsException.class)
    public ResponseEntity<Error> handlerException(MovieNoExistsException ex) {
        Error error = new Error("movie-no-exists", ex.getMessage());
        return  ResponseEntity.badRequest().body(error);
    }
}
