package com.project.cinetrack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.cinetrack.domain.social.chat.ChatService;
import com.project.cinetrack.domain.social.chat.dto.DataSendMessage;

@RestController
@RequestMapping("/chat")
public class ChatController {
	
    @Autowired
    private ChatService chatService;

    @MessageMapping("/sendMessage")
    public void receiveMessage(DataSendMessage chatMessage, Authentication authentication) {
        try {
            // Persiste a mensagem e a envia ao destinatário
            chatService.handleIncomingMessage(chatMessage,authentication.getName());
        }catch(IllegalArgumentException e) {
            ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
