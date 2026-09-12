package com.platzi.platzi_play.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.platzi.platzi_play.domain.dto.MovieDto;
import com.platzi.platzi_play.persistence.entity.MovieEntity;

@Mapper(componentModel = "spring", uses = {GenreMapper.class, StateMapper.class})
public interface MovieMapper {

    @Mapping(source = "titulo", target = "title")
    @Mapping(source = "duracion", target = "duration")
    @Mapping(source = "genero", target = "genre", qualifiedByName = "generoToGenre")
    @Mapping(source = "fechaEstreno", target = "releaseDate")
    @Mapping(source = "calificacion", target = "rating")
    @Mapping(source = "estado", target = "state", qualifiedByName = "estadoToState")
    MovieDto toDto(MovieEntity entity);
    List<MovieDto> toDto(Iterable<MovieEntity> entities);
    
}
