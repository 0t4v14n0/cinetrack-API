package com.project.cinetrack.domain.favorite;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.cinetrack.domain.favorite.dto.DataDetailsFavoriteMovie;
import com.project.cinetrack.domain.favorite.dto.DataDetailsFavoriteSerie;
import com.project.cinetrack.domain.favorite.dto.DataRegisterFavorite;
import com.project.cinetrack.domain.favorite.repository.FavoriteRepository;
import com.project.cinetrack.domain.media.movie.MovieService;
import com.project.cinetrack.domain.media.service.SerieService;
import com.project.cinetrack.domain.user.UserService;

@Service
public class FavoriteService {
	
	private UserService userService;
	
	private SerieService serieService;
	
	private MovieService movieService;
	
	private FavoriteRepository favoriteRepository;
	
	public Object registerFavorite(DataRegisterFavorite data, String name) {
		
		System.out.println("sasaas");
		System.out.println(userService.getById(name));
		
		Favorite favorite = new Favorite(data,userService.getById(name));
		
		System.out.println(favorite);
		if(favorite.getSerieId() != 0) {
			return new DataDetailsFavoriteSerie(favorite);
		}else {
			return new DataDetailsFavoriteMovie(favorite);
		}
	}
	
    public Page<?> getFavorites(Pageable pageable, String name) {
    	
    	System.out.println("aqui");

        Page<Favorite> favoritePage = favoriteRepository.findFavoriteById(pageable,userService.getById(name));

        System.out.println(favoritePage);

        List<Object> dtos = favoritePage.getContent().stream()
                .map(favorite -> {
                    if (favorite.getSerieId() != null && favorite.getSerieId() != 0) {
                        return serieService.pageSerieFavorite(new DataDetailsFavoriteSerie(favorite));
                    } else if (favorite.getMovieId() != null && favorite.getMovieId() != 0) {
                        return movieService.pageMovieFavorite(new DataDetailsFavoriteMovie(favorite));
                    } else {

                        return null; 
                    }
                })
                .filter(dto -> dto != null)
                .collect(Collectors.toList());


        return new PageImpl<>(dtos, pageable, favoritePage.getTotalElements());
    }

	public ResponseEntity<?> deleteFavorite(Long id, String name) {
		return null;
	}

}
