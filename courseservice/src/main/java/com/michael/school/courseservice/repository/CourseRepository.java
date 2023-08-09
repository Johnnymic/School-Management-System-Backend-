package com.michael.school.courseservice.repository;

import com.michael.school.courseservice.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository  extends JpaRepository<Course, Long> {
}
