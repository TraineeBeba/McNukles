package com.example.mcnukles.controller;

import com.example.mcnukles.model.Country;
import com.example.mcnukles.model.Director;
import com.example.mcnukles.service.DirectorService;
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
public class DirectorController {
    @Autowired
    DirectorService directorService;

    @GetMapping("/director")
    public String getDirector(Model model){

        model.addAttribute("directors", directorService.getRepo().findAll());

        return "/directors/director";
    }

    @PostMapping("/insert/director")
    public String insertDirector(@Valid Director director, RedirectAttributes redirectAttributes){

        if (directorService.insertValid(director) == 0){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else {
            redirectAttributes.addFlashAttribute("response", "Успішне додавання сутності" + "\n" + director.getName()
                                                                                                                + " зі стажем " + director.getExpirience());
            return "redirect:/response";
        }
    }

    @PutMapping("/update/director")
    public String updateDirector(@Valid Director director, RedirectAttributes redirectAttributes){
        if (directorService.updateValid(director) == 0){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else{
            redirectAttributes.addFlashAttribute("response", "Успішна зміна сутності" + "\n" + director.getName()
                    + " зі стажем " + director.getExpirience());
            return "redirect:/response";
        }
    }

    @DeleteMapping("/delete/director")
    public String deleteDirector(@Valid Director director, RedirectAttributes redirectAttributes){
        if (directorService.deleteValid(director.getId()) == 0){
            redirectAttributes.addFlashAttribute("response", "Сталась помилка");
            return "redirect:/response";
        }else{
            redirectAttributes.addFlashAttribute("response", "Успішне видаення сутності" + " " + director.getId());
            return "redirect:/response";
        }
    }
}
