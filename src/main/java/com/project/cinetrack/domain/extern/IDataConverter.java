package com.project.cinetrack.domain.extern;

public interface IDataConverter {
	
	<T> T getData(String json, Class<T> classe);

}
