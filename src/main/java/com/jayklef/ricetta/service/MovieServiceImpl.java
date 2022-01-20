package com.jayklef.ricetta.service;

import com.jayklef.ricetta.exception.ClientNotFoundException;
import com.jayklef.ricetta.exception.MovieNotFoundException;
import com.jayklef.ricetta.model.Client;
import com.jayklef.ricetta.model.Movie;
import com.jayklef.ricetta.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie getMovieByMovieId(Long movieId) throws ClientNotFoundException {
        Optional<Movie> movie = movieRepository.findById(movieId);

        if (movieId == null){
            throw new ClientNotFoundException("Client not found");
        }
        return movieRepository.findById(movieId).get();
    }

    @Override
    public Movie updateMovie(Long movieId, Movie movie) {
        Movie movieInDb = movieRepository.findById(movieId).get();

        if (Objects.nonNull(movie.getTitle()) &&
        !"".equalsIgnoreCase(movie.getTitle())){
            movieInDb.setTitle(movie.getTitle());
        }

        if (Objects.nonNull(movie.getDateAdded())&&
            !"".equalsIgnoreCase(movie.getDateAdded().toString())){
            movieInDb.setDateAdded(movie.getDateAdded());
        }

        if (Objects.nonNull(movie.getNumberInStock()) &&
                !"".equalsIgnoreCase(movie.getNumberInStock().toString())){
            movieInDb.setNumberInStock(movie.getNumberInStock());
        }

        return movieRepository.save(movieInDb);
    }

    @Override
    public Movie getMovieByTitle(String title) throws MovieNotFoundException {
        Movie movie = movieRepository.findMovieByTitle(title);

        if (title.isBlank() || title.isEmpty()){
            throw new MovieNotFoundException("Movie does not  exist");
        }
        return movieRepository.findMovieByTitle(title);
    }

    @Override
    public String deleteMovieByMovieId(Long movieId) {
         movieRepository.deleteById(movieId);
        return "Movie removed successfully";
    }
}
