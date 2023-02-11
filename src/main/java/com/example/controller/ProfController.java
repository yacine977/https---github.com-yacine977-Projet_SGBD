/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller;

import com.example.entity.Prof;

import com.example.repository.ProfRepository;
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

@Controller
public class ProfController {

    @Autowired
    private ProfRepository ProfRepository;

    @GetMapping("/prof")
    public String listProf(Model model) {
        model.addAttribute("listProf", ProfRepository.findAll());
        return "prof";
    }

    @GetMapping("/prof/new")
    public String showNewProfForm(Model model) {

        Prof prof = new Prof();
        model.addAttribute("prof", prof);
        return "new_prof";
    }

    @PostMapping("/prof/saveNew")
    public String saveNewProf(@ModelAttribute("prof") @Valid Prof prof, Errors errors) {
        if (errors.hasErrors()) {
            return "new_prof";
        }

        ProfRepository.save(prof);
        return "redirect:/prof";
    }

    @GetMapping("/prof/update")
    public String showUpdateProfForm(@RequestParam(name = "id") long id, Model model) {
        Optional<Prof> optional = ProfRepository.findById(id);
        Prof prof = null;
        if (optional.isPresent()) {
            prof = optional.get();
        } else {
            throw new RuntimeException("Prof not found for id:: " + id);
        }

        model.addAttribute("prof", prof);
        return "update_prof";
    }

    @PostMapping("/prof/saveUpdate")
    public String saveUpdateProf(@ModelAttribute("prof") @Valid Prof prof, Errors errors) {
        if (errors.hasErrors()) {
            return "update_prof";
        }

        ProfRepository.save(prof);
        return "redirect:/prof";
    }

    @GetMapping("/prof/delete")
    public String deleteProf(@RequestParam(name = "id") long id, Model model) {

        ProfRepository.deleteById(id);
        return "redirect:/prof";
    }

}
