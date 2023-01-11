package com.example.user.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Query("Select u from User u where u.userId = :id")
	public User findByUserId(@Param("id") long id);
	
	public User findByEmail(String email);

}
