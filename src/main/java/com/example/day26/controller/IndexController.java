package com.example.day26.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.day26.service.TvShowService;

@Controller
@RequestMapping(path = {"/", "/index.html"})
public class IndexController {
    

    @Autowired
    private TvShowService tvshowSvc;
    
    @GetMapping
    public String getIndex(Model model) {
        List<String> showTypes = tvshowSvc.getTypes();
        model.addAttribute("showTypes", showTypes);
        return "index";
    }
}
