package com.project.cinetrack.domain.review.likes.dto;

public record DataGetLikeReview(Long id,
								Long countLikes) {
	
	public DataGetLikeReview(Long id, Long countLikes) {
		this.id = id;
		this.countLikes = countLikes;
	}
}
