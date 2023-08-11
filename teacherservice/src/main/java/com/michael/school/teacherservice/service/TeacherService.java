package com.michael.school.teacherservice.service;

import com.michael.school.teacherservice.dto.request.TeacherRequest;
import com.michael.school.teacherservice.dto.response.TeacherResponse;

public interface TeacherService {
    TeacherResponse addNewTeacher(TeacherRequest teacherRequest);

    TeacherResponse viewTeacherByCourse(java.lang.Long teacherId);
}
