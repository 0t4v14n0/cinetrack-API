package com.project.cinetrack.domain.user;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.cinetrack.domain.user.dto.DataDeteilsUser;
import com.project.cinetrack.domain.user.dto.DataUpdateUser;

@Service
public class UserService {
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository repository;
	
	public DataDeteilsUser updateUser(DataUpdateUser data, String name) {
		
		User user = findByNome(name);
		
		if(data.name() != null && !data.name().isEmpty()) user.setName(data.name());
		if(data.password() != null && !data.password().isEmpty()) user.setPassword(passwordCrypt(data.password()));
		if(data.email() != null && !data.email().isEmpty()) user.setEmail(data.email());
		if(data.bio()  != null && !data.bio().isEmpty()) user.setBio(data.bio());
		if(data.phone_number()  != null && !data.phone_number().isEmpty()) user.setPhone_number(data.phone_number());
		if(data.avatar_url() != null && !data.avatar_url().isEmpty()) user.setAvatar_url(data.avatar_url());
		user.setUpdated_at(LocalDateTime.now());
		
		repository.save(user);
		
		return new DataDeteilsUser(user);
	}
	
	public DataDeteilsUser userDeteils(String name) {
		return  repository.findDataDetailsByName(name);
	}
	
	public void disableUser(String name) {	
		User user = findByNome(name);
		user.setStatus(Status.disabled);
		repository.save(user);
	}
	
	public User findByNome(String name) {
		return (User) repository.findByEmail(name);
	}
	
	public User findById(Long id) {
		return repository.findUserById(id).get();
	}
	
    public String passwordCrypt(String password) {
    	String psswordEncrypted = passwordEncoder.encode(password);
		return psswordEncrypted;
    }

	public Long getById(String user) {
		return repository.findFirstByEmail(user)
                .map(User::getId)
                .orElse(null);
	}

}
