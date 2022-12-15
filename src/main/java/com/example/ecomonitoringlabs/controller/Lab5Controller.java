package com.example.ecomonitoringlabs.controller;

import com.example.ecomonitoringlabs.service.ObjectPollutionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/lab5")
public class Lab5Controller {

    @Autowired
    private ObjectPollutionService service;

    @GetMapping("/list")
    public String findAllNotKoncerogen(Model model) {
        model.addAttribute("objects", service.findAllLoss());
        model.addAttribute("name", "Відшкодування збитків в результаті наднормативних викидів забруднюючих речовин в атмосферне повітря ");
        return "lab5";
    }
}
