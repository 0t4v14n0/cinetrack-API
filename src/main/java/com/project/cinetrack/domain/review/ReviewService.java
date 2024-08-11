package com.project.cinetrack.domain.review;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.cinetrack.domain.review.dto.DataDeteilsReviewEpisode;
import com.project.cinetrack.domain.review.dto.DataDeteilsReviewMovie;
import com.project.cinetrack.domain.review.dto.DataDeteilsReviewSeason;
import com.project.cinetrack.domain.review.dto.DataDeteilsReviewSerie;
import com.project.cinetrack.domain.review.dto.DataRegisterReview;
import com.project.cinetrack.domain.review.dto.DataUpdateReview;
import com.project.cinetrack.domain.user.UserService;

@Service
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
			
		}else if(data.episodeId() != null) {
			return new DataDeteilsReviewSeason(createReview(data,user));
			
		}else {
			return new DataDeteilsReviewSerie(createReview(data,user));		
		}
	}
	
	public Review createReview(DataRegisterReview data, String user) {
		System.out.println("chegou aqui...");
		Review review = new Review(data,userID(user));
		saveRepository(review);
		return review;
	}

	public Page<Review> getAllReviewUser(String name, Pageable pageable) {
		
	    Page<Review> reviewsPage = reviewRepository.findByUserId(userID(name), pageable);  
	    //reviewsPage.forEach(review -> System.out.println(review));
	    return reviewsPage;
	}

	public Object getReview(Long id) {
		Review review = reviewRepository.getReferenceById(id);
		return new DataDeteilsReviewSerie(review);
	}

	public Object updateReview(DataUpdateReview data) {
		
		try {
			
	        Review review = reviewRepository.getReferenceById(data.id());
			
			if(review != null) {
								
				review.setRating(data.rating());
				review.setReviewText(data.reviewText());
				review.setUpdatedAt(LocalDateTime.now());
				saveRepository(review);
				return new DataDeteilsReviewSerie(review);
				
			}else {	
				return null;
			}
			
		} catch(Exception e) {
			return null;
		}	
	}

	public void deleteReview(Long id, String name) {
		
		try {
			Review review = reviewRepository.getReferenceById(id);
			
			if(review.getUserId() == userID(name)) {
				
				reviewRepository.delete(review);
				System.out.println("Delete");
			}else {
				System.out.println("not authorized");
			}
			
		}catch(Exception e) {
			System.out.println("not found");
		}
	}
	
	//code reduction
	
	public Long userID(String name) {
		Long userID = userService.getById(name);
		return userID;
	}
	
	public void saveRepository(Review review) {
		reviewRepository.save(review);
	}
	
}
