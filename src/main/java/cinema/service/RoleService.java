package cinema.service;

import cinema.model.Role;
import cinema.model.Role.RoleName;

public interface RoleService {

    Role add(Role role);

    Role getByName(RoleName roleName);
}
