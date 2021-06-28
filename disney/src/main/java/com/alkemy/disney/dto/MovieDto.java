package com.alkemy.disney.dto;

import java.sql.Date;

public class MovieDto {

    private String image;
    private String title;
    private Date creationDate;

    public MovieDto() {
    }

    public MovieDto(String image, String title, Date creationDate) {
        this.image = image;
        this.title = title;
        this.creationDate = creationDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
}
