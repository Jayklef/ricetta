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
mod
@RestController
@RequestMapping("api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    private final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @GetMapping("/list")
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

    @PostMapping("/newmovie")
    public ResponseEntity<Movie> saveMovieWithGenre(){
        LOGGER.info("Inside saveMovieWithGenre of MovieController");
        Movie newMovie = movieService.saveMovieWithGenre();
        return new ResponseEntity<>(newMovie, HttpStatus.CREATED);
    }

    @GetMapping("/{movieid}")
    public ResponseEntity<Movie> getByMovieId(@PathVariable ("movieid") Long movieId) throws ClientNotFoundException {
        LOGGER.info("Inside getByMovieId of MovieController");
       Movie movie =  movieService.findByMovieId(movieId);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PutMapping("/{movieid}")
    public  ResponseEntity<Movie> updateMovie(@PathVariable ("movieid") Long movieId,
                             @RequestBody Movie movie){
        LOGGER.info("Inside getByMovieId of MovieController");
        Movie updateMovie = movieService.updateMovie(movieId, movie);
        return new ResponseEntity<>(updateMovie, HttpStatus.CREATED);
    }

    @GetMapping("/{title}")
    public ResponseEntity<Movie> getByTitle(@PathVariable ("title") String name) throws MovieNotFoundException {
        LOGGER.info("Inside getByTitle of MovieController");
        Movie movie = movieService.findByTitle(name);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @DeleteMapping("/{movieid}")
    public String deleteByMovieId(@PathVariable("movieid") Long movieId){
        LOGGER.info("Inside deleteByMovieId of MovieController");
        movieService.deleteByMovieId(movieId);
        return "Movie deleted successfully";
    }
}
