package com.jayklef.ricetta.controller;

import com.jayklef.ricetta.exception.GenreNotFoundException;
import com.jayklef.ricetta.model.Genre;
import com.jayklef.ricetta.service.GenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class GenreController {

    @Autowired
    private GenreService genreService;

    private Logger LOGGER = LoggerFactory.getLogger(GenreController.class);

    @GetMapping("/genres")
    public ResponseEntity<List<Genre>> getGenreList(){
        LOGGER.info("Inside getGenreList of GenreController");
        List<Genre> genreList = genreService.findGenreList();
       return new ResponseEntity<>(genreList, HttpStatus.OK);
    }

    @PostMapping("/genres")
    public ResponseEntity<Genre> saveGenre(@RequestBody Genre genre){
        LOGGER.info("Inside saveGenre of GenreController");
        Genre newGenre = genreService.saveGenre(genre);
        return new ResponseEntity<>(newGenre, HttpStatus.CREATED);
    }

    @GetMapping("/genres/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable("id") Long genreId) throws GenreNotFoundException {
        LOGGER.info("Inside getGenreById of GenreController");
        Genre genre = genreService.findByGenreId(genreId);
        return new ResponseEntity<>(genre, HttpStatus.OK);
    }

    @GetMapping("/genres/{name}")
    public ResponseEntity<Genre> getByGenreName(@PathVariable("name") String name){
        LOGGER.info("Inside getByGenreName of GenreController");
        Genre genre = genreService.findByName(name);
        return new ResponseEntity<>(genre, HttpStatus.OK);
    }
}
