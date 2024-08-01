package com.project.cinetrack.domain.review.dto;

import java.time.LocalDateTime;
import com.project.cinetrack.domain.review.Review;

public record DataDeteilsReviewSerie(
		Long id,
		Long UserId,
		Long seriesId,
	    double rating,
	    String reviewText,
	    LocalDateTime createdAt) {
	
	public DataDeteilsReviewSerie(Review review) {
		this(review.getId(),
			 review.getUserId(),
			 review.getSeriesId(),
			 review.getRating(),
			 review.getReviewText(),
			 review.getCreatedAt());
	
	}
}
