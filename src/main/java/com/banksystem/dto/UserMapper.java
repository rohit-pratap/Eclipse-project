package com.banksystem.dto;

import com.banksystem.model.User;

public class UserMapper {
	
	public static User mapToUser(UserDTO userDto) {
		User user = new User(userDto.getId(), 
				             userDto.getUserName(), 
				             userDto.getBalance()
				             );

		return user;
	}
	
	public static UserDTO mapToUserDTO(User user) {
		UserDTO userDto=new UserDTO(user.getId(),
				                    user.getName(),
				                    user.getBalance()
				                    );
		return userDto;
	}

}