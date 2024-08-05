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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.cinetrack.domain.review.ReviewService;
import com.project.cinetrack.domain.review.dto.DataRegisterReview;
import com.project.cinetrack.domain.review.dto.DataReview;
import com.project.cinetrack.domain.review.dto.DataUpdateReview;

@RestController
@RequestMapping("/review")
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
		return ResponseEntity.ok(reviewService.updateRview(data));
		
	}
	
	@GetMapping
	public ResponseEntity<Page<DataReview>> getAllReviewUser(@PageableDefault(size = 10,
			 																  sort = {"id"}) Pageable pageable,
															Authentication authentication){
		String user = (String) authentication.getName();
		return ResponseEntity.ok(reviewService.getAllReviewUser(user,pageable));
	}

	@GetMapping
	public ResponseEntity<Object> getReview(@RequestParam(name = "r", required = true) Long idReview){
		return ResponseEntity.ok(reviewService.getReview(idReview));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deleteReview(@PathVariable Long id, Authentication authentication) {
	    reviewService.deleteReview(id, authentication.getName());
	    return ResponseEntity.ok().body("Review disabled successfully");
	}
	
	
}
