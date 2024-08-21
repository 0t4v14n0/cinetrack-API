package com.project.cinetrack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import com.project.cinetrack.domain.social.chat.ChatService;
import com.project.cinetrack.domain.social.chat.dto.DataSendMessage;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@Controller
@SecurityRequirement(name = "bearer-key")
public class ChatWebSocketController {

    @Autowired
    private ChatService chatService;

    @MessageMapping("/sendMessage")
    @SendToUser("/queue/messages")
    public DataSendMessage receiveMessage(DataSendMessage chatMessage, Authentication authentication) {
        chatService.handleIncomingMessage(chatMessage, authentication.getName());
        return chatMessage;
    }
}
