package com.platzi.platzi_play.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.platzi_play.domain.dto.MovieDto;
import com.platzi.platzi_play.domain.service.MovieService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController 
@RequestMapping("/movies")
public class MovieController {
    
    private final MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }
    @GetMapping
    public ResponseEntity<List<MovieDto>> getAll() {
        return  ResponseEntity.ok(this.movieService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getById(@PathVariable long id) {
        MovieDto movieDto = this.movieService.getById(id);
        if(movieDto != null) {
            return ResponseEntity.ok(movieDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<MovieDto> add(@RequestBody MovieDto movieDto) {
        MovieDto response = this.movieService.save(movieDto);

        if (response != null) {
            return  ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            return ResponseEntity.badRequest().build();
        }
        
    }
    
    
    
}
