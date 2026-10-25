package org.example.learningmanagementsystem.service;

import org.example.learningmanagementsystem.dto.course.CourseReadDto;
import org.example.learningmanagementsystem.entity.Course;
import org.example.learningmanagementsystem.repository.CourseRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService extends AbstractCrudService<Course, Long, CourseRepository> {
    public CourseService(CourseRepository repository) {
        super(repository);
    }

    public List<CourseReadDto> findDtoByAuthorId(Long authorId) {return repository.findDtoByAuthorId(authorId);}
}
