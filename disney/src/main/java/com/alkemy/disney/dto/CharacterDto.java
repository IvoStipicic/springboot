package com.alkemy.disney.dto;

import javax.validation.constraints.NotBlank;

public class CharacterDto {

    @NotBlank
    private String name;
    private String image;

    public CharacterDto() {
    }

    public CharacterDto(@NotBlank String name, String image) {
        this.name = name;
        this.image = image;
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
}
