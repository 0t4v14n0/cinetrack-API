package com.project.cinetrack.domain.review.dto;

import java.time.LocalDateTime;

import com.project.cinetrack.domain.review.Review;

public record DataDeteilsReviewSeason (		
		Long id,
		Long UserId,
		Long seasonId,
	    double rating,
	    String reviewText,
	    LocalDateTime createdAt) {

	public DataDeteilsReviewSeason(Review review) {
		this(review.getId(),
				 review.getUserId(),
				 review.getSeasonId(),
				 review.getRating(),
				 review.getReviewText(),
				 review.getCreatedAt());
	}


}
