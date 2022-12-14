package com.example.ecomonitoringlabs.controller;

import com.example.ecomonitoringlabs.service.ObjectProductionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/lab1")
public class Lab1Controller {

    @Autowired
    private ObjectProductionService productionService;

    @GetMapping("/list")
    public String getListOfObjects(Model model) {
        log.info("Lab1Controller: get request");
        model.addAttribute("objectsProd", productionService.findAll());
        return "lab1";
    }
}
