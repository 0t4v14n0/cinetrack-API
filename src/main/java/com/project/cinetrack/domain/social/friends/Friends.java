package com.project.cinetrack.domain.social.friends;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "friends")
public class Friends {
	
    @EmbeddedId
    private FriendsId id;

    @Enumerated(EnumType.STRING)
    private Status status;
    
    @Column(name = "last_status")
    private Long lastStatus;

    @Column(name = "invited_at")
    private LocalDateTime invitedAt;

    @Column(name = "status_at")
    private LocalDateTime statusAt;
	
	public Friends() {}
	
	public Friends(Long id1,Long id2) {
		this.id = new FriendsId(id1,id2);
		this.status = Status.INVITED;
		this.lastStatus = id1;
		this.invitedAt = LocalDateTime.now();
		this.statusAt = LocalDateTime.now();
	}

	public FriendsId getId() {
		return id;
	}

	public void setId(FriendsId id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Long getLastStatus() {
		return lastStatus;
	}

	public void setLastStatus(Long lastStatus) {
		this.lastStatus = lastStatus;
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
