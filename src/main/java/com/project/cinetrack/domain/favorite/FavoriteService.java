package com.project.cinetrack.domain.favorite;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.cinetrack.domain.favorite.dto.DataDetailsFavorite;
import com.project.cinetrack.domain.favorite.dto.DataDetailsFavoriteMovie;
import com.project.cinetrack.domain.favorite.dto.DataDetailsFavoriteSerie;
import com.project.cinetrack.domain.favorite.dto.DataRegisterFavorite;
import com.project.cinetrack.domain.favorite.repository.FavoriteRepository;
import com.project.cinetrack.domain.media.movie.MovieService;
import com.project.cinetrack.domain.media.service.SerieService;
import com.project.cinetrack.domain.user.UserService;

@Service
public class FavoriteService {
		
	@Autowired
	private UserService userService;
	
	@Autowired
	private SerieService serieService;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private FavoriteRepository favoriteRepository;
	
	public Object registerFavorite(DataRegisterFavorite data, String name) {
				
		Favorite favorite = new Favorite(data,userService.getById(name));
		saveRepository(favorite);
		
		if(favorite.getSerieId() != 0) {
			return serieService.pageSerieFavorite(new DataDetailsFavoriteSerie(favorite));
		}else {
			return new DataDetailsFavoriteMovie(favorite);
		}
	}

	public Page<?> getFavorites(Pageable pageable, String name) {
		
	    List<DataDetailsFavorite> lista = favoriteRepository.findFavoriteByIdUser(userService.getById(name));
	    System.out.println(lista);
	    
	    List<Object> dtos = lista.stream()
	            .map(favorite -> {
	                if (favorite.serieId() != null) {
	                    return serieService.pageSerieFavorite(new DataDetailsFavoriteSerie(favorite));
	                } else if (favorite.movieId() != null) {
	                    return movieService.pageMovieFavorite(new DataDetailsFavoriteMovie(favorite));
	                } else {
	                    return null;
	                }
	            })
	            .filter(dto -> dto != null)
	            .collect(Collectors.toList());
	    
	    return new PageImpl<>(dtos, pageable, lista.size());
	}

	public Object getFavoritesSerie(Pageable pageable, String name) {
		
	    List<DataDetailsFavoriteSerie> lista = favoriteRepository.findFavoriteSerieByIdUser(userService.getById(name));
	    
	    List<Object> dtos = lista.stream()
	    		.map(favorite -> {
	    			return serieService.pageSerieFavorite(new DataDetailsFavoriteSerie(favorite)); 
	    		})
	    		.filter(dto -> dto != null)
	    		.collect(Collectors.toList());
	    
		return new PageImpl<>(dtos, pageable, lista.size());
	}

	public Object getFavoritesMovie(Pageable pageable, String name) {
		
	    List<DataDetailsFavoriteMovie> lista = favoriteRepository.findFavoriteMovieByIdUser(userService.getById(name));

	    List<Object> dtos = lista.stream()
	    		.map(favorite -> {
	    			return movieService.pageMovieFavorite(new DataDetailsFavoriteMovie(favorite)); 
	    		})
	    		.filter(dto -> dto != null)
	    		.collect(Collectors.toList());
	    
		return new PageImpl<>(dtos, pageable, lista.size());
	}
	
	public void deleteFavorite(Long id, String name) {
		
		try {
			
			Favorite favorite = favoriteRepository.getReferenceById(id);
			
			if(favorite.getUserId() == userID(name)) {
				
				favoriteRepository.delete(favorite);
				System.out.println("Delete");
			}else {
				System.out.println("not authorized");
			}
			
		}catch(Exception e) {
			System.out.println("not found");
		}
		
	}
	
	//code reduction
	
	public Long userID(String name) {
		Long userID = userService.getById(name);
		return userID;
	}
	
	public void saveRepository(Favorite favorite) {
		favoriteRepository.save(favorite);
	}

}
