package com.platzi.platzi_play.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.platzi_play.domain.dto.MovieDto;
import com.platzi.platzi_play.domain.dto.SuggestRequestDto;
import com.platzi.platzi_play.domain.dto.UpdateMovieDto;
import com.platzi.platzi_play.domain.service.MovieService;
import com.platzi.platzi_play.domain.service.PlatziPlayAiService;

@RestController 
@RequestMapping("/movies")
public class MovieController {
    
    private final MovieService movieService;

    private final PlatziPlayAiService aiService;

    public MovieController(MovieService movieService,
                            PlatziPlayAiService platziPlayAiService
    ){
        this.movieService = movieService;
        this.aiService = platziPlayAiService;
    }
    @GetMapping
    public ResponseEntity<List<MovieDto>> getAll() {
        return  ResponseEntity.ok(this.movieService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getById(@PathVariable long id) {
        return ResponseEntity.ok(this.movieService.getById(id));
    }

    @PostMapping("/suggest")
    public ResponseEntity<String> generateMoviesSuggestion(@RequestBody SuggestRequestDto suggestRequestDto) {
        return ResponseEntity.ok(this.aiService.genereteMoviesSuggestion(suggestRequestDto.userPreference()));
    }
    
    @PostMapping
    public ResponseEntity<MovieDto> add(@RequestBody MovieDto movieDto) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(this.movieService.save(movieDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> update(@PathVariable long id, @RequestBody UpdateMovieDto updateMovieDto) {
        return ResponseEntity.ok(this.movieService.update(id, updateMovieDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        this.movieService.delete(id);
        return ResponseEntity.ok().build();
    }
    
}
