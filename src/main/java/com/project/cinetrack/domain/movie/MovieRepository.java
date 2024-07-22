package com.project.cinetrack.domain.movie;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.cinetrack.domain.review.Review;

public interface MovieRepository extends JpaRepository<Review, Long>{

}
