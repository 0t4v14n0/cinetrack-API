package com.project.cinetrack.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.cinetrack.domain.social.chat.ChatService;
import com.project.cinetrack.domain.social.chat.dto.DataSendMessage;

@RestController
@RequestMapping("/chat")
public class ChatController {
	
	private ChatService chatService;

	@PostMapping
    @Transactional
    public ResponseEntity<?> sendMessage(@RequestBody DataSendMessage data,
			   										  Authentication authentication){
    	try {
        	return ResponseEntity.ok(chatService.sendMessage(data,authentication.getName()));
    	}catch(Exception e) {
            return ResponseEntity.status(400)
                                 .body("You don't have any new friend invitations");
        }	}
}
