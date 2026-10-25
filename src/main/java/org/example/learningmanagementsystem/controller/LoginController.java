package org.example.learningmanagementsystem.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.learningmanagementsystem.dto.LoginDto;
import org.example.learningmanagementsystem.entity.User;
import org.example.learningmanagementsystem.exception.IncorrectPasswordException;
import org.example.learningmanagementsystem.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.FailedLoginException;
import java.util.Optional;

@RequiredArgsConstructor
@RestController("/login/")
public class LoginController {

    private final UserService userService;

    @PostMapping("login")
    public User loginUser(@RequestBody LoginDto dto,
                          HttpSession session) throws IncorrectPasswordException {
        Optional<User> user = userService.findByEmail(dto.email());
        if(user.isEmpty())
            throw new EntityNotFoundException("user with email: " + dto.email() + " not found");

        userService.verifyPassword(dto.password(), user.get().getPasswordHash());
        session.setAttribute("userId", user.get().getId());
        return user.get();
    }
}
