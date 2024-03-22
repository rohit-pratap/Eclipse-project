package com.banksystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banksystem.model.User;


public interface UserRepository extends JpaRepository<User, Long> {

	//User findByName(String name);
}
