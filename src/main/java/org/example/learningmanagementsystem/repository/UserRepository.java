package org.example.learningmanagementsystem.repository;

import org.example.learningmanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}