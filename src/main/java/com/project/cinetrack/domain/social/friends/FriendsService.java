package com.project.cinetrack.domain.social.friends;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.cinetrack.domain.social.friends.dto.DataInvitedFriends;
import com.project.cinetrack.domain.user.UserService;

@Service
public class FriendsService {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FriendsRepository friendsRepository;

	public void invitedFriends(DataInvitedFriends data, String name) {
				
		Friends f = friendsRepository.findById(data.id(),userService.findByNome(name));
		
		if(f == null) {
			Friends fId = new Friends(userService.findByNome(name).getId(),data.id());
			if(data.Status() == Status.BLOCKED){
				fId.setStatus(Status.BLOCKED);
			}
			friendsRepository.save(fId);
			
		}else {
			
			if(data.Status() == Status.UNLOCK) {
				f.setStatus(Status.INVITED);
			}else if(data.Status() == Status.RECUSED) {
				f.setStatus(Status.RECUSED);
				friendsRepository.delete(f);
			}else if(data.Status() == Status.ACCEPTED){
				f.setStatus(Status.ACCEPTED);
			}
			else if(data.Status() == Status.BLOCKED){
				f.setStatus(Status.BLOCKED);
			}
			f.setStatusAt(LocalDateTime.now());
			friendsRepository.save(f);
		}
	}
}
