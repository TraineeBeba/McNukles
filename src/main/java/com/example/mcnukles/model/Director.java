package com.example.mcnukles.model;

import com.example.mcnukles.entity.EmployeeEntity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Director {
    @Min(1)
    Long id;

    @NotNull
    @NotEmpty
    String name;

    @NotEmpty
    @NotNull
    int expirience;

    public Director() {
    }

    public Director(@NotEmpty @NotNull String name,
                    @NotEmpty @NotNull Integer expirience) {
        this.name = name;
        this.expirience = expirience;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getExpirience() {
        return expirience;
    }

    public void setExpirience(Integer expirience) {
        this.expirience = expirience;
    }
}
