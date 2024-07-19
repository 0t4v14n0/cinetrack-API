package com.project.cinetrack.domain.user;

public record DataDeteilsUser(
		Long id,
		String nome,
		String email) {

	public DataDeteilsUser(User user) {
		this(user.getId(),user.getName(),user.getEmail());
	}

}
