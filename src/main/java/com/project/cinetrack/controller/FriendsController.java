package com.project.cinetrack.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.cinetrack.domain.social.friends.FriendsService;
import com.project.cinetrack.domain.social.friends.dto.DataInvitedFriends;

@RestController
@RequestMapping("/friends")
public class FriendsController {
	
	//    INVITED
	//    RECUSED
	//    ACCEPTED
	//    BLOCKED
	//
	
	private FriendsService friendsService;
	
	@PostMapping
    public ResponseEntity<?> inviedFriends(@RequestBody DataInvitedFriends data,
    												    Authentication authentication){
		friendsService.invitedFriends(data,authentication.getName());
		return ResponseEntity.ok().body("Envited");
	}

}
