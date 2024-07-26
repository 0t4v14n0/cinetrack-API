package com.project.cinetrack.domain.extern.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataSerie(@JsonAlias("Title") String titulo,
					    @JsonAlias("Year") String year,
					    @JsonAlias("totalSeasons") String totalSeason,
					    @JsonAlias("imdbRating") String rating,
					    @JsonAlias("imdbVotes") String votes,
					    @JsonAlias("Released") String releaseDate,
					    @JsonAlias("Runtime") String runtime,
					    @JsonAlias("Genre") String gender,
					    @JsonAlias("Director") String diretor,
					    @JsonAlias("Actors") String ator,
					    @JsonAlias("Plot") String plot,
					    @JsonAlias("Poster") String poster) {}
