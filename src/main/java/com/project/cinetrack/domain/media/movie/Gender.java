package com.project.cinetrack.domain.media.movie;

public enum Gender {
	
	ACTION,
	COMEDY,
	DRAMA,
	FANTASY,
	HORROR,
	MYSTERY,
	ROMANCE,
	UNKNOWN;
	
    public static Gender fromString(String value) {
    	try {
            for (Gender genre : Gender.values()) {
                if (genre.name().equalsIgnoreCase(value)) {
                    return genre;
                }
            }
            return UNKNOWN;
    		
    	}
    	catch(Exception e){
            return UNKNOWN;
    	}
    }
}
