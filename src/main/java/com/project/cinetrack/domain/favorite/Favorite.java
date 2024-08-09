package com.project.cinetrack.domain.favorite;

import com.project.cinetrack.domain.favorite.dto.DataRegisterFavorite;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "favorite")
public class Favorite {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "user_id")
	private Long userId;
	@Column(name = "serie_id")
	private Long serieId;
	@Column(name = "movie_id")
	private Long movieId;
	
	public Favorite() {}
	
	public Favorite(DataRegisterFavorite data, Long byId) {
		this.userId = byId;
		this.serieId = data.serieId();
		this.movieId = data.movieId();
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

	public Long getSerieId() {
		return serieId;
	}

	public void setSerieId(Long serieId) {
		this.serieId = serieId;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

}
