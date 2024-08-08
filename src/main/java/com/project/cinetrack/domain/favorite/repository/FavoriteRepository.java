package com.project.cinetrack.domain.favorite.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.cinetrack.domain.favorite.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
	
	Page<Favorite> findFavoriteById(Pageable pageable, Long byId);

}
