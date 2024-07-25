package com.project.cinetrack.domain.media.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.cinetrack.domain.media.serie.Episode;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Long>{

}
