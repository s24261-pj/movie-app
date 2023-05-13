package com.example.demo.movie.controller;

import com.example.demo.movie.model.Movie;
import com.example.demo.movie.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieRestController {
    private final MovieService movieService;

    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable(value="id") long movieId) {
        return ResponseEntity.ok(movieService.getById(movieId));
    }

    @PostMapping("/create")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.create(movie));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable(value="id") long movieId, @RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.update(movieId, movie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable(value="id") long movieId) {
        movieService.delete(movieId);
        return ResponseEntity.status(204).build();
    }

    @PutMapping("/set-available/{id}")
    public ResponseEntity<Movie> setAvailable(@PathVariable(value="id") long movieId, @RequestBody boolean isAvailable) {
        return ResponseEntity.ok(movieService.setAvailable(movieId, isAvailable));
    }
}
