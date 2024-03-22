package com.banksystem.dto;

public class UserDTO {

	private Long id;
	private String userName;
	private double balance;

	public UserDTO(Long id, String userName, double balance) {
	
		this.id = id;
		this.userName = userName;
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
