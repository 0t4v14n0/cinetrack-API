package com.project.cinetrack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.cinetrack.domain.social.friends.FriendsService;
import com.project.cinetrack.domain.social.friends.dto.DataInvitedFriends;

@RestController
@RequestMapping("/friends")
public class FriendsController {
	
	@Autowired
	private FriendsService friendsService;
	
    @PostMapping
    public ResponseEntity<?> inviteFriends(@RequestBody DataInvitedFriends data,
    													Authentication authentication) {
        try {
            friendsService.invitedFriends(data, authentication.getName());
            return ResponseEntity.ok().body(data.Status());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro");
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> statusFriend(@PathVariable(name = "id") Long idUser,
                                           Authentication authentication) {
        try {
            com.project.cinetrack.domain.social.friends.Status status = friendsService.statusFriend(idUser, authentication.getName());
            
            return ResponseEntity.ok(status);
        } catch (Exception e) {
            return ResponseEntity.status(400)
                                 .body("Friendship relationship not found.");
        }
    }
    
    @GetMapping("/invites")
    public ResponseEntity<Object> invitesFriend(@PageableDefault(size = 10,
			  													  sort = {"id"}) Pageable pageable,
    																			 Authentication authentication) {
		
    	try {
        	return ResponseEntity.ok(friendsService.invitesFriend(pageable,authentication.getName()));
    	}catch(Exception e) {
            return ResponseEntity.status(400)
                                 .body("You don't have any new friend invitations");
        }
    }
}
