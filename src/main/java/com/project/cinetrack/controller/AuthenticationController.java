package com.project.cinetrack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.project.cinetrack.domain.user.DataAutenticationUser;
import com.project.cinetrack.domain.user.User;
import com.project.cinetrack.infra.security.TokenDataJWT;
import com.project.cinetrack.infra.security.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
	
    @Autowired
    private AuthenticationManager manager;
    
    @Autowired
    private TokenService tokenService;
    
    @PostMapping
    @Transactional
    public ResponseEntity<?> login(@RequestBody @Valid DataAutenticationUser data, UriComponentsBuilder uriBuilder) {
    	
        var authenticationToken = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        System.out.println(authenticationToken);
        var authentication = manager.authenticate(authenticationToken);   
        var tokenJWT = tokenService.gerarToken((User)authentication.getPrincipal());   
        return ResponseEntity.ok(new TokenDataJWT(tokenJWT));
        
    }

}
