package com.example.mcnukles.model;

import com.example.mcnukles.entity.CafeEntity;
import com.example.mcnukles.entity.EmployeeTypeEntity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Employee {
    @Min(1)
    Long id;

    @NotNull
    @NotEmpty
    String name;

    @NotNull
    @NotEmpty
    EmployeeTypeEntity type;

    @NotNull
    @NotEmpty
    CafeEntity cafe;

    public Employee() {
    }

    public Employee(@NotNull @NotEmpty String name,
                    @NotNull @NotEmpty EmployeeTypeEntity type,
                    @NotNull @NotEmpty CafeEntity cafe) {
        this.name = name;
        this.type = type;
        this.cafe = cafe;
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

    public EmployeeTypeEntity getType() {
        return type;
    }

    public void setType(EmployeeTypeEntity type) {
        this.type = type;
    }

    public CafeEntity getCafe() {
        return cafe;
    }

    public void setCafe(CafeEntity cafe) {
        this.cafe = cafe;
    }
}
