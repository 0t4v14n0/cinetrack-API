package com.project.cinetrack.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DataRegistreUser(	
		@NotBlank
		String name,
		@NotBlank
        @Email
		String email,
		@NotBlank
		String password,
		@NotBlank
		String phone_number
		) {}
