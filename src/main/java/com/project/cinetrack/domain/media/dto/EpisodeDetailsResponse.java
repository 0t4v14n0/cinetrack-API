package com.project.cinetrack.domain.media.dto;

import com.project.cinetrack.domain.media.serie.Episode;

public record EpisodeDetailsResponse(String title,
									String plot,	
									int episodeNumber,
									String releaseDate,
									double rating,
									int votes,
									int runtime) {

	public EpisodeDetailsResponse(Episode episode) {
		this(episode.getTitle(),
			episode.getPlot(),
			episode.getEpisodeNumber(),
			episode.getReleaseDate(),
			episode.getRating(),
			episode.getVotes(),
			episode.getRuntime());
	}

}
