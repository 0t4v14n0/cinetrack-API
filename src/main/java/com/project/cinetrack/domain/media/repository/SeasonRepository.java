package com.project.cinetrack.domain.media.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.cinetrack.domain.media.serie.Season;

public interface SeasonRepository extends JpaRepository<Season, Long> {
    
	@Query("SELECT s FROM Season s JOIN s.serie serie WHERE serie.title = :serieTitle AND s.seasonNumber = :seasonNumber")
	Season findBySerieTitleAndSeasonNumber(@Param("serieTitle") String serieTitle, @Param("seasonNumber") Integer seasonNumber);
	
}
