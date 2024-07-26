package com.project.cinetrack.domain.extern.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataSeason(@JsonAlias("Season") Integer seasonNumber,
						 @JsonAlias("totalSeasons") Integer totalSeason,
        				 @JsonAlias("Episodes") List<DataEpisode> episodios) {
}
