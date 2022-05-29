package com.example.mcnukles.service;

import com.example.mcnukles.entity.CountryEntity;
import com.example.mcnukles.model.Country;
import com.example.mcnukles.repository.CountryRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    @Autowired
    private CountryRepo countryRepo;

    public CountryRepo getRepo() {
        return countryRepo;
    }

    public int insertValid(Country country) {
        if (countryRepo.findByName(country.getName()) != null) {
            return 0;
        }
        countryRepo.save(new CountryEntity(country.getName()));
        return 1;
    }

    public int updateValid(Country country) {
        if (countryRepo.existsByName(country.getName())) {
            return 0;
        }
        CountryEntity entity = countryRepo.findById(country.getId()).get();
        CountryEntity returnEntity = new CountryEntity(country.getName());
        BeanUtils.copyProperties(returnEntity, entity, "id");
        countryRepo.save(entity);
        return 1;
    }

    public int deleteValid(Long id) {
        if(countryRepo.existsById(id)){
            countryRepo.deleteById(id);
            return 1;
        }
        return 0;
    }
}
