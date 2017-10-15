package studentsSecurityTest.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import studentsSecurityTest.model.user.SecurityUser;

public class UserDTO {
	private Long id;
	private String username;
	private String password;
	private String name;
	private String surname;
	private List<String> roles = new ArrayList<String>();

	public UserDTO() {

	}

	public UserDTO(Long id, String username, String password, String name, String surname, List<String> roles) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.roles = roles;
	}

	public UserDTO(SecurityUser user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.name = user.getFirstName();
		this.surname = user.getLastName();
		this.roles = user.getUserAuthorities().stream().map(a -> a.getAuthority().getName())
				.collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
}
