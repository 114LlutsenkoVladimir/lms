package org.example.learningmanagementsystem.dto.user;

import jakarta.validation.constraints.*;
import org.example.learningmanagementsystem.entity.UserRole;

public record UpdateUserDto(
        @Email(message = "Некорректный формат email")
        String email,

        @Size(min = 8, max = 64, message = "Пароль должен быть от 8 до 64 символов")
        @Pattern(
                regexp = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z]).*$",
                message = "Пароль должен содержать хотя бы одну цифру, одну заглавную и одну строчную букву"
        )
        String password,

        @Size(min = 2, max = 50, message = "Имя должно быть от 2 до 50 символов")
        String firstName,

        @Size(min = 2, max = 50, message = "Имя должно быть от 2 до 50 символов")
        String lastName,

        UserRole role
) {}
