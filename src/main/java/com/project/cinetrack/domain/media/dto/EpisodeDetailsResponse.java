package com.project.cinetrack.domain.media.dto;

import java.sql.Date;

import com.project.cinetrack.domain.media.serie.Episode;

public record EpisodeDetailsResponse(String title,
									String plot,	
									int episodeNumber,
									int seasonNumber,
									Date releaseDate,
									double rating,
									int votes) {

	public EpisodeDetailsResponse(Episode episode) {
		this(episode.getTitle(),
			episode.getPlot(),
			episode.getEpisodeNumber(),
			episode.getSeasonNumber(),
			episode.getReleaseDate(),
			episode.getRating(),
			episode.getVotes());
	}

}
