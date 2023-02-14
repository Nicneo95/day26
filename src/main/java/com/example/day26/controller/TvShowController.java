package com.example.day26.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.day26.model.TvShows;
import com.example.day26.service.TvShowService;

@Controller
@RequestMapping(path = "/tvshow")
public class TvShowController {

    @Autowired
    private TvShowService tvshowSvc;

    // GET /tvshow?lang=English
    @GetMapping
    public String getTvShowByLanguage(@RequestParam(defaultValue = "English") String lang, Model model) {

        List<TvShows> results = tvshowSvc.findTvShowsByLanguage(lang);
        model.addAttribute("tvshows", results);
        model.addAttribute("language", lang);

        return "tvShows";
    }

    // GET /tvshow/type/{type}
	 @GetMapping(path="/type/{type}")
	 public String getTvShowByType(@PathVariable String type, Model model) {
		 List<TvShows> results = tvshowSvc.getShowsByType(type);
		 model.addAttribute("tvshows", results);
		 model.addAttribute("showType", type);
		 return "tvshows-listing";
	 }

}
