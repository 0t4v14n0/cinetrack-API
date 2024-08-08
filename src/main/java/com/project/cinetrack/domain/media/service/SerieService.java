package com.project.cinetrack.domain.media.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.cinetrack.domain.extern.DataConverter;
import com.project.cinetrack.domain.extern.ExternService;
import com.project.cinetrack.domain.extern.dto.DataEpisode;
import com.project.cinetrack.domain.extern.dto.DataSeason;
import com.project.cinetrack.domain.extern.dto.DataSerie;
import com.project.cinetrack.domain.favorite.dto.DataDetailsFavoriteSerie;
import com.project.cinetrack.domain.media.dto.DataRegisterMedia;
import com.project.cinetrack.domain.media.dto.SerieDetailsResponse;
import com.project.cinetrack.domain.media.repository.SerieRepository;
import com.project.cinetrack.domain.media.serie.Episode;
import com.project.cinetrack.domain.media.serie.Season;
import com.project.cinetrack.domain.media.serie.Serie;

@Service
public class SerieService {
	
	@Autowired
	private SerieRepository serieRepository;
	
	@Autowired
	private DataConverter dataConverter;
	
	@Autowired
	private ExternService externService;

	public Serie searchSerie(String title) {
		
		Serie serie1 = serieRepository.findByTitle(title);
		
//		if(serie1 == null) {
//			new DataRegisterMedia data ();
//		}
		
		return serie1;
	}

	public void registerSerie(DataRegisterMedia data){
		
		try {
		    String json = externService.searchOMDb(data.title(), "", "");
		    DataSerie dataS = dataConverter.getData(json, DataSerie.class);	    
		    Serie serie = new Serie(dataS);
		    	    
		    for (int seasonNumber = 1; seasonNumber <= serie.getTotalSeason(); seasonNumber++) {
		    	
		        String json2 = externService.searchOMDb(data.title(), ""+seasonNumber, "");	        
		        DataSeason dataT = dataConverter.getData(json2, DataSeason.class);	        	      
		        Season season = new Season(dataT, serie);	        	        
		        List<DataEpisode> dataEpisodes = dataT.episodios();	        
		        for (DataEpisode dataE : dataEpisodes) {
		            Episode episode = new Episode(dataE, season);
		            season.getEpisodes().add(episode);
		        }
		        serie.getSeasons().add(season);
		    }

		    serieRepository.save(serie); 
			
		}catch(Exception e) {
			System.out.println("Serie nao encontrada");
		}
	}
	
	public Page<SerieDetailsResponse> listaSerie(Pageable pageable) {
	    return serieRepository.findAll(pageable).map(SerieDetailsResponse::new);
	}

	public Object pageSerieFavorite(DataDetailsFavoriteSerie dataDetailsFavoriteSerie) {
		return new SerieDetailsResponse(serieRepository.findSerieById(dataDetailsFavoriteSerie.serieId()));
	}

}
