package org.example.learningmanagementsystem.dto.course;

import org.example.learningmanagementsystem.entity.CourseStatus;
import java.time.Instant;

public record CourseReadDto(
        Long id,
        String title,
        String description,
        Long authorId,
        CourseStatus status,
        Instant createdAt
) { }
