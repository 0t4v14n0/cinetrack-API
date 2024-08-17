package com.project.cinetrack.domain.social.friends.dto;

import com.project.cinetrack.domain.user.Status;
import com.project.cinetrack.domain.user.User;

public record RequestFriendsDTO(Long id,
								String name,
								String bio,
								String Avatar,
								Status status) {
	
	public RequestFriendsDTO(User byId, com.project.cinetrack.domain.social.friends.Status status) {
		this(byId.getId(),byId.getName(),byId.getBio(),byId.getAvatar_url(),byId.getStatus());
	}

}
