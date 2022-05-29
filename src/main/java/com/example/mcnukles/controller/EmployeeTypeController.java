package com.example.mcnukles.controller;

import com.example.mcnukles.model.Country;
import com.example.mcnukles.model.EmployeeType;
import com.example.mcnukles.service.EmployeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class EmployeeTypeController {
    @Autowired
    EmployeeTypeService employeeTypeService;

    @GetMapping("/employeeType")
    public String getCountry(Model model){

        model.addAttribute("types", employeeTypeService.getRepo().findAll());

        return "/employeeTypes/employeeType";
    }

    @PostMapping("/insert/employeeType")
    public String insertCountry(@Valid EmployeeType employeeType, RedirectAttributes redirectAttributes){

        if (employeeTypeService.insertValid(employeeType) == 0){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else {
            redirectAttributes.addFlashAttribute("response", "Успішне додавання сутності" + "\n" + employeeType.getType());
            return "redirect:/response";
        }
    }

    @PutMapping("/update/employeeType")
    public String updateCountry(@Valid EmployeeType employeeType, RedirectAttributes redirectAttributes){
        if (employeeTypeService.updateValid(employeeType) == 0){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else{
            redirectAttributes.addFlashAttribute("response", "Успішна зміна сутності" + "\n" + employeeType.getType());
            return "redirect:/response";
        }
    }

    @DeleteMapping("/delete/employeeType")
    public String deleteCountry(@Valid EmployeeType employeeType, RedirectAttributes redirectAttributes){
        if (employeeTypeService.deleteValid(employeeType.getId()) == 0){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else{
            redirectAttributes.addFlashAttribute("response", "Успішне видаення сутності" + " " + employeeType.getId());
            return "redirect:/response";
        }
    }
}
