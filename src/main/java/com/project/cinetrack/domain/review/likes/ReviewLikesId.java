package com.project.cinetrack.domain.review.likes;

import java.io.Serializable;
import java.util.Objects;

import com.project.cinetrack.domain.review.Review;
import com.project.cinetrack.domain.user.User;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ReviewLikesId implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewLikesId that = (ReviewLikesId) o;
        return user.equals(that.user) && review.equals(that.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, review);
    }
}
