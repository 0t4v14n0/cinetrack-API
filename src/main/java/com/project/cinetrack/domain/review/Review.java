package com.project.cinetrack.domain.review;

import java.time.LocalDateTime;

import com.project.cinetrack.domain.review.dto.DataRegisterReview;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "review")
@Entity
public class Review {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "movie_id")
    private Long movieId;

    @Column(name = "serie_id")
    private Long seriesId;

    @Column(name = "season_id")
    private Long seasonId;

    @Column(name = "episode_id")
    private Long episodeId;

    private double rating;
    
    private String reviewText;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
    
    public Review(){}

    public Review(DataRegisterReview data, Long user) {
        this.userId = user;
        this.movieId = data.movieId() != null ? data.movieId() : null;
        this.seriesId = data.seriesId() != null ? data.seriesId() : null;
        this.seasonId = data.seasonId() != null ? data.seasonId() : null;
        this.episodeId = data.episodeId() != null ? data.episodeId() : null;
        this.rating = data.rating();
        this.reviewText = data.reviewText() != null ? data.reviewText() : "";
        this.createdAt = LocalDateTime.now();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public Long getSeriesId() {
		return seriesId;
	}

	public void setSeriesId(Long seriesId) {
		this.seriesId = seriesId;
	}

	public Long getSeasonId() {
		return seasonId;
	}

	public void setSeasonId(Long seasonId) {
		this.seasonId = seasonId;
	}

	public Long getEpisodeId() {
		return episodeId;
	}

	public void setEpisodeId(Long episodeId) {
		this.episodeId = episodeId;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
