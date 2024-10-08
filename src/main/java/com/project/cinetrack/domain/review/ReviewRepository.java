package com.project.cinetrack.domain.review;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
	
    Page<Review> findByUserId(Long userId, Pageable pageable);
    
}