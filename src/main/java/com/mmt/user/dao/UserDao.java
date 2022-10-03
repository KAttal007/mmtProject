package com.mmt.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmt.user.model.UserDetails;

public interface UserDao extends JpaRepository<UserDetails, String>{

}
