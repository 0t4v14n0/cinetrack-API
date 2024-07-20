package com.project.cinetrack.domain.user;

import jakarta.validation.constraints.Email;

public record DataUpdateUser(		
		String name,
        @Email
		String email,
		String password,
		String phone_number,	
		String bio,
		String avatar_url) {
	
}
