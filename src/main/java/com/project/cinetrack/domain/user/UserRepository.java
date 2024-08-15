package com.project.cinetrack.domain.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.project.cinetrack.domain.user.dto.DataDeteilsUser;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("SELECT new com.project.cinetrack.domain.user.dto.DataDeteilsUser("
			 + "u.id,"
			 + "u.name,"
			 + "u.email,"
			 + "u.bio,"
			 + "u.avatar_url) " 
			 + "FROM User u " 
			 + "WHERE u.name = ?1 AND u.status != 'disabled'")
	DataDeteilsUser findDataDetailsByName(String name);
	
	UserDetails findByEmail(String Email);
	
	Optional<User> findFirstByEmail(String email);

	Optional<User> findUserById(Long id);

}
