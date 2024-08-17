package com.project.cinetrack.domain.social.chat.dto;

import jakarta.validation.constraints.NotNull;

public record DataSendMessage(@NotNull 
							  Long id,
							  String message) {}
