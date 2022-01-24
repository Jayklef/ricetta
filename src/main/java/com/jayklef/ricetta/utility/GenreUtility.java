package com.jayklef.ricetta.utility;

import com.jayklef.ricetta.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GenreUtility {

    @Autowired
    private GenreService genreService;

    public ResponseEntity<Long> calculateTotalNumberOfGenres(Long numberOfGenre){
        Long totalGenre = genreService.calculateTotalNumberOfGenres(numberOfGenre);
        return new ResponseEntity<>(totalGenre, HttpStatus.OK);
    }
}
