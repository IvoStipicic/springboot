package com.alkemy.disney.repository;

import com.alkemy.disney.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findByTitleIgnoreCase(String title);
}
