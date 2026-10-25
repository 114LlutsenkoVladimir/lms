package org.example.learningmanagementsystem.repository;

import org.example.learningmanagementsystem.dto.course.CourseReadDto;
import org.example.learningmanagementsystem.dto.user.UserDto;
import org.example.learningmanagementsystem.entity.Course;
import org.example.learningmanagementsystem.entity.CourseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("select new org.example.learningmanagementsystem" +
            ".dto.course.CourseReadDto(c.id, c.title, c.description," +
            "c.author.id, c.status, c.createdAt)"+
    "from Course c")
    List<CourseReadDto> findAllDto();

    @Query("select new org.example.learningmanagementsystem" +
            ".dto.course.CourseReadDto(c.id, c.title, c.description," +
            "c.author.id, c.status, c.createdAt)"+
            "from Course c " +
            "where c.author.id == :authorId")
    List<CourseReadDto> findDtoByAuthorId(@Param("authorId") Long authorId);
}
