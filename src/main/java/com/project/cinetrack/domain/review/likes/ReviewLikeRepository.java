package com.project.cinetrack.domain.review.likes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewLikeRepository extends JpaRepository<ReviewLikes, ReviewLikesId> {
	
	@Query("SELECT COUNT(rl) FROM ReviewLikes rl WHERE rl.id.reviewId = :reviewId")
    long countByReviewId(@Param("reviewId") Long reviewId);
	
}

