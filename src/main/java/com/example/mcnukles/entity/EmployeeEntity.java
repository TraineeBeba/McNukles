package com.example.mcnukles.entity;

import com.example.mcnukles.model.Employee;

import javax.persistence.*;

@Entity
public class EmployeeEntity extends Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public Long getId() {
        return super.getId();
    }

    public EmployeeEntity() {
        super();
    }

    public EmployeeEntity(String name, EmployeeTypeEntity type, CafeEntity cafe) {
        super(name, type, cafe);
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

    @ManyToOne
    @Override
    public EmployeeTypeEntity getType() {
        return super.getType();
    }

    @Override
    public void setType(EmployeeTypeEntity type) {
        super.setType(type);
    }

    @ManyToOne
    @Override
    public CafeEntity getCafe() {
        return super.getCafe();
    }

    @Override
    public void setCafe(CafeEntity cafe) {
        super.setCafe(cafe);
    }
}
