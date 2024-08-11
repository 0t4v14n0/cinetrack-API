package com.project.cinetrack.domain.social.friends;

import java.time.LocalDateTime;

import com.project.cinetrack.domain.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "friends")
public class Friends {
	
    @Id
    @Column(name = "user1_id")
    private Long user1Id;

    @Id
    @Column(name = "user2_id")
    private Long user2Id;

    @ManyToOne
    @JoinColumn(name = "user1_id", insertable = false, updatable = false)
    private User user1;

    @ManyToOne
    @JoinColumn(name = "user2_id", insertable = false, updatable = false)
    private User user2;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime invitedAt;

    private LocalDateTime statusAt;
	
	public Friends() {
		
	}

	public Long getUser1Id() {
		return user1Id;
	}

	public void setUser1Id(Long user1Id) {
		this.user1Id = user1Id;
	}

	public Long getUser2Id() {
		return user2Id;
	}

	public void setUser2Id(Long user2Id) {
		this.user2Id = user2Id;
	}

	public User getUser1() {
		return user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return user2;
	}

	public void setUser2(User user2) {
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
