package com.project.cinetrack.domain.review.dto;

import java.time.LocalDateTime;

import com.project.cinetrack.domain.review.Review;

public record DataDeteilsReviewEpisode(		
		Long id,
		Long UserId,
		Long seriesId,
		Long episodeId,
	    double rating,
	    String reviewText,
	    LocalDateTime createdAt) {
	
	public DataDeteilsReviewEpisode(Review review) {
		this(review.getId(),
			 review.getUserId(),
			 review.getSeriesId(),
			 review.getEpisodeId(),
			 review.getRating(),
			 review.getReviewText(),
			 review.getCreatedAt());
	
	}

}
