package com.platzi.platzi_play.domain.dto;

import java.time.LocalDate;

import com.platzi.platzi_play.domain.Genre;

public record MovieDto(
        String title,
        Integer duration,
        Genre genre,
        LocalDate releaseDate,
        Double rating,
        Boolean state
) {
}
