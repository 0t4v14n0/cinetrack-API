package com.project.cinetrack.domain.media.movie;

import com.project.cinetrack.domain.extern.dto.DataMovie;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "movie")
@Entity
public class Movie {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String year;
    private String data;
    private double note;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String director;
    private String actor;
    private String synopsis;
    private String poster;
    
    public Movie() {
    	
    }

	public Movie(DataMovie dataM) {
		this.title = dataM.title();
		this.year = dataM.year();
		this.data = dataM.releaseDate();
		this.note = Double.parseDouble(dataM.rating());
        try {
            if (dataM.gender() == null || dataM.gender().trim().isEmpty()) {
                this.gender = Gender.UNKNOWN;
            } else {
                this.gender = Gender.fromString(dataM.gender().trim());
            }
        } catch (IllegalArgumentException e) {
            this.gender = Gender.UNKNOWN;
        }
        this.director = dataM.director();
        this.actor = dataM.actor();
        this.synopsis = dataM.synopsis();
        this.poster = dataM.poster();
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}
    
}
