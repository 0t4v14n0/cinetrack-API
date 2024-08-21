package com.project.cinetrack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.cinetrack.domain.social.chat.ChatService;
import com.project.cinetrack.domain.social.chat.dto.DataSendMessage;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api/chat")
@SecurityRequirement(name = "bearer-key")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/sendMessage")
    public ResponseEntity<Void> receiveMessage(@RequestBody DataSendMessage chatMessage, Authentication authentication) {
        try {
            chatService.handleIncomingMessage(chatMessage, authentication.getName());
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
