package com.project.cinetrack.domain.review;

import java.time.LocalDateTime;

public class Review {
	
    private Long id;
    private Long user_id ;
    private Long movie_id;
    private Long series_id;
    private Long episode_id;
    private double rating;
    private String review_text;
    private LocalDateTime created_at;
    
    public Review(){
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(Long movie_id) {
		this.movie_id = movie_id;
	}

	public Long getSeries_id() {
		return series_id;
	}

	public void setSeries_id(Long series_id) {
		this.series_id = series_id;
	}

	public Long getEpisode_id() {
		return episode_id;
	}

	public void setEpisode_id(Long episode_id) {
		this.episode_id = episode_id;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getReview_text() {
		return review_text;
	}

	public void setReview_text(String review_text) {
		this.review_text = review_text;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
    
    

}
