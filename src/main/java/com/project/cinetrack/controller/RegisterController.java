package com.project.cinetrack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.project.cinetrack.domain.user.DataDeteilsUser;
import com.project.cinetrack.domain.user.DataRegisterUser;
import com.project.cinetrack.domain.user.User;
import com.project.cinetrack.domain.user.UserRepository;
import com.project.cinetrack.domain.user.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private UserService userService;
	
    @PostMapping
    @Transactional
    public ResponseEntity<DataDeteilsUser> register(@RequestBody @Valid DataRegisterUser data, UriComponentsBuilder uriBuilder ) {	
    	var user = new User(data);	
    	user.setPassword(userService.passwordCrypt(data.password()));   	
    	repository.save(user);    	
    	var uri = uriBuilder.path("").buildAndExpand(user.getId()).toUri();
    	return ResponseEntity.created(uri).body(new DataDeteilsUser(user));		
    }

}
