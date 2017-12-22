package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import project.dto.LoginDTO;
import project.dto.TokenDTO;
import project.dto.UserDTO;
import project.model.security.Role;
import project.model.security.SecurityUser;
import project.security.TokenUtils;
import project.service.UserDetailsServiceImpl;

@RestController
public class UserController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private TokenUtils tokenUtils;

	@PostMapping(value = "/api/login")
	public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO loginDTO) {
		return generateToken(loginDTO.getUsername(), loginDTO.getPassword());
	}

	@RequestMapping(value = "/api/register", method = RequestMethod.POST)
	public ResponseEntity<TokenDTO> register(@RequestBody UserDTO userDTO) {
		SecurityUser user = new SecurityUser();
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		user.setRole(Role.User);

		user = userDetailsService.register(user);

		if (user == null) 
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		return generateToken(user.getUsername(), userDTO.getPassword());
	}

	private ResponseEntity<TokenDTO> generateToken(String username, String rawPassword) {
		try {
			final UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username,
					rawPassword);
			final Authentication authentication = authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			final UserDetails details = userDetailsService.loadUserByUsername(username);
			final String genToken = tokenUtils.generateToken(details);

			return new ResponseEntity<>(new TokenDTO(genToken), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<>(new TokenDTO(""), HttpStatus.BAD_REQUEST);
		}
	}
}