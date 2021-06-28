package com.alkemy.disney.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column()
    private String title;
    @Column()
    private String image;
    @Column()
    private Date creationDate;
    @Column()
    private int qualification;
    @ManyToMany(mappedBy = "movies")
    private List<Character> characters;
    private final int MIN_QUALIFICATION = 1;
    private final int MAX_QUALIFICATION = 5;

    public Movie(List<Character> characters) {
        this.characters = characters;
    }

    public Movie() {
    }

    public Movie(int id, String title, String image, Date creationDate, int qualification, List<Character> characters) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.creationDate = creationDate;
        this.qualification = qualification;
        this.characters = characters;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getQualification() {
        return qualification;
    }

    public void setQualification(int qualification) {
        if(qualification < MIN_QUALIFICATION || qualification > MAX_QUALIFICATION) {
            throw new IllegalArgumentException("La calificacion debe estar comprendida entre 1 a 5 inclusive");
        }
        this.qualification = qualification;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public void addCharacter(Character character){
        this.characters.add(character);
    }
}
