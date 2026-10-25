package org.example.learningmanagementsystem.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.learningmanagementsystem.dto.course.CourseReadDto;
import org.example.learningmanagementsystem.dto.user.CreateUserDto;
import org.example.learningmanagementsystem.dto.user.UpdateUserDto;
import org.example.learningmanagementsystem.dto.user.UserDto;
import org.example.learningmanagementsystem.entity.User;
import org.example.learningmanagementsystem.service.CourseService;
import org.example.learningmanagementsystem.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users/")
public class UserController {

    private final UserService userService;
    private final CourseService courseService;


    @GetMapping("findAll")
    public List<UserDto> findAll() {
        return userService.findAllDto();
    }

    @PostMapping("create")
    public UserDto createUser(@RequestBody @Valid CreateUserDto user) {
        return userService.createFromDto(user);
    }

    @PatchMapping("update/{id}")
    public UserDto updateUser(@PathVariable Long id,
                              @RequestBody @Valid UpdateUserDto user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("getUserCourses")
    public List<CourseReadDto> getUserCourses(HttpSession session) {
        return courseService.findDtoByAuthorId((Long) session.getAttribute("userId"));
    }
}
