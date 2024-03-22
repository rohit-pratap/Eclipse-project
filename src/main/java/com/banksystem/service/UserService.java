package com.banksystem.service;

import java.util.List;

import com.banksystem.dto.UserDTO;

public interface UserService {

	UserDTO createUser(UserDTO userdto);
	
	UserDTO getAccountById(long id);
	
	UserDTO deposite(Long id, double amount);
	
	UserDTO withdraw(Long id, double amount);
	
	List<UserDTO> getAllAcounts();
	
	//UserDTO getAccountByName(String name);

	
	void deleteAccount(Long id);
}
