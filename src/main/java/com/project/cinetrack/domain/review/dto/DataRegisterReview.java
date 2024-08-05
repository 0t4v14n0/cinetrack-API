package com.project.cinetrack.domain.review.dto;

public record DataRegisterReview (
		Long movieId,
		Long seriesId,
		Long seasonId,
		Long episodeId,
		double rating,
		String reviewText) {}
