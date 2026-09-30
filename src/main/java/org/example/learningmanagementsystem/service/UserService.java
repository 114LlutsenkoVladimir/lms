package org.example.learningmanagementsystem.service;

import org.example.learningmanagementsystem.dto.user.CreateUserDto;
import org.example.learningmanagementsystem.dto.user.UserDto;
import org.example.learningmanagementsystem.entity.User;
import org.example.learningmanagementsystem.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractCrudService<User, Long, UserRepository> {

    private final PasswordEncoder passwordEncoder;

    protected UserService(UserRepository repository,
                          PasswordEncoder passwordEncoder) {
        super(repository);
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto createFromDto(CreateUserDto dto) {
        User user = new User();
        String psHash = passwordEncoder.encode(dto.password());
        user.setFirstName(dto.firstName());
        user.setLastName(dto.lastName());
        user.setEmail(dto.email());
        user.setPasswordHash(psHash);
        user.setRole(dto.role());
        repository.save(user);
        return new UserDto(
                user.getId(),
                user.getEmail(),
                user.getPasswordHash(),
                user.getFirstName(),
                user.getLastName(),
                user.getRole(),
                user.getCreatedAt()
        );
    }

    public boolean verifyPassword(String rawPassword, String encodedHash) {
        return passwordEncoder.matches(rawPassword, encodedHash);
    }
}
