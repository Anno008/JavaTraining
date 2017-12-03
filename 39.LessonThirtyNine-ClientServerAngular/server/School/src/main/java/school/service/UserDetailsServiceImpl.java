package school.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import school.model.SecurityUser;
import school.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final SecurityUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("No user found with username '%s'.", username)));
        final List<GrantedAuthority> grantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRole().name()));

        return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
    
    public SecurityUser register(SecurityUser user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
    }
}
