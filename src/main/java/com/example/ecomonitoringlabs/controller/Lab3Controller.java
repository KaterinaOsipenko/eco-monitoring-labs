package com.example.ecomonitoringlabs.controller;

import com.example.ecomonitoringlabs.service.ObjectKoncerogenService;
import com.example.ecomonitoringlabs.service.ObjectNotKoncerogenService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/lab3")
public class Lab3Controller {

    @Autowired
    private ObjectNotKoncerogenService notKoncerogenService;

    @Autowired
    private ObjectKoncerogenService koncerogenService;

    @GetMapping("/list")
    public String findAllNotKoncerogen(Model model) {
        model.addAttribute("objects", notKoncerogenService.findAllPollution());
        model.addAttribute("name", "Неканцерогенні забруднювачі");
        model.addAttribute("type", "not koncerogen");
        return "lab3";
    }

    @GetMapping("/list/concerogens")
    public String findAllKoncerogen(Model model) {
        model.addAttribute("objects", koncerogenService.findAllPollution());
        model.addAttribute("name", "Канцерогенні забруднювачі");
        model.addAttribute("type", "koncerogen");
        return "lab3";
    }
}
