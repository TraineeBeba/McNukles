package com.example.mcnukles.entity;

import com.example.mcnukles.model.Director;

import javax.persistence.*;

@Entity
public class DirectorEntity extends Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public Long getId() {
        return super.getId();
    }

    public DirectorEntity() {
        super();
    }

    public DirectorEntity(String name, Integer employee) {
        super(name, employee);
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Column(nullable = false)
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Column(nullable = false)
    @Override
    public Integer getExpirience() {
        return super.getExpirience();
    }

    @Override
    public void setExpirience(Integer expirience) {
        super.setExpirience(expirience);
    }
}
