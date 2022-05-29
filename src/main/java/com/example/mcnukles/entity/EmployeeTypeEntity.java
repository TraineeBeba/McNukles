package com.example.mcnukles.entity;

import com.example.mcnukles.model.EmployeeType;

import javax.persistence.*;

@Entity
public class EmployeeTypeEntity extends EmployeeType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public Long getId() {
        return super.getId();
    }

    public EmployeeTypeEntity() {
        super();
    }

    public EmployeeTypeEntity(String type) {
        super(type);
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Column(nullable = false, unique = true)
    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public void setType(String type) {
        super.setType(type);
    }
}
