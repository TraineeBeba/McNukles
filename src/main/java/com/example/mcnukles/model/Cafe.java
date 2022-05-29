package com.example.mcnukles.model;

import com.example.mcnukles.entity.CountryEntity;
import com.example.mcnukles.entity.DirectorEntity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Cafe {
    @Min(1)
    Long id;

    @NotNull
    @NotEmpty
    String address;

    @NotNull
    @NotEmpty
    CountryEntity country;

    @NotNull
    @NotEmpty
    DirectorEntity director;

    public Cafe() {
    }

    public Cafe(@NotNull @NotEmpty String address,
                @NotNull @NotEmpty CountryEntity country,
                @NotNull @NotEmpty DirectorEntity director) {
        this.address = address;
        this.country = country;
        this.director = director;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }

    public DirectorEntity getDirector() {
        return director;
    }

    public void setDirector(DirectorEntity director) {
        this.director = director;
    }
}
