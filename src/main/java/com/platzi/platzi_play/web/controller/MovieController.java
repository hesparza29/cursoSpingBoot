package com.platzi.platzi_play.web.controller;

import org.springframework.web.bind.annotation.RestController;

import com.platzi.platzi_play.persistence.crud.CrudMovieEntity;
import com.platzi.platzi_play.persistence.entity.MovieEntity;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
public class MovieController {
    
    private final CrudMovieEntity crudMovieEntity;

    public MovieController(CrudMovieEntity crudMovieEntity){
        this.crudMovieEntity = crudMovieEntity;
    }
    @GetMapping("/movies")
    public List<MovieEntity> getAll() {
        return (List<MovieEntity>)this.crudMovieEntity.findAll();
    }
    
}
