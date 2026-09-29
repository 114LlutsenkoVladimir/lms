package org.example.learningmanagementsystem.dto.user;

import java.time.Instant;

public record CreateUserDto(
         String email,
         String password,
         String firstName,
         String lastName,
         String role,
         Instant createdAt
) {}
