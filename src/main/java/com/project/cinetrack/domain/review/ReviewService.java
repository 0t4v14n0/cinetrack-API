package com.project.cinetrack.domain.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.project.cinetrack.domain.review.dto.DataDeteilsReviewEpisode;
import com.project.cinetrack.domain.review.dto.DataDeteilsReviewMovie;
import com.project.cinetrack.domain.review.dto.DataDeteilsReviewSerie;
import com.project.cinetrack.domain.review.dto.DataRegisterReview;
import com.project.cinetrack.domain.review.dto.DataReview;
import com.project.cinetrack.domain.user.UserService;

public class ReviewService {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ReviewRepository reviewRepository;

	public Object registerReview(DataRegisterReview data, String user) {
		
		if(data.movieId() != null) {
			return new DataDeteilsReviewMovie(createReview(data,user));
		
		}else if(data.episodeId() != null) {
			return new DataDeteilsReviewEpisode(createReview(data,user));	
			
		}else {
			return new DataDeteilsReviewSerie(createReview(data,user));		
		}
	}
	
	public Review createReview(DataRegisterReview data, String user) {
		int userID = userService.getById(user);
		Review review = new Review(data,userID);
		reviewRepository.save(review);
		return review;
	}

	public Page<DataReview> getAllReviewUser(String name,Pageable pageable) {
		int userID = userService.getById(name);
		return reviewRepository.findUserid(pageable,(long) userID);
	}

	public ResponseEntity<DataReview> getReview(Long id) {
		return null;
	}
}
