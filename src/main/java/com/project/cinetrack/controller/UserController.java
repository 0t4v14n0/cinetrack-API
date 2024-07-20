package com.project.cinetrack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;

import com.project.cinetrack.domain.user.DataDeteilsUser;
import com.project.cinetrack.domain.user.DataUpdateUser;
import com.project.cinetrack.domain.user.UserService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/{name}")
	public ResponseEntity<DataDeteilsUser> userDeteils(@PathVariable("name") String name){
		return ResponseEntity.ok(userService.userDeteils(name));
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<DataDeteilsUser> updateUser(@RequestBody @Valid DataUpdateUser data,
														Authentication authentication) {	
		String userLogin = authentication.getName();
		return ResponseEntity.ok(userService.updateUser(data, userLogin));		
	}
	
	@DeleteMapping
	@Transactional
	public ResponseEntity disaleUser() {
		
		return null;
	}

}
