package com.project.cinetrack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.cinetrack.domain.user.DataDeteilsUser;
import com.project.cinetrack.domain.user.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/{name}")
	public ResponseEntity<DataDeteilsUser> userDeteils(@PathVariable("name") String name){
		return ResponseEntity.ok(userService.userDeteils(name));
	}

}
