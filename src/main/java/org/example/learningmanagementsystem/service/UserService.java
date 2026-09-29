package org.example.learningmanagementsystem.service;

import org.example.learningmanagementsystem.dto.user.CreateUserDto;
import org.example.learningmanagementsystem.entity.User;
import org.example.learningmanagementsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractCrudService<User, Long, UserRepository> {

    protected UserService(UserRepository repository) {
        super(repository);
    }

    public User createFromDto(CreateUserDto dto) {
        User user = new User();
        user.setEmail(dto);
        return user;
    }
}
