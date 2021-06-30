package com.alkemy.disney.dto;

import com.alkemy.disney.entity.Movie;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class CharacterModifyDto {
    private int id;
    @NotBlank
    private String image;
    private String name;
    private int age;
    private double weight;
    private String history;
    private List<Movie> movies;

    public CharacterModifyDto() {
    }

    public CharacterModifyDto(@NotBlank String image, String name, int age, double weight, String history, List<Movie> movies) {
        this.image = image;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.history = history;
        this.movies = movies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
