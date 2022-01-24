package com.jayklef.ricetta.utility;

import com.jayklef.ricetta.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Slf4j
public class MovieUtility {

    @Autowired
    private MovieService movieService;


    public ResponseEntity<Long> calculateTotalMoviesInStock(Long numberInStock){
        log.info("Inside calculateTotalMoviesInStock of MovieUtility");
        Long totalMovies = movieService.calculateTotalMoviesInStock(numberInStock);
        return new ResponseEntity<>(totalMovies, HttpStatus.OK);
    }
}
