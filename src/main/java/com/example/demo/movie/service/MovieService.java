package com.example.demo.movie.service;

import com.example.demo.movie.exception.BadRequestException;
import com.example.demo.movie.exception.NotFoundException;
import com.example.demo.movie.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    public List<Movie> getAll() {
        return List.of();
    }

    public Movie getById(int movieId) {
        Movie movie = null;

        if (movie == null) {
            throw new NotFoundException("Not found");
        }

        return movie;
    }

    public Movie create(Movie movie) {
        movie = null;

        if (movie == null) {
            throw new BadRequestException("Incorrect data");
        }

        return movie;
    }

    public Movie update(int movieId, Movie movie) {
        Movie newMovie = getById(movieId);

        if (newMovie == null) {
            throw new BadRequestException("Incorrect data");
        }

        return newMovie;
    }

    public void delete(int movieId) {}
}
