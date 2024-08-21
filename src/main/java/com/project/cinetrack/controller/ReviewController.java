package com.project.cinetrack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.cinetrack.domain.review.Review;
import com.project.cinetrack.domain.review.ReviewService;
import com.project.cinetrack.domain.review.dto.DataRegisterReview;
import com.project.cinetrack.domain.review.dto.DataUpdateReview;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/review")
@SecurityRequirement(name = "bearer-key")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@PostMapping
    @Transactional
    public ResponseEntity<?> registerReview(@RequestBody DataRegisterReview data,
    											   Authentication authentication){
		String user = authentication.getName();
		return ResponseEntity.ok(reviewService.registerReview(data,user));
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<?> updateReview(@RequestBody DataUpdateReview data){
		return ResponseEntity.ok(reviewService.updateReview(data));
	}
	
	@GetMapping("/all")
	public ResponseEntity<Page<Review>> getAllReviewUser(@PageableDefault(size = 10,
			 															  sort = {"id"}) Pageable pageable,
															Authentication authentication){
		String user = (String) authentication.getName();
		return ResponseEntity.ok(reviewService.getAllReviewUser(user,pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getReview(@PathVariable(name = "id") Long idReview){
		return ResponseEntity.ok(reviewService.getReview(idReview));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deleteReview(@PathVariable Long id, Authentication authentication) {
	    reviewService.deleteReview(id, authentication.getName());
	    return ResponseEntity.ok().body("Review disabled successfully");
	}
	
}
