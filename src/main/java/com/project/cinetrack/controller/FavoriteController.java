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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.cinetrack.domain.favorite.FavoriteService;
import com.project.cinetrack.domain.favorite.dto.DataRegisterFavorite;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/favorite")
@SecurityRequirement(name = "bearer-key")
public class FavoriteController {
	
	@Autowired
	private FavoriteService favoriteService;
	
	@PostMapping
    @Transactional
    public ResponseEntity<?> registerFavorite(@RequestBody DataRegisterFavorite data,
    													   Authentication authentication){
		return ResponseEntity.ok(favoriteService.registerFavorite(data,authentication.getName()));
	}
	
	@GetMapping
	public ResponseEntity<Page<?>> getFavorite(@PageableDefault(size = 10,
			  											  sort = {"id"}) Pageable pageable,
													                     Authentication authentication){
		return ResponseEntity.ok(favoriteService.getFavorites(pageable,authentication.getName()));
	}
	
	@GetMapping("/serie")
	public ResponseEntity<Object> getFavoriteSerie(@PageableDefault(size = 10,
			  											       sort = {"id"}) Pageable pageable,
													                     Authentication authentication){
		return ResponseEntity.ok(favoriteService.getFavoritesSerie(pageable,authentication.getName()));
	}
	
	@GetMapping("/movie")
	public ResponseEntity<Object> getFavoriteMovie(@PageableDefault(size = 10,
			  											       sort = {"id"}) Pageable pageable,
													                     Authentication authentication){
		return ResponseEntity.ok(favoriteService.getFavoritesMovie(pageable,authentication.getName()));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deleteFavorite(@PathVariable Long id, Authentication authentication){
		favoriteService.deleteFavorite(id,authentication.getName());
		return ResponseEntity.ok().body("Favorite disabled successfully");
	}
}
