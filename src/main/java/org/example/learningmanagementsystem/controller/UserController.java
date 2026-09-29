package org.example.learningmanagementsystem.controller;

import org.example.learningmanagementsystem.dto.user.CreateUserDto;
import org.example.learningmanagementsystem.dto.user.UserDto;
import org.example.learningmanagementsystem.entity.User;
import org.example.learningmanagementsystem.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/")
public class UserController {

    private UserService userService;

    @PostMapping("create")
    public UserDto createUser(@RequestBody CreateUserDto user) {

    }
}
