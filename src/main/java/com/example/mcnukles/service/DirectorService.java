package com.example.mcnukles.service;

import com.example.mcnukles.entity.CountryEntity;
import com.example.mcnukles.entity.DirectorEntity;
import com.example.mcnukles.model.Country;
import com.example.mcnukles.model.Director;
import com.example.mcnukles.repository.DirectorRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

@Service
public class DirectorService {
    @Autowired
    DirectorRepo directorRepo;

    public DirectorRepo getRepo() {
        return directorRepo;
    }

    public int insertValid(Director director) {
        directorRepo.save(new DirectorEntity(director.getName(), director.getExpirience()));
        return 1;
    }

    public int updateValid(Director director) {
        if (!directorRepo.existsById(director.getId())) {
            return 0;
        }
        DirectorEntity entity = directorRepo.findById(director.getId()).get();
        DirectorEntity returnEntity = new DirectorEntity(director.getName(), director.getExpirience());
        BeanUtils.copyProperties(returnEntity, entity, "id");
        directorRepo.save(entity);
        return 1;
    }

    public int deleteValid(Long id) {
        if(directorRepo.existsById(id)){
            directorRepo.deleteById(id);
            return 1;
        }
        return 0;
    }
}
