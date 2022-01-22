package com.jayklef.ricetta.service;

import com.jayklef.ricetta.exception.GenreNotFoundException;
import com.jayklef.ricetta.model.Genre;
import com.jayklef.ricetta.model.Movie;
import com.jayklef.ricetta.repository.GenreRepository;
import com.jayklef.ricetta.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class GenreServiceImpl implements GenreService{

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Genre> findGenreList() {
        log.info("Inside findGenreList of GenreServiceImpl Class");
        return genreRepository.findAll();
    }

    @Override
    public Genre saveGenre(Genre genre) {
        log.info("Inside saveGenre of GenreServiceImpl Class");
        return genreRepository.save(genre);
    }

    @Override
    public Genre findByGenreId(Long genreId) throws GenreNotFoundException {
        log.info("Inside findByGenreId of GenreServiceImpl Class");
        Optional<Genre> genre = genreRepository.findById(genreId);

        if (genreId == null){
            throw new GenreNotFoundException("Genre Not found");
        }
        return genreRepository.findById(genreId).get();
    }

    @Override
    public Genre findByName(String name) {
        log.info("Inside findByName of GenreServiceImpl Class");
        return genreRepository.findByName(name);
    }

}