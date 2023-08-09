package com.michael.school.studentservice.services;

import com.michael.school.studentservice.dto.request.StudentRequest;
import com.michael.school.studentservice.dto.response.StudentResponse;

import java.util.List;

public interface StudentService {
    StudentResponse addNewStudent(StudentRequest studentRequest);

   List <StudentResponse> viewAllStudentProfile();

    StudentResponse viewStudentProfile(Long id);
}
