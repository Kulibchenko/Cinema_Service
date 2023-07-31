package cinema.security;

import static org.springframework.security.core.userdetails.User.withUsername;

import cinema.model.Role;
import cinema.model.User;
import cinema.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userOptional = userService.findByEmail(email);
        User user = userOptional.orElseThrow(() ->
                new UsernameNotFoundException("User with email = " + email + " not found"));
        UserBuilder builder = withUsername(email);
        builder.password(user.getPassword());
        String[] roles = user.getRoles().stream().map(Role::getAuthority)
                .toArray(String[]::new);
        if (roles.length > 0) {
            builder.roles(roles);
        }
        return builder.build();
    }
}
