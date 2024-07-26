package com.project.cinetrack.domain.media.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.cinetrack.domain.media.serie.Season;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long>{
	
    @Query("SELECT s FROM Season s JOIN s.serie se WHERE se.title = :title AND s.seasonNumber = :seasonNumber")
    Season findBySerieTitleAndSeasonNumber(@Param("title") String title, @Param("seasonNumber") Integer season);

}