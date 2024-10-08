package com.project.cinetrack.domain.user.dto;

import com.project.cinetrack.domain.user.User;

public record DataDeteilsUser(
        Long id,
        String name,
        String email,
        String bio,
        String avatar_url
) {
    public DataDeteilsUser(User user) {
        this(user.getId(),
             user.getName(),
             user.getEmail(),
             user.getBio(),
             user.getAvatar_url()
        );
    }
}