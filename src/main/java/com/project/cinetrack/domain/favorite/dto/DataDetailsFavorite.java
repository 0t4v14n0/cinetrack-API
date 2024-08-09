package com.project.cinetrack.domain.favorite.dto;

import com.project.cinetrack.domain.favorite.Favorite;

public record DataDetailsFavorite(Long id,
								  Long userId,
								  Long serieId,
								  Long movieId) {
	
	public DataDetailsFavorite(Favorite favorite) {
		this(favorite.getId(),favorite.getUserId(),favorite.getSerieId(),favorite.getMovieId());
	}
}
