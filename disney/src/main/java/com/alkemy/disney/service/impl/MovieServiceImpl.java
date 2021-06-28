package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.MovieDto;
import com.alkemy.disney.entity.Movie;
import com.alkemy.disney.repository.MovieRepository;
import com.alkemy.disney.service.MovieService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public List<MovieDto> getAll() {
        List<Movie> movies = movieRepository.findAll();
        ArrayList<MovieDto> movieDtos = new ArrayList<MovieDto>();
        for(Movie movie : movies){
            movieDtos.add(new MovieDto(movie.getImage(), movie.getTitle(), movie.getCreationDate()));
        }
        return movieDtos;
    }

    @Override
    public Movie getMovie(int id) {
        return movieRepository.findById(id).orElseThrow();
    }

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(int id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if(movie != null) {
            movieRepository.deleteById(id);
        }
    }

    @Override
    public List<Movie> lookForName(String title) {
        return movieRepository.findByTitleIgnoreCase(title);
    }
}
