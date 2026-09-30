package org.example.learningmanagementsystem.dto.user;

import org.example.learningmanagementsystem.entity.UserRole;

import java.time.Instant;

public record UserDto(
        Long id,
        String email,
        String passwordHash,
        String firstName,
        String lastName,
        UserRole role,
        Instant createdAt
) {}
