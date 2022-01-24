package com.jayklef.ricetta.service;

import com.jayklef.ricetta.exception.ClientNotFoundException;
import com.jayklef.ricetta.exception.MovieNotFoundException;
import com.jayklef.ricetta.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAllMovies();

    Movie saveMovie(Movie movie);

    Movie findByMovieId(Long movieId) throws ClientNotFoundException;

    Movie updateMovie(Long movieId, Movie movie);

    Movie findByTitle(String title) throws MovieNotFoundException;

    String deleteByMovieId(Long movieId);

    Movie saveMovieWithGenre();

    Long calculateTotalMoviesInStock(Long numberInStock);
}
