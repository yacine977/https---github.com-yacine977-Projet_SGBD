/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller;

import com.example.entity.Jour;
import com.example.entity.SeanceCours;
import com.example.repository.ProfRepository;
import com.example.repository.SeanceCoursRepository;
import jakarta.validation.Valid;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author yacin
 */
@Controller
public class SeanceCoursController {

    @Autowired
    private SeanceCoursRepository SeanceCoursRepository;

    @Autowired
    private ProfRepository ProfRepository;

    @GetMapping("/seancecours")
    public String listSeanceCours(Model model) {
        model.addAttribute("listSeanceCours", SeanceCoursRepository.findAll());
        model.addAttribute("listProf", ProfRepository.findAll());

        return "seancecours"; // returns the view name, ie the Thymele"af template "employees"
    }

    @GetMapping("/seancecours/new")
    public String showNewSeanceCoursForm(Model model) {
        //create model attribute to bind Form data
        SeanceCours seancecours = new SeanceCours();
        model.addAttribute("seancecours", seancecours);
        model.addAttribute("listProf", ProfRepository.findAll());
        return "new_seancecours";
    }

    @PostMapping("/seancecours/saveNew")
    public String saveNewSeanceCours(@ModelAttribute("seancecours") @Valid SeanceCours seancecours, Errors errors, Model model) {
        if (errors.hasErrors()) {
            //model.addAttribute("listProf", ProfRepository.findAll());
            return "new_seancecours";
        }

        SeanceCoursRepository.save(seancecours); //save SeanceCours to DB

        return "redirect:/seancecours";
    }

    @GetMapping("/seancecours/update")
    public String showUpdateSeanceCoursForm(@RequestParam(name = "id") long id, Model model) {
        Optional<SeanceCours> optional = SeanceCoursRepository.findById(id);
        SeanceCours seancecours = null;
        if (optional.isPresent()) {
            seancecours = optional.get();
        } else {
            throw new RuntimeException("SeanceCours not found for id:: " + id);
        }

        model.addAttribute("seancecours", seancecours);
        model.addAttribute("listProf", ProfRepository.findAll());

        return "update_seancecours";
    }

    @PostMapping("/seancecours/saveUpdate")
    public String saveUpdateSeanceCours(@ModelAttribute("seancecours") @Valid SeanceCours seancecours, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("listSeanceCours", SeanceCoursRepository.findAll());
            return "update_seancecours";
        }

        SeanceCoursRepository.save(seancecours);
        return "redirect:/seancecours";
    }

    @GetMapping("/seancecours/delete")
    public String deleteSeanceCours(@RequestParam(name = "id") long id) {

        SeanceCoursRepository.deleteById(id);
        return "redirect:/seancecours";
    }

    @GetMapping("/seancecours/filter1")
    public String viewHomePageFilter1(Model model, @RequestParam(name = "motCle", defaultValue = "") String mc) {
        model.addAttribute("listSeanceCours", SeanceCoursRepository.findBynomCours(mc));

        return "seancecours";
    }

    @GetMapping("/seancecours/filter2")
    public String viewHomePageFilter2(Model model, @RequestParam(name = "motCle", defaultValue = "") Jour mc) {
        model.addAttribute("listSeanceCours", SeanceCoursRepository.findByjour(mc));

        return "seancecours";
    }

}
