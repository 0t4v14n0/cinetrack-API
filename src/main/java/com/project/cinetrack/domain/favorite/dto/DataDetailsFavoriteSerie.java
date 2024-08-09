package com.project.cinetrack.domain.favorite.dto;

import com.project.cinetrack.domain.favorite.Favorite;

public record DataDetailsFavoriteSerie(Long id,
									   Long userId,
							           Long serieId) {
	
	public DataDetailsFavoriteSerie(Favorite favorite) {
		this(favorite.getId(),favorite.getUserId(),favorite.getSerieId());
	}

	public DataDetailsFavoriteSerie(DataDetailsFavorite favorite) {
		this(favorite.id(),favorite.userId(),favorite.serieId());
	}

	public DataDetailsFavoriteSerie(DataDetailsFavoriteSerie favorite) {
		this(favorite.id(),favorite.userId(),favorite.serieId());
	}

}
