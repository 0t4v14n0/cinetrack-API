package com.project.cinetrack.domain.media;

import org.springframework.stereotype.Service;

import com.project.cinetrack.domain.media.dto.EpisodeDetailsResponse;
import com.project.cinetrack.domain.media.dto.SeasonDetailsResponse;
import com.project.cinetrack.domain.media.dto.TitleDetailsResponse;

@Service
public class MediaService {
	
	public TitleDetailsResponse TitleDetails(String title) {
		return new TitleDetailsResponse();
	}

	public SeasonDetailsResponse SeasonDetails(String title, Integer season) {
		return new SeasonDetailsResponse();
	}

	public EpisodeDetailsResponse EpisodeDetails(String title, Integer season, Integer episode) {
		return new EpisodeDetailsResponse();
	}

}
