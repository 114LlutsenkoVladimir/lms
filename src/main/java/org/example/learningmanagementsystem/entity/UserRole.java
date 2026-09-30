package org.example.learningmanagementsystem.entity;

public enum UserRole {
    USER,
    ADMIN,
    INSTRUCTOR,
    STUDENT;

    public static UserRole fromString(String roleStr) {
        if (roleStr == null || roleStr.isBlank()) {
            return USER;
        }
        try {
            return UserRole.valueOf(roleStr.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Неизвестная роль: " + roleStr);
        }
    }
}
