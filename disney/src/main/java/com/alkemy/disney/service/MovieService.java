package com.alkemy.disney.service;

import com.alkemy.disney.dto.MovieDto;
import com.alkemy.disney.entity.Movie;
import java.util.List;

public interface MovieService {

    List<MovieDto> getAll();
    Movie getMovie(int id);
    Movie createMovie(Movie movie);
    void deleteMovie(int id);
    List<Movie> lookForName(String name);
}
