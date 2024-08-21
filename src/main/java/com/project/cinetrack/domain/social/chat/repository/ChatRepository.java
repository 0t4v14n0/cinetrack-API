package com.project.cinetrack.domain.social.chat.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.cinetrack.domain.social.chat.Chat;
import com.project.cinetrack.domain.social.friends.Friends;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

    @Query("SELECT  c FROM Chat c " +
            "WHERE (c.user1.id = :user1 AND c.user2.id = :user2) " +
            "   OR (c.user1.id = :user2 AND c.user2.id = :user1)")
     Chat findByUsersIds(@Param("user1") Long user1, @Param("user2") Long user2);

	Optional<Chat> findById(Friends friend);

}
