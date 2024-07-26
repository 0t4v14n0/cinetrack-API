package com.project.cinetrack.domain.media.dto;

import com.project.cinetrack.domain.media.serie.Serie;

public record SerieDetailsResponse(String title,
								   String year,
								   String plot,
								   int totalSeason,
								   int episodeNumber,
								   String releaseDate,
								   double rating,
								   int votes,
								   int runtime) {

	public SerieDetailsResponse(Serie serie) {
		this(serie.getTitle(),
			 serie.getYear(),
			 serie.getPlot(),
			 serie.getTotalSeason(),
			 serie.getEpisodeNumber(),
			 serie.getReleaseDate(),
			 serie.getRating(),
			 serie.getVotes(),
			 serie.getRuntime());
	}

}
