package telran.java47.user.service;

import telran.java47.user.dto.UserChangePasswordDto;
import telran.java47.user.dto.UserLoginDto;
import telran.java47.user.dto.UserRegistrationDto;
import telran.java47.user.dto.UserRolesDto;
import telran.java47.user.dto.UserUpdateDto;
import telran.java47.user.dto.UserViewDto;

public interface UserService {
	
	UserViewDto registerUser(UserRegistrationDto userRegistrationDto);
	
	UserViewDto loginUser(UserLoginDto userLoginDto);
	
	UserViewDto deleteUser(String login);
	
	UserViewDto updateUser(UserUpdateDto userUpdateDto, String login);
	
	UserRolesDto addRole(String login, String role);
	
	UserRolesDto deleteRole(String login, String role);
	
	void changePassword(UserChangePasswordDto userChangePasswordDto);
}
