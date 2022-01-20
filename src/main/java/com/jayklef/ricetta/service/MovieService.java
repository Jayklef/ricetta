package com.jayklef.ricetta.service;

import com.jayklef.ricetta.exception.ClientNotFoundException;
import com.jayklef.ricetta.exception.MovieNotFoundException;
import com.jayklef.ricetta.model.Client;
import com.jayklef.ricetta.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();

    Movie saveMovie(Movie movie);

    Movie getMovieByMovieId(Long movieId) throws ClientNotFoundException;

    Movie updateMovie(Long movieId, Movie movie);

    Movie getMovieByTitle(String title) throws MovieNotFoundException;

    String deleteMovieByMovieId(Long movieId);

}
