package com.example.mcnukles.controller;

import com.example.mcnukles.model.Country;
import com.example.mcnukles.service.CountryService;
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
public class CountryController {
    @Autowired
    CountryService countryService;

    @GetMapping("/country")
    public String getCountry(Model model){

        model.addAttribute("countries", countryService.getRepo().findAll());

        return "/countries/country";
    }

    @PostMapping("/insert/country")
    public String insertCountry(@Valid Country country, RedirectAttributes redirectAttributes){

        if (countryService.insertValid(country) == 0){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else {
            redirectAttributes.addFlashAttribute("response", "Успішне додавання сутності" + "\n" + country.getName());
            return "redirect:/response";
        }
    }

    @PutMapping("/update/country")
    public String updateCountry(@Valid Country country, RedirectAttributes redirectAttributes){
        if (countryService.updateValid(country) == 0){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else{
            redirectAttributes.addFlashAttribute("response", "Успішна зміна сутності" + "\n" + country.getName());
            return "redirect:/response";
        }
    }

    @DeleteMapping("/delete/country")
    public String deleteCountry(@Valid Country country, RedirectAttributes redirectAttributes){
        if (countryService.deleteValid(country.getId()) == 0){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else{
            redirectAttributes.addFlashAttribute("response", "Успішне видаення сутності" + " " + country.getId());
            return "redirect:/response";
        }
    }
}
