package com.project.cinetrack.domain.review.likes;

import com.project.cinetrack.domain.review.Review;
import com.project.cinetrack.domain.user.User;

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

    public User getUser() {
        return id.getUser();
    }

    public void setUser(User user) {
        id.setUser(user);
    }

    public Review getReview() {
        return id.getReview();
    }

    public void setReview(Review review) {
        id.setReview(review);
    }
}
