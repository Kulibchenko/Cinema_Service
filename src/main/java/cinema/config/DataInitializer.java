package cinema.config;

import cinema.model.Role;
import cinema.model.User;
import cinema.service.RoleService;
import cinema.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private static final String DEFAULT_ADMIN_NAME = "admin@i.ua";
    private static final String DEFAULT_PASSWORD = "1234";
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void injectDefaultRolesAndAdmin() {
        Role adminRole = new Role();
        adminRole.setRoleName(Role.RoleName.ADMIN);
        roleService.add(adminRole);
        Role userRole = new Role();
        userRole.setRoleName(Role.RoleName.USER);
        roleService.add(userRole);
        User user = new User();
        user.setEmail(DEFAULT_ADMIN_NAME);
        user.setPassword(passwordEncoder.encode(DEFAULT_PASSWORD));
        user.setRoles(Set.of(adminRole));
        userService.add(user);
    }
}
