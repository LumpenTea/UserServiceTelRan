package telran.java47.user.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import telran.java47.user.dao.ServiceRepository;
import telran.java47.user.dto.UserChangePasswordDto;
import telran.java47.user.dto.UserLoginDto;
import telran.java47.user.dto.UserRegistrationDto;
import telran.java47.user.dto.UserRolesDto;
import telran.java47.user.dto.UserUpdateDto;
import telran.java47.user.dto.UserViewDto;
import telran.java47.user.exception.UserNotFoundException;
import telran.java47.user.model.User;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	final ServiceRepository repository;
	final ModelMapper modelMapper;
	
	@Override
	public UserViewDto registerUser(UserRegistrationDto userRegistrationDto) {
		if(!repository.existsByLogin(userRegistrationDto.getLogin())) {
			User user = repository.save(modelMapper.map(userRegistrationDto, User.class));
			return modelMapper.map(user, UserViewDto.class);
		}
		return null;
	}

	@Override
	public UserViewDto loginUser(UserLoginDto userLoginDto) {
		User user = repository.findByLogin(userLoginDto.getLogin()).orElseThrow(() -> new UserNotFoundException());
		if(user.getPassword().equals(userLoginDto.getPassword())) {
			return modelMapper.map(user, UserViewDto.class);
		}
		return null;
	}

	@Override
	public UserViewDto deleteUser(String login) {
		User user = repository.findByLogin(login).orElseThrow(() -> new UserNotFoundException());
		repository.deleteByLogin(user.getLogin());
		return modelMapper.map(user, UserViewDto.class);
	}

	@Override
	public UserViewDto updateUser(UserUpdateDto userUpdateDto, String login) {
		User user = repository.findByLogin(login).orElseThrow(() -> new UserNotFoundException());
		user.setFirstName(userUpdateDto.getFirstName());
		user.setLastName(userUpdateDto.getLastName());
		repository.save(user);
		return modelMapper.map(user, UserViewDto.class);
	}

	@Override
	public UserRolesDto addRole(String login, String role) {
		User user = repository.findByLogin(login).orElseThrow(() -> new UserNotFoundException());
		user.addRole(role);
		repository.save(user);
		return modelMapper.map(user, UserRolesDto.class);
	}

	@Override
	public UserRolesDto deleteRole(String login, String role) {
		User user = repository.findByLogin(login).orElseThrow(() -> new UserNotFoundException());
		user.deleteRole(role);
		repository.save(user);
		return modelMapper.map(user, UserRolesDto.class);
	}

	@Override
	public void changePassword(UserChangePasswordDto userChangePasswordDto) {
		User user = repository.findByLogin(userChangePasswordDto.getLogin()).orElseThrow(() -> new UserNotFoundException());
		user.setPassword(userChangePasswordDto.getPassword());
		repository.save(user);
	}

}
