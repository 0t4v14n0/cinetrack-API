package com.project.cinetrack.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.cinetrack.domain.media.MediaService;
import com.project.cinetrack.domain.media.dto.DataRegisterMedia;
import com.project.cinetrack.domain.media.dto.EpisodeDetailsResponse;
import com.project.cinetrack.domain.media.dto.SeasonDetailsResponse;
import com.project.cinetrack.domain.media.dto.SerieDetailsResponse;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/media")
@SecurityRequirement(name = "bearer-key")
public class MediaController {
	
	@Autowired
	MediaService mediaService;
	
	@GetMapping
	public ResponseEntity<?> mediaDeteils(@RequestParam(name = "t", required = true) String title,
            							@RequestParam(name = "season", required = false) Integer season,
            							@RequestParam(name = "episode", required = false) Integer episode) throws IOException, InterruptedException{
		try {
			
	        if (season == null && episode == null) {
	            SerieDetailsResponse response = mediaService.serieDetails(title);
	            return ResponseEntity.ok(response);
	        } else if (season != null && episode == null) {
	            SeasonDetailsResponse response = mediaService.seasonDetails(title, season);
	            return ResponseEntity.ok(response);
	        } else if (season != null && episode != null) {
	            EpisodeDetailsResponse response = mediaService.episodeDetails(title, season, episode);
	            return ResponseEntity.ok(response);
	        } else {
	            return ResponseEntity.badRequest().body("Invalid parameters");
	        }
			
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Invalid parameters");
		}

    }
	
	@GetMapping("/serie")
	public ResponseEntity<Page<SerieDetailsResponse>> listMedia(@PageableDefault(size = 10,
															 					 sort = {"title"}) Pageable pageable) {
		var page = mediaService.listaSerie(pageable);
		
		return ResponseEntity.ok(page);
		
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<?> registerMedia(@RequestBody @Valid DataRegisterMedia data){
		try {
			
			mediaService.registerMedia(data);		
			return ResponseEntity.ok(200);	
			
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Media not found");
		}
	}

}
