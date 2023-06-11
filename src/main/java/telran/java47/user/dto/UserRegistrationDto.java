package telran.java47.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRegistrationDto {
	String login;
	String password;
	String firstName;
	String lastName;
}
