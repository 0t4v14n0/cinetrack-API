package com.project.cinetrack.domain.media.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cinetrack.domain.extern.DataConverter;
import com.project.cinetrack.domain.extern.ExternService;
import com.project.cinetrack.domain.extern.dto.DataMovie;
import com.project.cinetrack.domain.favorite.dto.DataDetailsFavoriteMovie;
import com.project.cinetrack.domain.media.dto.DataRegisterMedia;
import com.project.cinetrack.domain.media.movie.dto.MovieDetailsResponse;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private DataConverter dataConverter;
	
	@Autowired
	private ExternService externService;

	public void registerMovie(DataRegisterMedia data){
		try {
			
			String json = externService.searchOMDb(data.title(), null, null);
			DataMovie dataM = dataConverter.getData(json, DataMovie.class);
			Movie movie = new Movie(dataM);
			
			movieRepository.save(movie);
			
		}catch(Exception e) {
			System.out.println("Erro");
		}
	}

	public Object pageMovieFavorite(DataDetailsFavoriteMovie dataDetailsFavoriteMovie) {
		Movie movie = movieRepository.findMovieById(dataDetailsFavoriteMovie.movieId());
		return new MovieDetailsResponse(movie);
	}

}
