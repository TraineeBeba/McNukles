package com.example.mcnukles.repository;

import com.example.mcnukles.entity.CountryEntity;
import com.example.mcnukles.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends CrudRepository<EmployeeEntity, Long> {
}
