package com.example.demo.movie.repository;

import com.example.demo.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAll();

    Optional<Movie> findById(long movieId);

    Movie save(Movie movie);

    void deleteById(long movieId);
}
