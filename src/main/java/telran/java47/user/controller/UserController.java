package telran.java47.user.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;

import lombok.RequiredArgsConstructor;
import telran.java47.user.dto.UserChangePasswordDto;
import telran.java47.user.dto.UserLoginDto;
import telran.java47.user.dto.UserRegistrationDto;
import telran.java47.user.dto.UserRolesDto;
import telran.java47.user.dto.UserUpdateDto;
import telran.java47.user.dto.UserViewDto;
import telran.java47.user.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {
	
	final UserService service;
	
	@PostMapping("/register")
	public UserViewDto registerUser(@RequestBody UserRegistrationDto userRegistrationDto) {
		return service.registerUser(userRegistrationDto);
	}
	
	@PostMapping("/login")
	public UserViewDto loginUser(@RequestBody UserLoginDto userLoginDto) {
		return service.loginUser(userLoginDto);
	}
	
	@DeleteMapping("/user/{login}")
	public UserViewDto deleteUser(@PathVariable String login) {
		return service.deleteUser(login);
	}
	
	@PutMapping("/user/{login}")
	public UserViewDto udpateUser(@RequestBody UserUpdateDto userUpdateDto, @PathVariable String login) {
		return service.updateUser(userUpdateDto, login);
	}
	
	@PutMapping("/user/{login}/role/{role}")
	public UserRolesDto addRole(@PathVariable String login, @PathVariable String role) {
		return service.addRole(login, role);
	}
	
	@DeleteMapping("/user/{login}/role/{role}")
	public UserRolesDto deleteRole(@PathVariable String login, @PathVariable String role) {
		return service.deleteRole(login, role);
	}
	
	@PutMapping("/user/password")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void changePassword(@RequestBody UserChangePasswordDto userChangePasswordDto) {
		service.changePassword(userChangePasswordDto);
	}
}

