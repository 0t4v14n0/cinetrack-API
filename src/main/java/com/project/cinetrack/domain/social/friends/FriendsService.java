package com.
project.cinetrack.domain.social.friends;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.cinetrack.domain.social.friends.dto.DataInvitedFriends;
import com.project.cinetrack.domain.social.friends.dto.RequestFriendsDTO;
import com.project.cinetrack.domain.user.User;
import com.project.cinetrack.domain.user.UserService;

@Service
public class FriendsService {

    @Autowired
    private UserService userService;

    @Autowired
    private FriendsRepository friendsRepository;

    public void invitedFriends(DataInvitedFriends data, String name) {
        User user = userService.findByNome(name);
        Friends friend = friendsRepository.findByUserIds(data.id(), user.getId());

        if (friend != null) {
            handleExistingFriend(data, user.getId(), friend);
        } else {
            handleNewFriend(data, user);
        }
    }
    
    public Status statusFriend(Long idUser, String name) {

        Long userId = userService.findByNome(name).getId();
        
        Friends friend = friendsRepository.findByUserIds(userId, idUser);
        
        if (friend != null) {
            return friend.getStatus();
        } else {
            throw new IllegalArgumentException("Relacionamento de amizade não encontrado.");
        }
    }
    
    public Object invitesFriend(Pageable pageable, String name) {

        Long userId = userService.getById(name);
        
        Page<Friends> pageRF = friendsRepository.findFriendsByIdAndStatus(userId,Status.INVITED, pageable);
        
        List<Object> dtos = pageRF.stream()
        						  .map(invites -> {
        							  if(invites.getId().getUser1Id() != userId) {
        								  return new RequestFriendsDTO(userService.findById(invites.getId().getUser1Id()),
        										  											invites.getStatus());
        							  }else {
        								  return new RequestFriendsDTO(userService.findById(invites.getId().getUser2Id()),
        										  											invites.getStatus());
        							  }       							  
        						  })
        						  .filter(dto -> dto != null)
        						  .collect(Collectors.toList());
        
        if(dtos.isEmpty()) {
        	throw new IllegalArgumentException();
        }
        
        return new PageImpl<>(dtos, pageable, pageRF.getSize());
    }

	private void handleNewFriend(DataInvitedFriends data, User user) {
	    Friends newFriend = new Friends(user.getId(), data.id());
	    if (data.Status() == Status.BLOCKED) {
	        newFriend.setStatus(Status.BLOCKED);
	    }
	    newFriend.setLastStatus(user.getId());
	    friendsRepository.save(newFriend);
	}
	
	private void handleExistingFriend(DataInvitedFriends data, Long id, Friends friend) {
				
		if(friend.getLastStatus() == id) {
			if(data.Status().equals(Status.UNBLOCK)) {
				if(data.Status().equals(Status.UNBLOCK) && friend.getStatus().equals(Status.BLOCKED)) {
					
					friend.setStatus(Status.INVITED);
					friend.setLastStatus(id);	
				}else{
		            throw new IllegalArgumentException("Only the user you have blocked can be unblocked.");
				}
			}
			
		}else {
			if(data.Status().equals(Status.BLOCKED) && !friend.getStatus().equals(Status.BLOCKED)) {
				friend.setStatus(data.Status());
				friend.setLastStatus(id);	
			}else if(data.Status().equals(Status.ACCEPTED) && friend.getStatus().equals(Status.INVITED)) {
				friend.setStatus(data.Status());
			}else if(data.Status().equals(Status.RECUSED) && friend.getStatus().equals(Status.INVITED)) {
				friendsRepository.delete(friend);
			}
		}
		friend.setStatusAt(LocalDateTime.now());
		friendsRepository.save(friend);
	}

	public Friends findFriend(Long id, Long sender) {
		return friendsRepository.findByUserIds(id, sender);
	}
}