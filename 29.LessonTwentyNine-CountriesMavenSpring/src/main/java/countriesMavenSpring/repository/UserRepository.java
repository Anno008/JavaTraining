package countriesMavenSpring.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import countriesMavenSpring.model.User;

@Component("userRepository")
public class UserRepository {
	private List<User> users = new ArrayList<User>();

	public UserRepository() {
		users.add(new User("admin", "admin", true));
		users.add(new User("guest", "guest", false));
	}

	public List<User> getAll() {
		return users;
	}
}
