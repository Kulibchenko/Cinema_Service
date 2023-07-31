package cinema.service.mapper;

import cinema.dto.response.UserResponseDto;
import cinema.model.Role;
import cinema.model.User;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements ResponseDtoMapper<UserResponseDto, User> {
    @Override
    public UserResponseDto mapToDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setEmail(user.getEmail());
        Set<String> roles = new HashSet<>();
        user.getRoles().stream()
                .map(Role::getAuthority)
                .forEach(roles::add);
        responseDto.setRoles(roles);
        return responseDto;
    }
}
