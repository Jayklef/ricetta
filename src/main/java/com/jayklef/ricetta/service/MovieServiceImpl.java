package com.jayklef.ricetta.service;

import com.jayklef.ricetta.exception.ClientNotFoundException;
import com.jayklef.ricetta.exception.MovieNotFoundException;
import com.jayklef.ricetta.model.Genre;
import com.jayklef.ricetta.model.Movie;
import com.jayklef.ricetta.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> findAllMovies() {
        log.info("Inside findAllMovies of MovieServiceImpl Class");
        return movieRepository.findAll();
    }

    @Override
    public Movie saveMovie(Movie movie) {
        log.info("Inside saveMovie of MovieServiceImpl Class");
        return movieRepository.save(movie);
    }

    @Override
    public Movie findByMovieId(Long movieId) throws ClientNotFoundException {
        log.info("Inside findByMovieId of MovieServiceImpl Class");
        Optional<Movie> movie = movieRepository.findById(movieId);

        if (movieId == null){
            throw new ClientNotFoundException("Client not found");
        }
        return movieRepository.findById(movieId).get();
    }

    @Override
    public Movie updateMovie(Long movieId, Movie movie) {
        log.info("Inside updateMovie of MovieServiceImpl Class");
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
    public Movie findByTitle(String title) throws MovieNotFoundException {
        log.info("Inside findByTitle of MovieServiceImpl Class");
        Movie movie = movieRepository.findByTitle(title);

        if (title.isBlank() || title.isEmpty()){
            throw new MovieNotFoundException("Movie does not  exist");
        }
        return movieRepository.findByTitle(title);
    }

    @Override
    public String deleteByMovieId(Long movieId) {
        log.info("Inside deleteByMovieId of MovieServiceImpl Class");
         movieRepository.deleteById(movieId);
        return "Movie removed successfully";
    }

    @Override
    public Movie saveMovieWithGenre() {
        log.info("Inside saveMovieWithGenre of MovieServiceImpl Class");

        Genre genre = Genre.builder()
                .name(toString())
                .build();

        Movie neMovie = Movie.builder()
                .title(toString())
                .dateAdded(LocalDate.now())
                .numberInStock(findAllMovies().stream().count())
                .genre(genre)
                .build();

        return movieRepository.save(neMovie);
    }

    @Override
    public Long calculateTotalMoviesInStock(Long numberInStock) {
        List<Movie> movies = movieRepository.findAll();

        return movies.stream()
                     .count();
    }
}
