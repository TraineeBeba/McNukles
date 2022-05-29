package com.example.mcnukles.service;

import com.example.mcnukles.entity.CountryEntity;
import com.example.mcnukles.entity.EmployeeEntity;
import com.example.mcnukles.model.Country;
import com.example.mcnukles.model.Employee;
import com.example.mcnukles.repository.CountryRepo;
import com.example.mcnukles.repository.EmployeeRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    public EmployeeRepo getRepo() {
        return employeeRepo;
    }

    public int insertValid(Employee employee) {
        employeeRepo.save(new EmployeeEntity(employee.getName(),employee.getType(),employee.getCafe()));
        return 1;
    }

    public int updateValid(Employee employee) {
        EmployeeEntity entity = employeeRepo.findById(employee.getId()).get();
        EmployeeEntity returnEntity = new EmployeeEntity(employee.getName(),employee.getType(),employee.getCafe());
        BeanUtils.copyProperties(returnEntity, entity, "id");
        employeeRepo.save(entity);
        return 1;
    }

    public int deleteValid(Long id) {
        if(employeeRepo.existsById(id)){
            employeeRepo.deleteById(id);
            return 1;
        }
        return 0;
    }
}
