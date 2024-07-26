package com.project.cinetrack.domain.extern;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExternService {
	
	@Autowired
	private APIomdb omdbb;
	
    public String searchOMDb(String title, String string, String string2) throws IOException, InterruptedException {
    	
    	String json = omdbb.busca(title, string, string2);

		return json;   	
    }

}
