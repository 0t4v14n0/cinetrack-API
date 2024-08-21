package com.project.cinetrack.domain.social.chat;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.project.cinetrack.domain.social.chat.dto.DataSendMessage;
import com.project.cinetrack.domain.social.chat.repository.ChatRepository;
import com.project.cinetrack.domain.social.chat.repository.MessageRepository;
import com.project.cinetrack.domain.social.friends.FriendsService;
import com.project.cinetrack.domain.social.friends.Status;
import com.project.cinetrack.domain.user.UserService;

@Service
public class ChatService {
	
	@Autowired
	private ChatRepository chatRepository;
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private UserService userService;
	
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
	
	@Autowired
	private FriendsService friendsService;

    public void handleIncomingMessage(DataSendMessage chatMessage,String sender) {
    	
    	if(friendsService.statusFriend(chatMessage.id(), sender) != Status.ACCEPTED) {
    		throw new IllegalArgumentException("You cannot send a message to this user.");
    	}
    	
        Chat chat = chatRepository.findById(friendsService.findFriend(chatMessage.id(), userService.findByNome(sender).getId()))
                                  .orElseThrow(() -> new IllegalArgumentException("Chat not found"));

        Message message = new Message();
        message.setSender(userService.findById(userService.findByNome(sender).getId()));
        message.setChat(chat);
        message.setContent(chatMessage.message());
        message.setTimestamp(LocalDateTime.now());
        messageRepository.save(message);

        // envia a mensagem ao destinatario em tempo real
        messagingTemplate.convertAndSendToUser(
        	String.valueOf(chatMessage.id()),
            "/queue/messages",
            chatMessage
        );
    }
}
