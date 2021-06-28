package com.alkemy.disney.controller.rest;

import com.alkemy.disney.dto.MovieDto;
import com.alkemy.disney.entity.Movie;
import com.alkemy.disney.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/movies")
public class MovieRestController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MovieDto> getAll() {
        return movieService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Movie lookWithId(@PathVariable int id){
        return movieService.getMovie(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie createMovie(@RequestBody Movie movie){
        return movieService.createMovie(movie);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable(value = "id") int id){
        movieService.deleteMovie(id);
    }

    @GetMapping("/name")
    public  @ResponseBody List<Movie> getMovieName(@RequestParam("name") String name){
        return movieService.lookForName(name);
    }
}
