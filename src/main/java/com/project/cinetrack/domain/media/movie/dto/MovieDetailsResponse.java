package com.project.cinetrack.domain.media.movie.dto;

import com.project.cinetrack.domain.media.movie.Movie;

public record MovieDetailsResponse() {

	public MovieDetailsResponse(Movie movie) {
		this();
	}

}
