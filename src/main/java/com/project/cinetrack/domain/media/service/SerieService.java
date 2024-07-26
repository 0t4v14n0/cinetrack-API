package com.project.cinetrack.domain.media.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cinetrack.domain.extern.DataConverter;
import com.project.cinetrack.domain.extern.ExternService;
import com.project.cinetrack.domain.extern.dto.DataEpisode;
import com.project.cinetrack.domain.extern.dto.DataSeason;
import com.project.cinetrack.domain.extern.dto.DataSerie;
import com.project.cinetrack.domain.media.dto.DataRegisterMedia;
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
		
		return serie1;
	}

	public void registerSerie(DataRegisterMedia data) throws IOException, InterruptedException {
		
		System.out.println(data.title());

	    String json = externService.searchOMDb(data.title(), "", "");
	    
	    System.out.println(json);
	    
	    DataSerie dataS = dataConverter.getData(json, DataSerie.class);
	    
	    System.out.println("dataSerie: "+dataS);
	    
	    Serie serie = new Serie(dataS);
	    	    
	    System.out.println("serie: "+dataS);

	    for (int seasonNumber = 1; seasonNumber <= serie.getTotalSeason(); seasonNumber++) {
	    	
		    System.out.println("entrou aqui");

	    	
	        String json2 = externService.searchOMDb(data.title(), ""+seasonNumber, "");
	        
	        System.out.println(json2);
	        
	        DataSeason dataT = dataConverter.getData(json2, DataSeason.class);
	        
	        System.out.println(dataT);
	        
	        Season season = new Season(dataT, serie);
	        
	        System.out.println(season);
	        
	        List<DataEpisode> dataEpisodes = dataT.episodios();
	        
	        System.out.println("6");
	        
	        for (DataEpisode dataE : dataEpisodes) {
	        	System.out.println(dataE);
	            Episode episode = new Episode(dataE, season);
	            season.getEpisodes().add(episode);
	        }
	        
	        serie.getSeasons().add(season);
	    }

	    serieRepository.save(serie);
	    
	}

}
