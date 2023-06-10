package com.example.demo.movie.controller;

import com.example.demo.movie.model.Movie;
import com.example.demo.movie.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Get all movies")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the Movies",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))}
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad gateway",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content
            )
    })
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get movie by id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the Movie by id",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))}
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad gateway",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content
            )
    })
    public ResponseEntity<Movie> getMovieById(@PathVariable(value = "id") long movieId) {

        return ResponseEntity.internalServerError().build();
//        return ResponseEntity.ok(movieService.getById(movieId));
    }

    @PostMapping("/create")
    @Operation(summary = "Create movie")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Movie was created",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))}
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad gateway",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content
            )
    })
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.create(movie));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update movie")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Movie was updated",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))}
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad gateway",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content
            )
    })
    public ResponseEntity<Movie> updateMovie(@PathVariable(value = "id") long movieId, @RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.update(movieId, movie));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete movie")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Movie was deleted"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad gateway",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content
            )
    })
    public ResponseEntity<Void> deleteMovie(@PathVariable(value = "id") long movieId) {
        movieService.delete(movieId);
        return ResponseEntity.status(204).build();
    }

    @PutMapping("/set-available/{id}")
    @Operation(summary = "Set movie as available or unavailable")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Movie available was changed"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad gateway",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not found",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content
            )
    })
    public ResponseEntity<Movie> setAvailable(@PathVariable(value = "id") long movieId, @RequestBody boolean isAvailable) {
        return ResponseEntity.ok(movieService.setAvailable(movieId, isAvailable));
    }
}
