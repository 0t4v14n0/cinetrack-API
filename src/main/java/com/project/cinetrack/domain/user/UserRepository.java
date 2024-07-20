package com.project.cinetrack.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("SELECT new com.project.cinetrack.domain.user.DataDeteilsUser(u.id,"
			+ "u.name,"
			+ "u.email,"
			+ "u.bio,"
			+ "u.avatar_url)"
			+ "FROM User u WHERE u.name = ?1")
	DataDeteilsUser findDataDetailsByName(String name);
	
	UserDetails findByEmail(String Email);

}
