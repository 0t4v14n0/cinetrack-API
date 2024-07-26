package com.project.cinetrack.domain.extern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class DataConverter implements IDataConverter {
	
	@Autowired
	private ObjectMapper mapper = new ObjectMapper();

	@Override
	public <T> T getData(String json, Class<T> classe) {
		try {
			return mapper.readValue(json, classe);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
