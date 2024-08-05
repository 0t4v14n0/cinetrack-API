package com.project.cinetrack.domain.review.dto;

import java.time.LocalDateTime;

import com.project.cinetrack.domain.review.Review;

public record DataReview(Long id,
		                 Long userId,
		                 Long movieId,
		                 Long seriesId,
		                 Long seasonId,
		                 Long episodeId,
		                 double rating,
		                 String reviewText,
		                 LocalDateTime createdAt) {
	
	public DataReview(Review review) {
		this(review.getId(),
			 review.getUserId(),
			 review.getMovieId(),
			 review.getSeriesId(),
			 review.getSeasonId(),
			 review.getEpisodeId(),
			 review.getRating(),
			 review.getReviewText(),
			 review.getCreatedAt());
	}
	
}
