package com.project.cinetrack.domain.media.serie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.project.cinetrack.domain.extern.dto.DataEpisode;
import com.project.cinetrack.domain.extern.dto.DataSeason;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name = "season")
@Entity
public class Season {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "season_number")
    private int seasonNumber;
    
    @Column(name = "total_season")
    private int totalSeason;
    
    @OneToMany(mappedBy = "season", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Episode> episodes = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "serie_id", nullable = false)
    private Serie serie;
    
    public Season() {
    	
    }
    
    public Season(DataSeason dataSeason, Serie serie) {
    	
        System.out.println("1");
    	try {
        	this.seasonNumber = dataSeason.seasonNumber();

    	}catch(Exception e) {
        	this.seasonNumber = 0;

    	}
    	System.out.println("2");
    	try {
    		
        	this.totalSeason = dataSeason.totalSeason();

    	}catch(Exception e) {
        	this.totalSeason = 0;
    	}
    	System.out.println("3");

    	System.out.println("4");
    	try {
    		
        	this.serie = serie;
        	System.out.println("5");


    	}catch(Exception e) {
        	this.serie = serie;

        	System.out.println("6");

    		
    	}
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSeasonNumber() {
		return seasonNumber;
	}

	public void setSeasonNumber(int seasonNumber) {
		this.seasonNumber = seasonNumber;
	}

	public int getTotalSeason() {
		return totalSeason;
	}

	public void setTotalSeason(int totalSeason) {
		this.totalSeason = totalSeason;
	}

	public List<Episode> getEpisodes() {
		return episodes;
	}

    public void setEpisodes(List<DataEpisode> dataEpisodes) {
        if (dataEpisodes != null) {
            this.episodes = dataEpisodes.stream()
                .map(dataEpisode -> new Episode(dataEpisode, this))
                .collect(Collectors.toList());
        } else {
            this.episodes = new ArrayList<>();
        }
    }

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}
    
}
