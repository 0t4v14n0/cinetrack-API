package com.project.cinetrack.domain.media;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.cinetrack.domain.media.dto.DataRegisterMedia;
import com.project.cinetrack.domain.media.dto.EpisodeDetailsResponse;
import com.project.cinetrack.domain.media.dto.SeasonDetailsResponse;
import com.project.cinetrack.domain.media.dto.SerieDetailsResponse;
import com.project.cinetrack.domain.media.movie.MovieService;
import com.project.cinetrack.domain.media.serie.Episode;
import com.project.cinetrack.domain.media.serie.Season;
import com.project.cinetrack.domain.media.serie.Serie;
import com.project.cinetrack.domain.media.service.EpisodeService;
import com.project.cinetrack.domain.media.service.SeasonService;
import com.project.cinetrack.domain.media.service.SerieService;

@Service
public class MediaService {
	
	@Autowired
    private SerieService serieService;
	
	@Autowired
    private SeasonService seasonService;
    
    @Autowired
    private EpisodeService episodeService;
    
    @Autowired
    private MovieService movieService;
    
	public SerieDetailsResponse serieDetails(String title) {
		
    	Serie search = serieService.searchSerie(title);
    	
    	return new SerieDetailsResponse(search);
	}

	public SeasonDetailsResponse seasonDetails(String title, Integer season) {
		
		System.out.println(title);
		
		System.out.println(season);
		
    	Season search = seasonService.searchSeason(title,season);
    	
    	return new SeasonDetailsResponse(search);
	}

    public EpisodeDetailsResponse episodeDetails(String title, Integer season, Integer episode) throws IOException, InterruptedException {
    	
    	Episode search = episodeService.searchEpisode(title,season,episode);
    	
    	return new EpisodeDetailsResponse(search);
    }
    
    public void registerMedia(DataRegisterMedia data) {
        if ("1".equals(data.media())) {
            try {
				serieService.registerSerie(data);
			} catch (Exception e) {
				e.printStackTrace();
			}
        } else {
            movieService.registerMovie();
        }
    }

	public Page<SerieDetailsResponse> listaSerie(Pageable pageable) {
		
	    var series = serieService.listaSerie(pageable);

	    return series;
	}

}
