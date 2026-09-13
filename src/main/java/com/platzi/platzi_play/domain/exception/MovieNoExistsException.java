package com.platzi.platzi_play.domain.exception;

public class MovieNoExistsException extends RuntimeException {

    public MovieNoExistsException(long id) {
        super("No existe pelicula con el id número " + id);
    }
}
