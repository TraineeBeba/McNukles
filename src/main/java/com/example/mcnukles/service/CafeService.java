package com.example.mcnukles.service;

import com.example.mcnukles.entity.CafeEntity;
import com.example.mcnukles.entity.CountryEntity;
import com.example.mcnukles.model.Cafe;
import com.example.mcnukles.model.Country;
import com.example.mcnukles.repository.CafeRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

@Service
public class CafeService {
    @Autowired
    CafeRepo cafeRepo;

    public CafeRepo getRepo() {
        return cafeRepo;
    }

    public int insertValid(Cafe cafe) {
        if (cafeRepo.findByDirectorId(cafe.getDirector().getId()) != null) {
            return 0;
        }
        if (cafeRepo.findByCountryIdAndAddress(cafe.getCountry().getId(), cafe.getAddress()) != null) {
            return 0;
        }
        cafeRepo.save(new CafeEntity(cafe.getAddress(), cafe.getCountry(), cafe.getDirector()));
        return 1;
    }

    public int updateValid(Cafe cafe) {
        if (!cafeRepo.existsById(cafe.getId())) {
            return 0;
        }
        CafeEntity entity = cafeRepo.findById(cafe.getId()).get();
        CafeEntity returnEntity = new CafeEntity(cafe.getAddress(), cafe.getCountry(), cafe.getDirector());

        if (returnEntity.getCountry().getName().equals(entity.getCountry().getName())){
            if(returnEntity.getAddress().equals(entity.getAddress())){
                if(returnEntity.getDirector().getId().equals(entity.getDirector().getId())){
                    return 0;
                }
                if (cafeRepo.findByDirectorId(cafe.getDirector().getId()) != null) {
                    return 0;
                }
            }
            if (cafeRepo.findByCountryIdAndAddress(cafe.getCountry().getId(), cafe.getAddress()) != null) {
                return 0;
            }

            BeanUtils.copyProperties(returnEntity, entity, "id");
            cafeRepo.save(entity);
            return 1;
        }

        BeanUtils.copyProperties(returnEntity, entity, "id");
        cafeRepo.save(entity);
        return 1;
    }

    public int deleteValid(Long id) {
        if(cafeRepo.existsById(id)){
            cafeRepo.deleteById(id);
            return 1;
        }
        return 0;
    }
}
