package com.project.cinetrack.domain.social.friends;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.cinetrack.domain.user.User;

import jakarta.validation.constraints.NotNull;

public interface FriendsRepository extends JpaRepository<Friends, FriendsId> {

	Friends findById(@NotNull Long id, User byNome);

}
