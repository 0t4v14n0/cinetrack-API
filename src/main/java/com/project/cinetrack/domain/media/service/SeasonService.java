package com.project.cinetrack.domain.media.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cinetrack.domain.media.repository.SeasonRepository;
import com.project.cinetrack.domain.media.serie.Season;

@Service
public class SeasonService {
	
	@Autowired
	private SeasonRepository seasonRepository;

	public Season searchSeason(String title, Integer season) {
		
		Season season1 = seasonRepository.findBySerieTitleAndSeasonNumber(title, season);
				
		return season1;
	}

}
