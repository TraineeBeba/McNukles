package com.example.mcnukles.entity;

import com.example.mcnukles.model.Cafe;

import javax.persistence.*;

@Entity
public class CafeEntity extends Cafe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public Long getId() {
        return super.getId();
    }

    public CafeEntity() {
        super();
    }

    public CafeEntity(String address, CountryEntity country, DirectorEntity director) {
        super(address, country, director);
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Column(nullable = false)
    @Override
    public String getAddress() {
        return super.getAddress();
    }

    @Override
    public void setAddress(String address) {
        super.setAddress(address);
    }

    @ManyToOne
    @Override
    public CountryEntity getCountry() {
        return super.getCountry();
    }

    @Override
    public void setCountry(CountryEntity country) {
        super.setCountry(country);
    }

    @OneToOne
    @Override
    public DirectorEntity getDirector() {
        return super.getDirector();
    }

    @Override
    public void setDirector(DirectorEntity director) {
        super.setDirector(director);
    }
}
