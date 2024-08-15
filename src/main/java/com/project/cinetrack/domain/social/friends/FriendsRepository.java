package com.project.cinetrack.domain.social.friends;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FriendsRepository extends JpaRepository<Friends, FriendsId> {
	
	@Query("SELECT f FROM Friends f WHERE (f.id.user1Id = :user1Id AND f.id.user2Id = :user2Id) OR (f.id.user1Id = :user2Id AND f.id.user2Id = :user1Id)")
	Friends findByUserIds(@Param("user1Id") Long user1Id, @Param("user2Id") Long user2Id);

	@Query("SELECT f FROM Friends f WHERE ((f.id.user1Id = :userId) OR (f.id.user2Id = :userId))"
		       + " AND f.status = :status AND f.lastStatus != :userId")
	Page<Friends> findFriendsByIdAndStatus(Long userId, Status status, Pageable pageable);
	
}
