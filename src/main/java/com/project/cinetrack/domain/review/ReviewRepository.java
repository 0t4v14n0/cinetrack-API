package com.project.cinetrack.domain.review;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.cinetrack.domain.review.dto.DataReview;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{
	
	Page<DataReview> findUserid(Pageable pageable,Long id);

}
