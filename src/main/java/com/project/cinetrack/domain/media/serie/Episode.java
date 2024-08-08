package com.project.cinetrack.domain.media.serie;

import com.project.cinetrack.domain.extern.dto.DataEpisode;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "episode")
public class Episode {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String plot;
    private int episodeNumber;
    private String releaseDate;
    private double rating;
    private int votes;
    private int runtime;

    @ManyToOne
    @JoinColumn(name = "season_id", nullable = false)
    private Season season;
    
    public Episode(){  	
    }
    
    public Episode(DataEpisode dataEpisode, Season season) {
    	
    	try {
    		
        	this.title = dataEpisode.title();

    	}catch(Exception e) {
        	this.title = "";
    	}
    	
    	try {
    		
        	this.plot = dataEpisode.plot();

    	}catch(Exception e) {
        	this.plot = "";
    	}
    	
    	try {
    		
        	this.episodeNumber = Integer.parseInt(dataEpisode.episodeNumber());
        	
    	}catch(Exception e) {
        	this.episodeNumber = 0;
    	}
    	try {
    		
        	this.releaseDate = dataEpisode.releaseDate();

    	}catch(Exception e) {
        	this.releaseDate = "";
    	}
    	try {
    		
        	this.rating = Double.parseDouble(dataEpisode.rating());

    	}catch(Exception e) {
        	this.rating = 0;

    	}
    	try {
        	this.votes = Integer.parseInt(dataEpisode.votes());

    	}catch(Exception e) {
        	this.votes = 0;
    	}
    	try {
    		
        	this.runtime = Integer.parseInt(dataEpisode.runtime());

    	}catch(Exception e) {
    		
        	this.runtime = 0;

    	}
    	try {
        	this.season = season;
    	}catch(Exception e) {
    		
    	}
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public int getEpisodeNumber() {
		return episodeNumber;
	}

	public void setEpisodeNumber(int episodeNumber) {
		this.episodeNumber = episodeNumber;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}
    
}
