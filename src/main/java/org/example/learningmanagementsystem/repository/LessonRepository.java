package org.example.learningmanagementsystem.repository;

import org.example.learningmanagementsystem.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}