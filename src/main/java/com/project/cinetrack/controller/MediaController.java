package com.project.cinetrack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.cinetrack.domain.media.MediaService;
import com.project.cinetrack.domain.media.dto.EpisodeDetailsResponse;
import com.project.cinetrack.domain.media.dto.SeasonDetailsResponse;
import com.project.cinetrack.domain.media.dto.TitleDetailsResponse;

@RestController
@RequestMapping("/media")
public class MediaController {
	
	@Autowired
	MediaService mediaService;
	
	@GetMapping
	public ResponseEntity<?> mediaDeteils(@RequestParam(name = "t", required = true) String title,
            							@RequestParam(name = "season", required = false) Integer season,
            							@RequestParam(name = "episode", required = false) Integer episode){
		
        if (season == null && episode == null) {
            TitleDetailsResponse response = mediaService.titleDetails(title);
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
    }

}
