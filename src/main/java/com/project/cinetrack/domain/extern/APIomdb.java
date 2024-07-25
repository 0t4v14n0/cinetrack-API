package com.project.cinetrack.domain.extern;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Service;

@Service
public class APIomdb {
	
	private static final String BASE_URL = "https://www.omdbapi.com/?t=";
	private static final String apiKey = "API-KEY";
    
    public String busca(String nome,String temporada,String episodio) throws IOException, InterruptedException { 

        String termoBuscaEncoded = URLEncoder.encode(nome, StandardCharsets.UTF_8);
        
        String endereco = "";
        
        if (temporada != "") {
        	        	
        	if(episodio != "") {
        		
        		endereco = BASE_URL + termoBuscaEncoded +"&season="+temporada+"&episode="+episodio+ apiKey;
        		
        	}else {
        		endereco = BASE_URL + termoBuscaEncoded +"&season="+temporada+ apiKey;
        	}
        	
        }else {
        	endereco = BASE_URL + termoBuscaEncoded + apiKey;
        }

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());   
                        
        String retorno = response.body();
        
        return retorno;
        
    }

}
