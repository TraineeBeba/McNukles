package com.example.mcnukles.service;

import com.example.mcnukles.entity.EmployeeTypeEntity;
import com.example.mcnukles.model.EmployeeType;
import com.example.mcnukles.repository.EmployeeTypeRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeTypeService {
    @Autowired
    EmployeeTypeRepo employeeTypeRepo;

    public EmployeeTypeRepo getRepo() {
        return employeeTypeRepo;
    }

    public int insertValid(EmployeeType employeeType) {
        if (employeeTypeRepo.findByType(employeeType.getType()) != null) {
            return 0;
        }
        employeeTypeRepo.save(new EmployeeTypeEntity(employeeType.getType()));
        return 1;
    }

    public int updateValid(EmployeeType employeeType) {
        if (employeeTypeRepo.existsByType(employeeType.getType())) {
            return 0;
        }
        EmployeeTypeEntity entity = employeeTypeRepo.findById(employeeType.getId()).get();
        EmployeeTypeEntity returnEntity = new EmployeeTypeEntity(employeeType.getType());
        BeanUtils.copyProperties(returnEntity, entity, "id");
        employeeTypeRepo.save(entity);
        return 1;
    }

    public int deleteValid(Long id) {
        if(employeeTypeRepo.existsById(id)){
            employeeTypeRepo.deleteById(id);
            return 1;
        }
        return 0;
    }
}
