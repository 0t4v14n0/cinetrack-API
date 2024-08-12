package com.project.cinetrack.domain.review.likes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cinetrack.domain.review.Review;
import com.project.cinetrack.domain.review.ReviewService;
import com.project.cinetrack.domain.review.likes.dto.DataLikeReview;
import com.project.cinetrack.domain.user.UserService;

@Service
public class ReviewLikeService {
		
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ReviewLikeRepository reviewLikeRepository;

    public void likeReview(DataLikeReview data, String name) {
        ReviewLikes reviewL = findReviewLikes(data, name);
        reviewLikeRepository.save(reviewL);
    }

    public void unLikeReview(DataLikeReview data, String name) {
        ReviewLikes reviewL = findReviewLikes(data, name);
        reviewLikeRepository.delete(reviewL);
    }
    
    public Long getLikeReview(Long idReview) {
    	Long count = reviewLikeRepository.countByReviewId(idReview);
    	System.out.println(count);
		return count;
    }
    
	//code reduction
    
    private ReviewLikes findReviewLikes(DataLikeReview data, String name) {
    	
        Review review = reviewService.getReviewForLike(data.reviewId());
        
        if (review == null) {
            throw new IllegalArgumentException("Review not found");
        }
        
        ReviewLikesId reviewId = new ReviewLikesId();
        reviewId.setReviewId(review.getId());
        reviewId.setUserId(userService.findByNome(name).getId());
        
        ReviewLikes reviewL = new ReviewLikes();
        reviewL.setId(reviewId);
 
        return reviewL;
    }

}
