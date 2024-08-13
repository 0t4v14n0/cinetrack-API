package com.project.cinetrack.domain.social.friends.dto;

import jakarta.validation.constraints.NotNull;

import com.project.cinetrack.domain.social.friends.Status;

public record DataInvitedFriends(@NotNull
								 Long id,
								 @NotNull
								 Status Status) {}
