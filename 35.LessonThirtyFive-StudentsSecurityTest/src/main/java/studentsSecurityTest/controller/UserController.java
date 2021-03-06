package studentsSecurityTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import studentsSecurityTest.dto.LoginDTO;
import studentsSecurityTest.dto.UserDTO;
import studentsSecurityTest.model.user.SecurityUser;
import studentsSecurityTest.security.TokenUtils;
import studentsSecurityTest.service.UserDetailsServiceImpl;

@RestController
public class UserController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private TokenUtils tokenUtils;

	@RequestMapping(value = "/api/login", method = RequestMethod.POST)
	public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
		try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginDTO.getUsername(),
					loginDTO.getPassword());
			Authentication authentication = authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			UserDetails details = userDetailsService.loadUserByUsername(loginDTO.getUsername());
			return new ResponseEntity<String>(tokenUtils.generateToken(details), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Invalid login", HttpStatus.BAD_REQUEST);
		}
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/api/register", method = RequestMethod.POST)
	public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO) {
		SecurityUser user = new SecurityUser();
		user.setFirstName(userDTO.getName());
		user.setLastName(userDTO.getSurname());
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());

		user = userDetailsService.register(user, userDTO.getRoles());
		if (user != null)
			return new ResponseEntity<>(new UserDTO(user), HttpStatus.CREATED);
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
