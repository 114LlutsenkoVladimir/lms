package org.example.learningmanagementsystem.dto.user;

import org.example.learningmanagementsystem.entity.UserRole;


public record CreateUserDto(
         String email,
         String password,
         String firstName,
         String lastName,
         UserRole role
) {}
