package com.example.mcnukles.controller;

import com.example.mcnukles.model.Cafe;
import com.example.mcnukles.model.Country;
import com.example.mcnukles.service.CafeService;
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
public class CafeController {
    @Autowired
    CafeService cafeService;

    @GetMapping("/cafe_brunch")
    public String getCafe(Model model){

        model.addAttribute("cafes", cafeService.getRepo().findAll());

        return "/cafes/cafe";
    }

    @PostMapping("/insert/cafe")
    public String insertCafe(@Valid Cafe cafe, RedirectAttributes redirectAttributes){

        if (cafeService.insertValid(cafe) == 0){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else {
            redirectAttributes.addFlashAttribute("response", "Успішне додавання сутності з адресою " + "\n" + cafe.getAddress()
                    + " та країною " + cafe.getCountry().getName());
            return "redirect:/response";
        }
    }

    @PutMapping("/update/cafe")
    public String updateCafe(@Valid Cafe cafe, RedirectAttributes redirectAttributes){
        if (cafeService.updateValid(cafe) == 0){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else{
            redirectAttributes.addFlashAttribute("response", "Успішна зміна сутності" + "\n" + cafe.getAddress()
                    + " та країною " + cafe.getCountry().getName());
            return "redirect:/response";
        }
    }

    @DeleteMapping("/delete/cafe")
    public String deleteCafe(@Valid Cafe cafe, RedirectAttributes redirectAttributes){
        if (cafeService.deleteValid(cafe.getId()) == 0){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else{
            redirectAttributes.addFlashAttribute("response", "Успішне видаення сутності" + " " + cafe.getId());
            return "redirect:/response";
        }
    }
}
