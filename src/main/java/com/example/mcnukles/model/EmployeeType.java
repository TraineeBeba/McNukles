package com.example.mcnukles.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EmployeeType {
    @Min(1)
    Long id;

    @NotNull
    @NotEmpty
    String type;

    public EmployeeType() {
    }

    public EmployeeType(@NotNull @NotEmpty String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
