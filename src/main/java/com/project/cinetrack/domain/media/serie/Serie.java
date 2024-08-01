package com.project.cinetrack.domain.media.serie;

import java.util.ArrayList;
import java.util.List;

import com.project.cinetrack.domain.extern.dto.DataSerie;
import com.project.cinetrack.domain.media.movie.Gender;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name = "serie")
@Entity
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String year;
    private String plot;
    private int totalSeason;
    private int episodeNumber;
    private String releaseDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private double rating;
    private int votes;
    private int runtime;
    private String poster;

    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Season> seasons = new ArrayList<>();
    
    public Serie () {}
    
    public Serie(DataSerie dataSerie) {
        this.title = dataSerie.titulo();
        try {
            this.year = dataSerie.year();
        } catch (Exception e) {
            this.year = "";
        }
        this.plot = dataSerie.plot();
        try {
            this.totalSeason = Integer.parseInt(dataSerie.totalSeason());
        } catch (Exception e) {
            this.totalSeason = 0;
        }
        this.releaseDate = dataSerie.releaseDate();
        try {
            if (dataSerie.gender() == null || dataSerie.gender().trim().isEmpty()) {
                this.gender = Gender.UNKNOWN;
            } else {
                this.gender = Gender.fromString(dataSerie.gender().trim());
            }
        } catch (IllegalArgumentException e) {
            this.gender = Gender.UNKNOWN;
        }
        this.rating = Double.parseDouble(dataSerie.rating());
        try {
            this.votes = Integer.parseInt(dataSerie.votes());
        } catch (Exception e) {
            this.votes = 0;
        }
        try {
            this.runtime = Integer.parseInt(dataSerie.runtime());
        } catch (Exception e) {
            this.runtime = 0;
        }
        this.poster = dataSerie.poster();
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

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public int getTotalSeason() {
		return totalSeason;
	}

	public void setTotalSeason(int totalSeason) {
		this.totalSeason = totalSeason;
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
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

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public List<Season> getSeasons() {
		return seasons;
	}

	public void setSeasons(List<Season> seasons) {
		this.seasons = seasons;
	}
        
}
