package com.project.cinetrack.domain.review.likes;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ReviewLikesId implements Serializable {

	private static final long serialVersionUID = 1L;

    @Column(name = "review_id")
    private Long reviewId;

    @Column(name = "user_id")
    private Long userId;

	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewLikesId that = (ReviewLikesId) o;
        return Objects.equals(reviewId, that.reviewId) &&
               Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId, userId);
    }

}
