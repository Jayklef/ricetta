package com.jayklef.ricetta.controller;

import com.jayklef.ricetta.exception.GenreNotFoundException;
import com.jayklef.ricetta.model.Genre;
import com.jayklef.ricetta.service.GenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Genre> getGenreList(){
        LOGGER.info("Inside getGenreList of GenreController");
       return genreService.getGenreList();
    }

    @PostMapping("/genres")
    public Genre saveGenre(@RequestBody Genre genre){
        LOGGER.info("Inside saveGenre of GenreController");
        return genreService.saveGenre(genre);
    }

    @GetMapping("/genres/{id}")
    public Genre getGenreById(@PathVariable("id") Long genreId) throws GenreNotFoundException {;
        return genreService.getGenreById(genreId);
    }

    @GetMapping("/genres/{name}")
    public Genre getGenreByName(@PathVariable("name") String name){
        return genreService.getGenreByName(name);
    }
}
