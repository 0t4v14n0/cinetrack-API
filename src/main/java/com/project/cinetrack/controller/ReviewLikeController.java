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
import com.project.cinetrack.domain.review.likes.dto.DataGetLikeReview;
import com.project.cinetrack.domain.review.likes.dto.DataLikeReview;

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
    
    @GetMapping
    public ResponseEntity<DataGetLikeReview> getLikeReview(@RequestBody DataLikeReview data){
    	System.out.println(data.reviewId());
		return ResponseEntity.ok(new DataGetLikeReview(data.reviewId(),reviewLikeService.getLikeReview(data.reviewId())));
    }

}
