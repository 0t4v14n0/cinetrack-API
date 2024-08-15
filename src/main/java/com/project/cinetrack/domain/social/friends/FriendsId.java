package com.project.cinetrack.domain.social.friends;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class FriendsId implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column(name = "user1_id")
    private Long user1Id;
    
    @Column(name = "user2_id")
    private Long user2Id;

    public FriendsId() {}

    public FriendsId(Long user1Id, Long user2Id) {
        this.user1Id = user1Id;
        this.user2Id = user2Id;
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

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FriendsId that = (FriendsId) o;
        return Objects.equals(user1Id, that.user1Id) &&
               Objects.equals(user2Id, that.user2Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user1Id, user2Id);
    }

}
