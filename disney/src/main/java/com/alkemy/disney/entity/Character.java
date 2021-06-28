package com.alkemy.disney.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="personage")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column()
    private String image;
    @Column()
    private String name;
    @Column()
    private int age;
    @Column()
    private double weight;
    @Column()
    private String history;
    @JoinTable(
            name = "rel_personages_movies",
            joinColumns = @JoinColumn(name = "FK_PERSONAGE", nullable = false),
            inverseJoinColumns = @JoinColumn(name="FK_MOVIE", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Movie> movies;

    public Character(List<Movie> movies) {
        this.movies = movies;
    }

    public Character() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void addMovie(Movie movie){
        this.movies.add(movie);
    }
}
