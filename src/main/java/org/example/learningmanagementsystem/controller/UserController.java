package org.example.learningmanagementsystem.controller;

import org.example.learningmanagementsystem.dto.user.CreateUserDto;
import org.example.learningmanagementsystem.dto.user.UserDto;
import org.example.learningmanagementsystem.entity.User;
import org.example.learningmanagementsystem.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("create")
    public UserDto createUser(@RequestBody CreateUserDto user) {
        return userService.createFromDto(user);
    }

    @PatchMapping("update/{id}")
    public UserDto updateUser(@PathVariable Long id,
                              @RequestBody CreateUserDto user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
