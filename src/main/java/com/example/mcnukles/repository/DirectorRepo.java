package com.example.mcnukles.repository;

import com.example.mcnukles.entity.DirectorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepo extends CrudRepository<DirectorEntity, Long> {
}
