package com.project.cinetrack.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DataAutenticationUser(
		@NotBlank
		@Email
		String email,
		@NotBlank
		String password) {}
