package telran.java47.user.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserViewDto {
	String login;
	String firstName;
	String lastName;
	List<String> roles;
}
