package com.project.cinetrack.domain.media.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cinetrack.domain.media.repository.EpisodeRepository;
import com.project.cinetrack.domain.media.serie.Episode;

@Service
public class EpisodeService {
	
    @Autowired
    private EpisodeRepository episodeRepository;
		
    public Episode searchEpisode(String title, Integer season, Integer episode) {
    	
        Optional<Episode> episodeOptional = episodeRepository.findByTitleAndSeasonSeasonNumberAndEpisodeNumber(title, season, episode);
        
        if (episodeOptional.isPresent()) {
            return episodeOptional.get();
        } else {
            return null;
        }
    }

}
