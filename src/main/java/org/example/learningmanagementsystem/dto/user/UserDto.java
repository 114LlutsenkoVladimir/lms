package org.example.learningmanagementsystem.dto.user;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

public record UserDto(
        Long id,
        String email,
        String passwordHash,
        String firstName,
        String lastName,
        String role,
        Instant createdAt
) {}
