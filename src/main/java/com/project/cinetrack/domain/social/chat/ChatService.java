package com.project.cinetrack.domain.social.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cinetrack.domain.social.chat.dto.DataSendMessage;
import com.project.cinetrack.domain.social.friends.FriendsService;
import com.project.cinetrack.domain.social.friends.Status;
import com.project.cinetrack.domain.user.User;
import com.project.cinetrack.domain.user.UserService;

@Service
public class ChatService {
	
	@Autowired
	private ChatRepository chatRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FriendsService friendsService;

	public Object sendMessage(DataSendMessage data, String name) {
		
		if(friendsService.statusFriend(data.id(), name) == Status.ACCEPTED) {
			//Chat chat = new Chat (data,userService.findByNome(name),userService.findById(data.id()));
		
		}else {
			
		}
		return null;
	}

}
