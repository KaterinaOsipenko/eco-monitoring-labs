package com.example.ecomonitoringlabs.controller;

import com.example.ecomonitoringlabs.service.ObjectTaxService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/lab2")
public class Lab2Controller {

    @Autowired
    private ObjectTaxService objectTaxService;

    @GetMapping("/list")
    public String getTaxesForObjects(Model model) {
        log.info("La21Controller: get request");
        model.addAttribute("objectsTax", objectTaxService.findAll());
        return "lab2";
    }
}
