package com.example.mcnukles.repository;

import com.example.mcnukles.entity.CafeEntity;
import com.example.mcnukles.entity.DirectorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeRepo extends CrudRepository<CafeEntity, Long> {
    CafeEntity findByDirectorId(Long id);

    CafeEntity findByCountryIdAndAddress(Long id, String address);
}
