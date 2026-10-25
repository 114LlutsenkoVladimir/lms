package org.example.learningmanagementsystem.repository;

import org.example.learningmanagementsystem.dto.user.UserDto;
import org.example.learningmanagementsystem.entity.User;
import org.example.learningmanagementsystem.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select new org.example.learningmanagementsystem" +
            ".dto.user.UserDto(u.id, u.email, u.passwordHash, " +
            "u.firstName, u.lastName, u.role, u.createdAt) " +
            "from User u")
    List<UserDto> findAllDto();

    Optional<User> findByEmail(String email);


}