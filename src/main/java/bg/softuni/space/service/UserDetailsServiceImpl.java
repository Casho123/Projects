package bg.softuni.space.service;

import bg.softuni.space.model.entity.UserRole;
import bg.softuni.space.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.stream.Collectors;

public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return userRepository.
                findByUsername(username).
                map(u -> new User(
                        u.getUsername(),
                        u.getPassword(),
                        u.getUserRoles().stream()
                                .map(r -> new SimpleGrantedAuthority("ROLE_" + r.getUserRole().name()))
                                .collect(Collectors.toList())
                )).orElseThrow(() -> new UsernameNotFoundException("User with username " + username + " not found!"));
    }



    private GrantedAuthority map(UserRole userRole) {
        return new SimpleGrantedAuthority("ROLE_" +
                userRole.
                        getUserRole().name());
    }
}
