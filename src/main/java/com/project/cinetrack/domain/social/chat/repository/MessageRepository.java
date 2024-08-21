package com.project.cinetrack.domain.social.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.cinetrack.domain.social.chat.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
