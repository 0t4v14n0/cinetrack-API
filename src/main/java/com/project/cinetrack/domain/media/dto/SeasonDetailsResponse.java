package com.project.cinetrack.domain.media.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.project.cinetrack.domain.media.serie.Season;

public record SeasonDetailsResponse(int seasonNumber,
									int totalSeason,
									List<EpisodeDetailsResponse> episodes) {

	public SeasonDetailsResponse(Season season) {
		this(season.getSeasonNumber(),
			 season.getTotalSeason(),
			 season.getEpisodes().stream()
			 				.map(EpisodeDetailsResponse :: new)
			 				.collect(Collectors.toList()));
	}

}
