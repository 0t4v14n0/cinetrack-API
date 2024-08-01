package com.project.cinetrack.domain.review.dto;

import java.time.LocalDateTime;

import com.project.cinetrack.domain.review.Review;

public record DataDeteilsReviewMovie (
		Long id,
		Long UserId,
		Long movieId,
	    double rating,
	    String reviewText,
	    LocalDateTime createdAt) {
	
	public DataDeteilsReviewMovie(Review review) {
		this(review.getId(),
			 review.getUserId(),
			 review.getMovieId(),
			 review.getRating(),
			 review.getReviewText(),
			 review.getCreatedAt());
	}

}
