package com.project.cinetrack.domain.social.friends;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "friends")
public class Friends {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long user1;
	
	private Long user2;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	private LocalDateTime invitedAt;
	
	private LocalDateTime statusAt;
	
	public Friends() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUser1() {
		return user1;
	}

	public void setUser1(Long user1) {
		this.user1 = user1;
	}

	public Long getUser2() {
		return user2;
	}

	public void setUser2(Long user2) {
		this.user2 = user2;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDateTime getInvitedAt() {
		return invitedAt;
	}

	public void setInvitedAt(LocalDateTime invitedAt) {
		this.invitedAt = invitedAt;
	}

	public LocalDateTime getStatusAt() {
		return statusAt;
	}

	public void setStatusAt(LocalDateTime statusAt) {
		this.statusAt = statusAt;
	}

}
