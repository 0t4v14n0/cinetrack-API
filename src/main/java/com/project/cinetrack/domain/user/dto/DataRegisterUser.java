package com.project.cinetrack.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DataRegisterUser(	
		@NotBlank
		String name,
		@NotBlank
        @Email
		String email,
		@NotBlank
		String password,
		@NotBlank
		String phone_number,	
		String bio,
		String avatar_url
		) {}
