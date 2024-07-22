package com.project.cinetrack.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/media")
public class MediaController {
	
	@GetMapping()
	public ResponseEntity<?> mediaDeteils(@RequestParam(name = "t", required = true) String title,
            							@RequestParam(name = "season", required = false) Integer season,
            							@RequestParam(name = "episode", required = false) Integer episode){
		
		
		return (ResponseEntity<?>) ResponseEntity.ok();		
	}

}
