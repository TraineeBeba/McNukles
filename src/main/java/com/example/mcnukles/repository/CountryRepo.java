package com.example.mcnukles.repository;

import com.example.mcnukles.entity.CountryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends CrudRepository<CountryEntity, Long> {
    CountryEntity findByName(String name);

    boolean existsByName(String name);
}
