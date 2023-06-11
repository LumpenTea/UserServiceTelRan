package telran.java47.user.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@EqualsAndHashCode (of = "login")
public class User {
	@Id
	String login;
	@Setter
	String firstName;
	@Setter
	String lastName;
	@Setter
	String password;
	List<String> roles = new ArrayList<>();
	
	public void addRole(String role) {
		role = role.toUpperCase();
		if(!roles.contains(role)) {
			roles.add(role);
		}
	}
	
	public void deleteRole(String role) {
		role = role.toUpperCase();
		if(roles.contains(role)) {
			roles.remove(role);
		}
	}
}
