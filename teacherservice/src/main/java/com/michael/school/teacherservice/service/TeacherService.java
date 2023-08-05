package com.michael.school.teacherservice.service;

import com.michael.school.teacherservice.dto.request.TeacherRequest;
import com.michael.school.teacherservice.dto.response.TeacherCourseResponse;
import com.michael.school.teacherservice.dto.response.TeacherResponse;

import java.util.List;

public interface TeacherService {
    TeacherResponse addNewTeacher(TeacherRequest teacherRequest);

    TeacherResponse viewTeacherByCourse(Long teacherId);

   TeacherCourseResponse viewAllByTeacherByCourse(Long teacherId);
}
