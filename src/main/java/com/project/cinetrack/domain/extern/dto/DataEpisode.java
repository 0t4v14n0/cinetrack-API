package com.project.cinetrack.domain.extern.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataEpisode(@JsonAlias("Title") String title,
						  @JsonAlias("Plot") String plot,
        				  @JsonAlias("Episode") String episodeNumber, 
        				  @JsonAlias("imdbRating") String rating,
        				  @JsonAlias("Released") String releaseDate,
        				  @JsonAlias("imdbVotes") String votes, 
        				  @JsonAlias("Runtime") String runtime) {}
