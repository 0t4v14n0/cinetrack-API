package com.project.cinetrack.domain.favorite.dto;

import com.project.cinetrack.domain.favorite.Favorite;

public record DataDetailsFavoriteSerie(Long id,
							           Long serieId,
							           Long userId) {
	
	public DataDetailsFavoriteSerie(Favorite favorite) {
		this(favorite.getId(),favorite.getSerieId(),favorite.getUserId());
	}

}
