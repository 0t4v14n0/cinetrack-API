package com.project.cinetrack.domain.media.serie;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name = "serie")
@Entity(name = "Serie")
public class Serie {

	private Long id;
	private String title;
	private String plot;
	private int totalSeason;
	private int episodeNumber;
	private Date releaseDate;
    private double rating;
    private int votes;
    private int runtime;
	private String poster;
	
	@OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Episode> episodios = new ArrayList<>();

}
