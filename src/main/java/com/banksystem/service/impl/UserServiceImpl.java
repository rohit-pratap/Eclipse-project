package com.banksystem.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.banksystem.dto.UserDTO;
import com.banksystem.dto.UserMapper;
import com.banksystem.exception.InsufficientBalanceException;
import com.banksystem.exception.UserNotFoundException;
import com.banksystem.model.User;
import com.banksystem.repository.UserRepository;
import com.banksystem.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	//@Autowire
	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDTO createUser(UserDTO userdto) {
		User user = UserMapper.mapToUser(userdto);
		User savedUser = userRepository.save(user);

		return UserMapper.mapToUserDTO(savedUser);
	}

	@Override
	public UserDTO getAccountById(long id) {
		User user = userRepository.findById(id)
				                  .orElseThrow(() -> new UserNotFoundException());

		return UserMapper.mapToUserDTO(user);
	}

	@Override
	public UserDTO deposite(Long id, double amount) {
		
		User user = userRepository.findById(id)
				                  .orElseThrow(() -> new UserNotFoundException());
		
		double totalbalance = user.getBalance() + amount;
		user.setBalance(totalbalance);
		User savedUser = userRepository.save(user);

		return UserMapper.mapToUserDTO(savedUser);

	}

	@Override
	public UserDTO withdraw(Long id, double amount) {

		User user = userRepository.findById(id)
				                  .orElseThrow(() -> new UserNotFoundException());
		
		//Throw exception when withdraw amount is greater than balance
		if(user.getBalance()<amount) {
			throw new InsufficientBalanceException();
		}
		
		double totalAmount=user.getBalance()-amount;
		user.setBalance(totalAmount);
		
		User newUser=userRepository.save(user);
		
		return UserMapper.mapToUserDTO(newUser);
	}

	@Override
	public List<UserDTO> getAllAcounts() {

		List<User> users= userRepository.findAll();
		return users.stream().map((user)-> UserMapper.mapToUserDTO(user)).collect(Collectors.toList());


	}

	@Override
	public void deleteAccount(Long id) {
		
	User user = userRepository.findById(id)
			                  .orElseThrow(() -> new UserNotFoundException());

	userRepository.deleteById(id);
	
	}
/*
	@Override
	public UserDTO getAccountByName(String name) {
		User user=userRepository.findByName(name);//.orElseThrow(() -> new UserNotFoundException());
		
		return UserMapper.mapToUserDTO(user);
	}
*/
	 
}