package com.project.cinetrack.domain.media;

import org.springframework.stereotype.Service;

import com.project.cinetrack.domain.media.dto.EpisodeDetailsResponse;
import com.project.cinetrack.domain.media.dto.SeasonDetailsResponse;
import com.project.cinetrack.domain.media.dto.TitleDetailsResponse;
import com.project.cinetrack.domain.media.serie.Episode;

@Service
public class MediaService {
	
	public TitleDetailsResponse TitleDetails(String title) {
		return new TitleDetailsResponse();
	}

	public SeasonDetailsResponse SeasonDetails(String title, Integer season) {
		return new SeasonDetailsResponse();
	}

	public EpisodeDetailsResponse EpisodeDetails(String title, Integer season, Integer episode) {
		
		//consulta no bd, se retorna null consulta e grava no bd;
		
		
		Episode episode1 = new Episode();
		
		return new EpisodeDetailsResponse(episode1);
	}

}
