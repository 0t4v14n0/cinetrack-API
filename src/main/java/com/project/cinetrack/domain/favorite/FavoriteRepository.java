package com.project.cinetrack.domain.favorite;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.cinetrack.domain.favorite.dto.DataDetailsFavorite;
import com.project.cinetrack.domain.favorite.dto.DataDetailsFavoriteMovie;
import com.project.cinetrack.domain.favorite.dto.DataDetailsFavoriteSerie;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
	
	@Query("SELECT f From Favorite f WHERE f.userId = :userId")
	List<DataDetailsFavorite> findFavoriteByIdUser(@Param("userId") Long byId);
	
	@Query("SELECT f FROM Favorite f WHERE f.userId = :userId AND f.serieId IS NOT NULL")
	List<DataDetailsFavoriteSerie> findFavoriteSerieByIdUser(@Param("userId") Long userId);
	
	@Query("SELECT f FROM Favorite f WHERE f.userId = :userId AND f.movieId IS NOT NULL")
	List<DataDetailsFavoriteMovie> findFavoriteMovieByIdUser(@Param("userId") Long userId);

}
