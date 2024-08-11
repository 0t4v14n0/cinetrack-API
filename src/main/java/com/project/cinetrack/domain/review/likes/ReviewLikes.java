package com.project.cinetrack.domain.review.likes;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "review_likes")
public class ReviewLikes {

    @EmbeddedId
    private ReviewLikesId id;

	public ReviewLikesId getId() {
		return id;
	}

	public void setId(ReviewLikesId id) {
		this.id = id;
	}
	
}
