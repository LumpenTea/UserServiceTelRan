package telran.java47.user.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRolesDto {
	String login;
	List<String> roles;
}
