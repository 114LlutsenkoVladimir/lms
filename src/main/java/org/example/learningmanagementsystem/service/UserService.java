package org.example.learningmanagementsystem.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.learningmanagementsystem.dto.user.CreateUserDto;
import org.example.learningmanagementsystem.dto.user.UpdateUserDto;
import org.example.learningmanagementsystem.dto.user.UserDto;
import org.example.learningmanagementsystem.entity.User;
import org.example.learningmanagementsystem.entity.UserRole;
import org.example.learningmanagementsystem.exception.IncorrectPasswordException;
import org.example.learningmanagementsystem.repository.UserRepository;
import org.hibernate.annotations.NotFound;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.FailedLoginException;
import java.time.Instant;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
        user.setCreatedAt(Instant.now());
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

    public UserDto updateUser(Long id, UpdateUserDto dto) {
        User user = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("user not found, id: " + id)
        );
        if (dto.email() != null && !dto.email().isBlank()) {
            user.setEmail(dto.email());
        }
        if (dto.password() != null && !dto.password().isBlank()) {
            user.setPasswordHash(passwordEncoder.encode(dto.password()));
        }
        if (dto.firstName() != null) {
            user.setFirstName(dto.firstName());
        }
        if (dto.lastName() != null) {
            user.setLastName(dto.lastName());
        }
        if (dto.role() != null) {
            user.setRole(dto.role());
        }
        User updatedUser = repository.save(user);
        return new UserDto(
                updatedUser.getId(),
                updatedUser.getEmail(),
                updatedUser.getPasswordHash(),
                updatedUser.getFirstName(),
                updatedUser.getLastName(),
                updatedUser.getRole(),
                updatedUser.getCreatedAt()
        );
    }

    public void verifyPassword(String rawPassword, String encodedHash) throws IncorrectPasswordException {
        if(!passwordEncoder.matches(rawPassword, encodedHash))
            throw new IncorrectPasswordException("incorrect password");
    }

    public List<UserDto> findAllDto() {
        return repository.findAllDto();
    }

    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
