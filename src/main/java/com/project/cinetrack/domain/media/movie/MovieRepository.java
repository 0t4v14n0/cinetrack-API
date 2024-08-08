package com.project.cinetrack.domain.media.movie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
	
	Page<Movie> findAll(Pageable pageable);

	Movie findMovieById(Long movieId);

}
