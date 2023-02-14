package com.example.day26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.day26.model.TvShows;
import com.example.day26.repository.TvShowsRepository;

@Service
public class TvShowService {

    @Autowired
    private TvShowsRepository tvShowRepo;

    public List<TvShows> findTvShowsByLanguage(String lang) {
        return tvShowRepo.findTvShowsByLanguage(lang)
                .stream()
                .map(v -> TvShows.create(v))
                .toList();
    }

    public List<String> getTypes() {
        return tvShowRepo.getTypes();
    }

    public List<TvShows> getShowsByType(String type) {
        return tvShowRepo.getShowsByType(type)
            .stream()
            .map(v -> TvShows.createSummary(v))
            .toList();
    }

}
