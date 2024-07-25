package com.project.cinetrack.domain.media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cinetrack.domain.extern.ExternService;
import com.project.cinetrack.domain.media.dto.EpisodeDetailsResponse;
import com.project.cinetrack.domain.media.dto.SeasonDetailsResponse;
import com.project.cinetrack.domain.media.dto.TitleDetailsResponse;
import com.project.cinetrack.domain.media.serie.Episode;
import com.project.cinetrack.domain.media.service.EpisodeService;

@Service
public class MediaService {
    
    @Autowired
    private EpisodeService episodeService;
    
    @Autowired
    private ExternService externService;
	
	public TitleDetailsResponse titleDetails(String title) {
		return new TitleDetailsResponse();
	}

	public SeasonDetailsResponse seasonDetails(String title, Integer season) {
		return new SeasonDetailsResponse();
	}

    public EpisodeDetailsResponse episodeDetails(String title, Integer season, Integer episode) {
    	
    	Episode episode1 = episodeService.searchEpisode(title,season,episode);
    	
    	if (episode1 == null) {
    		//return new EpisodeDetailsResponse(externService.searchOMDb(title, season, episode));
    	}
    	return new EpisodeDetailsResponse(episode1);

    }

}
