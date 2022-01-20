package com.jayklef.ricetta.service;

import com.jayklef.ricetta.exception.GenreNotFoundException;
import com.jayklef.ricetta.model.Genre;
import com.jayklef.ricetta.model.Movie;

import java.util.List;

public interface GenreService {
    List<Genre> getGenreList();

    Genre saveGenre(Genre genre);

    Genre getGenreById(Long genreId) throws GenreNotFoundException;

    Genre getGenreByName(String name);
}
