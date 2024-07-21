package com.project.cinetrack.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.project.cinetrack.domain.user.Status;
import com.project.cinetrack.domain.user.User;
import com.project.cinetrack.domain.user.UserRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

@Service
public class TokenService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Value("${secret}")
	private String secret;
		
	    public String gerarToken(User user) {
	    	
	    	user.setLast_login(LocalDateTime.now());
	    	user.setStatus(Status.active);
	        userRepository.save(user);
	    	
	        try {
	            var algoritmo = Algorithm.HMAC256(secret);
	            return JWT.create()
	                .withIssuer("API CineTrack")
	                .withSubject(user.getEmail())
	                .withClaim("id", user.getId())
	                .withExpiresAt(dataExpiracao())
	                .sign(algoritmo);
	        } catch (JWTCreationException exception){
	            throw new RuntimeException("erro ao gerrar token jwt", exception);
	        }		
	    }
	    
	    public String getSubject(String tokenJWT) {
	        try {
	            var algoritmo = Algorithm.HMAC256(secret);
	            return JWT.require(algoritmo)
	                            .withIssuer("API CineTrack")
	                            .build()
	                            .verify(tokenJWT)
	                            .getSubject();
	        } catch (JWTVerificationException exception) {
	            throw new RuntimeException("Token JWT inválido ou expirado!");
	        }
	    }

	    private Instant dataExpiracao() {
	        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	    }
	    
}
