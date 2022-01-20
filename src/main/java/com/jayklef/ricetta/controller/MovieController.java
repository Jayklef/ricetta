package com.jayklef.ricetta.controller;

import com.jayklef.ricetta.exception.ClientNotFoundException;
import com.jayklef.ricetta.exception.MovieNotFoundException;
import com.jayklef.ricetta.model.Movie;
import com.jayklef.ricetta.service.GenreService;
import com.jayklef.ricetta.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    private final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies(){
        LOGGER.info("Inside getAllMovies of MovieController");
        List<Movie> movieList = movieService.findAllMovies();
        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    @PostMapping("/movies")
    public Movie saveMovie(@Valid @RequestBody Movie movie){
        LOGGER.info("Inside sameMovie of MovieController");
        return movieService.saveMovie(movie);
    }

    @GetMapping("/movies/{movieid}")
    public Movie getMovieByMovieId(@PathVariable ("movieid") Long movieId) throws ClientNotFoundException {
        return movieService.getMovieByMovieId(movieId);
    }

    @PutMapping("/movies/{movieid}")
    public Movie updateMovie(@PathVariable ("movieid") Long movieId,
                             @RequestBody Movie movie){
        return movieService.updateMovie(movieId, movie);
    }

    @GetMapping("/movies/{title}")
    public Movie getMovieByTitle(@PathVariable ("title") String name) throws MovieNotFoundException {
        return movieService.getMovieByTitle(name);
    }

    @DeleteMapping("/movies/{movieid}")
    public String deleteMovieByMovieId(@PathVariable("movieid") Long movieId){
        movieService.deleteMovieByMovieId(movieId);
        return "Movie deleted successfully";
    }
}
