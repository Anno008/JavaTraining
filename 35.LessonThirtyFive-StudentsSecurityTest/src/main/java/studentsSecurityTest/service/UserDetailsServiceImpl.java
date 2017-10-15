package studentsSecurityTest.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import studentsSecurityTest.model.user.SecurityAuthority;
import studentsSecurityTest.model.user.SecurityUser;
import studentsSecurityTest.model.user.SecurityUserAuthority;
import studentsSecurityTest.repository.AuthorityRepository;
import studentsSecurityTest.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthorityRepository authorityRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SecurityUser user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
		} else {
			List<GrantedAuthority> grantedAuthorities = user.getUserAuthorities().stream()
					.map(authority -> new SimpleGrantedAuthority(authority.getAuthority().getName()))
					.collect(Collectors.toList());

			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					grantedAuthorities);
		}
	}

	public SecurityUser register(SecurityUser securityUser, List<String> roles) {
		if (userRepository.findByUsername(securityUser.getUsername()) != null)
			return null;
		else {
			for (String role : roles) {
				SecurityAuthority authority = authorityRepository.findByName(role);
				SecurityUserAuthority sua = new SecurityUserAuthority();
				sua.setAuthority(authority);
				sua.setUser(securityUser);

				securityUser.getUserAuthorities().add(sua);
			}
			securityUser.setPassword((passwordEncoder.encode(securityUser.getPassword())));
			return userRepository.save(securityUser);
		}
	}

}
