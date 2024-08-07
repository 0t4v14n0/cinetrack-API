package com.project.cinetrack.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.cinetrack.domain.favorite.FavoriteService;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {
	
	private FavoriteService favoriteService;

}
