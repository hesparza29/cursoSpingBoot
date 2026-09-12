package com.platzi.platzi_play.persistence.mapper;

import org.mapstruct.Named;

import com.platzi.platzi_play.domain.Genre;

public class GenreMapper {

    @Named("generoToGenre")
    public static Genre generoToGenre(String genero) {

        if(genero == null)
            return null;

        return switch (genero.toUpperCase()) {
            case "ANIMADA" -> Genre.ANIMATED;
            case "CIENCIA_FICCION" -> Genre.SCI_FIC;
            case "DRAMA" -> Genre.DRAMA;
            case "ACCION" -> Genre.ACTION;
            case "TERROR" -> Genre.HORROR;
            default -> null;
        };
    }

    @Named("genreToGenero")
    public static String genreToGenero(Genre genre) {

        if(genre == null)
            return null;

        return switch(genre){
            case ANIMATED -> "ANIMADA";
            case SCI_FIC -> "CIENCIA_FICCION";
            case DRAMA -> "DRAMA";
            case ACTION -> "ACCION";
            case HORROR -> "TERROR";
            default -> null;
        };
    }
}
