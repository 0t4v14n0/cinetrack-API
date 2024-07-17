package com.project.cinetrack.domain.user;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository {
	
	UserDetails findByEmail(String Email);

}
