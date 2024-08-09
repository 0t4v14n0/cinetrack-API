package com.project.cinetrack.domain.favorite.dto;

import com.project.cinetrack.domain.favorite.Favorite;

public record DataDetailsFavoriteMovie(Long id,
        							   Long movieId,
        							   Long userId) {
	
	public DataDetailsFavoriteMovie(Favorite favorite) {
		this(favorite.getId(),favorite.getMovieId(),favorite.getUserId());
	}

	public DataDetailsFavoriteMovie(DataDetailsFavorite favorite) {
		this(favorite.id(),favorite.movieId(),favorite.userId());
	}

	public DataDetailsFavoriteMovie(DataDetailsFavoriteMovie favorite) {
		this(favorite.id(),favorite.movieId(),favorite.userId());
	}

}
