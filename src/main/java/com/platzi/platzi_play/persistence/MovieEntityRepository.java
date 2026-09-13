package com.platzi.platzi_play.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.platzi.platzi_play.domain.dto.MovieDto;
import com.platzi.platzi_play.domain.dto.UpdateMovieDto;
import com.platzi.platzi_play.domain.exception.MovieAlreadyExistsException;
import com.platzi.platzi_play.domain.exception.MovieNoExistsException;
import com.platzi.platzi_play.domain.repository.MovieRepository;
import com.platzi.platzi_play.persistence.crud.CrudMovieEntity;
import com.platzi.platzi_play.persistence.entity.MovieEntity;
import com.platzi.platzi_play.persistence.mapper.MovieMapper;

@Repository 
public class MovieEntityRepository implements MovieRepository {

    private final CrudMovieEntity crudMovieEntity;

    private final MovieMapper movieMapper;

    public MovieEntityRepository(CrudMovieEntity crudMovieEntity,
                                    MovieMapper movieMapper
    ) {
        this.crudMovieEntity = crudMovieEntity;
        this.movieMapper = movieMapper;
    }

    @Override
    public List<MovieDto> getAll() {
        return this.movieMapper.toDto(this.crudMovieEntity.findAll());
    }

    @Override
    public MovieDto getById(long id) {
        MovieEntity entity = this.crudMovieEntity.findById(id).orElse(null);

        if (entity == null) {
            throw new MovieNoExistsException(id);
        }

        return this.movieMapper.toDto(entity);
    }

    @Override
    public MovieDto save(MovieDto movieDto) {
        MovieEntity movieEntityValidation = this.crudMovieEntity.findByTitulo(movieDto.title());

        if (movieEntityValidation != null)
            throw new MovieAlreadyExistsException(movieDto.title());

        MovieEntity movieEntity = this.movieMapper.toEntity(movieDto);

        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }

    @Override
    public MovieDto update(long id, UpdateMovieDto updateMovieDto) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);

        if (movieEntity == null)
            throw new MovieNoExistsException(id);

        this.movieMapper.updateEntityFromDto(updateMovieDto, movieEntity);

        return this.movieMapper.toDto(this.crudMovieEntity.save(movieEntity));
    }

    @Override
    public void delete(long id) {
        MovieEntity movieEntity = this.crudMovieEntity.findById(id).orElse(null);

        if (movieEntity != null) {
            this.crudMovieEntity.deleteById(id);
        } else {
            throw new MovieNoExistsException(id);
        }
    }
    
}
