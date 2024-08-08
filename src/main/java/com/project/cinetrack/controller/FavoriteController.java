package com.project.cinetrack.controller;

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

@RestController
@RequestMapping("/favorite")
public class FavoriteController {
	
	private FavoriteService favoriteService;
	
	@PostMapping
    @Transactional
    public ResponseEntity<?> registerFavorite(@RequestBody DataRegisterFavorite data,
    													   Authentication authentication){
		System.out.println(data);
		System.out.println(authentication.getName());
		String name =authentication.getName();
		return ResponseEntity.ok(favoriteService.registerFavorite(data,name));
	}
	
	@GetMapping
	public ResponseEntity<?> getFavorite(@PageableDefault(size = 10,
			  											  sort = {"id"}) Pageable pageable,
													                     Authentication authentication){
		System.out.println(authentication.getName());
		return ResponseEntity.ok(favoriteService.getFavorites(pageable,authentication.getName()));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deleteFavorite(@PathVariable Long id, Authentication authentication){
		return favoriteService.deleteFavorite(id,authentication.getName());
	}
}
