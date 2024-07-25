package com.project.cinetrack.domain.media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cinetrack.domain.media.dto.EpisodeDetailsResponse;
import com.project.cinetrack.domain.media.dto.SeasonDetailsResponse;
import com.project.cinetrack.domain.media.dto.TitleDetailsResponse;
import com.project.cinetrack.domain.media.repository.EpisodeRepository;
import com.project.cinetrack.domain.media.repository.SeasonRepository;
import com.project.cinetrack.domain.media.repository.SerieRepository;
import com.project.cinetrack.domain.media.serie.Episode;

@Service
public class MediaService {
	
    @Autowired
    private SerieRepository serieRepository;

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private EpisodeRepository episodeRepository;
	
	public TitleDetailsResponse titleDetails(String title) {
		return new TitleDetailsResponse();
	}

	public SeasonDetailsResponse seasonDetails(String title, Integer season) {
		return new SeasonDetailsResponse();
	}

	public EpisodeDetailsResponse episodeDetails(String title, Integer season, Integer episode) {
		
		//consulta no bd, se retorna null consulta e grava no bd;
		
		
		Episode episode1 = new Episode();
		
		return new EpisodeDetailsResponse(episode1);
	}

}
