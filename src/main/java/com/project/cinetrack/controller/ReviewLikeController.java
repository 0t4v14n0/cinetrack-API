package com.project.cinetrack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.cinetrack.domain.review.likes.ReviewLikeService;

@RestController
@RequestMapping("/reviewlikes")
public class ReviewLikeController {
	
	@Autowired
	private ReviewLikeService reviewLikeService;
	
    @PostMapping
    public ResponseEntity<?> likeReview(@RequestBody DataLikeReview data,
    												 Authentication authentication){
    	reviewLikeService.likeReview(data,authentication.getName());
		return ResponseEntity.ok().body("Like");
    }
    
    @DeleteMapping
    public ResponseEntity<?> unLikeReview(@RequestBody DataLikeReview data,
			 										   Authentication authentication){
    	reviewLikeService.unLikeReview(data,authentication.getName());
		return ResponseEntity.ok().body("UnLike");
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getLikeReview(@RequestBody DataLikeReview data){
		return ResponseEntity.ok(reviewLikeService.getLikeReview(data.reviewId()));
    }
    
    

}
