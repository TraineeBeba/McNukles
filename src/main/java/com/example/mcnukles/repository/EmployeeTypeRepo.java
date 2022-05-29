package com.example.mcnukles.repository;

import com.example.mcnukles.entity.EmployeeTypeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeTypeRepo extends CrudRepository<EmployeeTypeEntity, Long> {
    EmployeeTypeEntity findByType(String type);

    boolean existsByType(String type);
}
