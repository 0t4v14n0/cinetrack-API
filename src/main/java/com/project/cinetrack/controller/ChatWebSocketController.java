package com.project.cinetrack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import com.project.cinetrack.domain.social.chat.ChatService;
import com.project.cinetrack.domain.social.chat.dto.DataSendMessage;

@Controller
public class ChatWebSocketController {

    @Autowired
    private ChatService chatService;

    @MessageMapping("/sendMessage")
    @SendToUser("/queue/messages")
    public DataSendMessage receiveMessage(DataSendMessage chatMessage, Authentication authentication) {

        // persiste a mensagem e a envia ao destinatario
        chatService.handleIncomingMessage(chatMessage, authentication.getName());
        
        return chatMessage;
    }
}
