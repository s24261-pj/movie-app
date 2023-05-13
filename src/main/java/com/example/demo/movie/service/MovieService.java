package com.example.demo.movie.service;

import com.example.demo.movie.exception.BadRequestException;
import com.example.demo.movie.exception.NotFoundException;
import com.example.demo.movie.model.Movie;
import com.example.demo.movie.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    public Movie getById(long movieId) {
        Optional<Movie> movie = movieRepository.findById(movieId);

        if (movie.isEmpty()) {
            throw new NotFoundException("Not found");
        }

        return movie.get();
    }

    public Movie create(Movie movie) {
        if (movie == null) {
            throw new BadRequestException("Incorrect data");
        }

        return movieRepository.save(movie);
    }

    public Movie update(long movieId, Movie movie) {
        Optional<Movie> movieToUpdate = movieRepository.findById(movieId);

        if (movieToUpdate.isEmpty()) {
            throw new NotFoundException("Not found");
        }

        if (movie.getName() == null) {
            throw new BadRequestException("Incorrect data");
        }

        return movieRepository.save(movie);
    }

    public void delete(long movieId) {
        movieRepository.deleteById(movieId);
    }

    public Movie setAvailable(long movieId, boolean isAvailable) {
        Optional<Movie> movieToUpdate = movieRepository.findById(movieId);

        if (movieToUpdate.isEmpty()) {
            throw new NotFoundException("Not found");
        }

        movieToUpdate.get().setAvailable(isAvailable);

        return movieRepository.save(movieToUpdate.get());
    }
}
