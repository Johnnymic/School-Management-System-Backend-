package com.michael.school.teacherservice.repository;

import com.michael.school.teacherservice.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
