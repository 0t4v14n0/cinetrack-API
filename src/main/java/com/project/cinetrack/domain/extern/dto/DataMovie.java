package com.project.cinetrack.domain.extern.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataMovie(@JsonAlias("Title") String title,
						@JsonAlias("Year") String year,
						@JsonAlias("Released") String releaseDate,
						@JsonAlias("imdbRating") String rating,
						@JsonAlias("Genre") String gender,
						@JsonAlias("Director") String director,
						@JsonAlias("Actors") String actor,
						@JsonAlias("Plot") String synopsis,
						@JsonAlias("Poster") String poster) {}
