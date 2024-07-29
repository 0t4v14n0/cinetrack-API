package com.project.cinetrack.domain.media.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.cinetrack.domain.media.serie.Serie;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long>{
	
	Serie findByTitle(String title);

    Page<Serie> findAll(Pageable pageable);
	
}
