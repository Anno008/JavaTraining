package countriesMavenSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import countriesMavenSpring.model.User;
import countriesMavenSpring.repository.UserRepository;

@Component
public class AuthorizationService {

	@Autowired
	private UserRepository userRepository;

	private User loggedUser;

	public boolean login(String userName, String password) {
		User user = userRepository.getAll().stream()
				.filter(u -> u.getUserName().equals(userName) && u.getPassword().equals(password)).findFirst()
				.orElse(null);
		if (user != null)
			loggedUser = user;

		return user == null ? false : true;
	}

	public User getLoggedUser() {
		return loggedUser;
	}
}
