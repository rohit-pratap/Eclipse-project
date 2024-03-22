package com.banksystem.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banksystem.dto.UserDTO;
import com.banksystem.service.UserService;

@RestController
@RequestMapping("/bank_accounts")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	// Adding User REST API

	@PostMapping("/CreateNewAccount")
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDto) {
		return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
	}

	// Get user Rest API
	@GetMapping("/GetById/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
		UserDTO userDto = userService.getAccountById(id);
		return ResponseEntity.ok(userDto);
	}

	// Deposit Rest API
	@PutMapping("/Deposite/{id}")
	public ResponseEntity<UserDTO> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {

		double amount = request.get("amount");
		UserDTO userDto = userService.deposite(id, amount);
		return ResponseEntity.ok(userDto);
	}

	// Withdraw Rest API
	@PutMapping("/Withdraw/{id}")
	public ResponseEntity<UserDTO> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {

		double amount = request.get("amount");
		UserDTO userDto = userService.withdraw(id, amount);

		return ResponseEntity.ok(userDto);
	}

	// Get All Accounts RestAPI
	@GetMapping("GetAllAccounts")
	public ResponseEntity<List<UserDTO>> getAllAccounts() {
		List<UserDTO> accounts = userService.getAllAcounts();
		return ResponseEntity.ok(accounts);
	}

	// Delete Account Rest API
	@DeleteMapping("DeleteAccount/{id}")
	public ResponseEntity<String> deleteAcount(@PathVariable Long id) {
		userService.deleteAccount(id);
		return ResponseEntity.ok("Account deleted successfully");
	}
	/*
	@GetMapping("/GetByName/{name}")
	public ResponseEntity<UserDTO> getAccountByName(@PathVariable String name) {

		
		UserDTO userDto = userService.getAccountByName(name);
		return ResponseEntity.ok(userDto);
	}
	*/
}
