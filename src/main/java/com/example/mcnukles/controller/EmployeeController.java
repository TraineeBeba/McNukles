package com.example.mcnukles.controller;

import com.example.mcnukles.model.Country;
import com.example.mcnukles.model.Employee;
import com.example.mcnukles.service.EmployeeService;
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
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee")
    public String getEmployee(Model model){

        model.addAttribute("employees", employeeService.getRepo().findAll());

        return "/employees/employee";
    }

    @PostMapping("/insert/employee")
    public String insertEmployee(@Valid Employee employee, RedirectAttributes redirectAttributes){

        if (employeeService.insertValid(employee) == 0){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else {
            redirectAttributes.addFlashAttribute("response", "Успішне додавання сутності" + "\n" + employee.getName());
            return "redirect:/response";
        }
    }

    @PutMapping("/update/employee")
    public String updateEmployee(@Valid Employee employee, RedirectAttributes redirectAttributes){
        if (employeeService.updateValid(employee) == 0){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else{
            redirectAttributes.addFlashAttribute("response", "Успішна зміна сутності" + "\n" + employee.getId());
            return "redirect:/response";
        }
    }

    @DeleteMapping("/delete/employee")
    public String deleteEmployee(@Valid Employee employee, RedirectAttributes redirectAttributes){
        if (employeeService.deleteValid(employee.getId()) == 0){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else{
            redirectAttributes.addFlashAttribute("response", "Успішне видаення сутності" + " " + employee.getId());
            return "redirect:/response";
        }
    }
}
