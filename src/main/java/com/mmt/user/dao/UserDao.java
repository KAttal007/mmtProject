package com.mmt.user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmt.user.model.User;

public interface UserDao extends JpaRepository<User, String>{
	boolean findByEmailIdAndPassword(String emailId , String password);
	List<User> findByUserId(String userId);

}
