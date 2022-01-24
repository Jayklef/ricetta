package com.jayklef.ricetta.service;

import com.jayklef.ricetta.exception.GenreNotFoundException;
import com.jayklef.ricetta.model.Genre;
import com.jayklef.ricetta.model.Movie;

import java.util.List;

public interface GenreService {
    List<Genre> findGenreList();

    Genre saveGenre(Genre genre);

    Genre findByGenreId(Long genreId) throws GenreNotFoundException;

    Genre findByName(String name);

    Long calculateTotalNumberOfGenres(Long numberOfGenre);
}
