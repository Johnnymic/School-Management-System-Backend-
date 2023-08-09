package com.michael.school.studentservice.utilis;

import com.michael.school.studentservice.dto.request.StudentRequest;
import com.michael.school.studentservice.dto.response.StudentResponse;
import com.michael.school.studentservice.models.Student;

public class Mapper {

    public static Student mapToStudentEntity(StudentRequest studentRequest) {
        return Student.builder()
                .firstName(studentRequest.getFirstName())
                .lastName(studentRequest.getLastName())
                .email(studentRequest.getEmail())
                .password(studentRequest.getPassword())
                .date_of_birth(studentRequest.getDate_of_birth())
                .phoneNo(studentRequest.getPassword())
                .profilePic(studentRequest.getProfilePic())
                .build();
    }
    public static  StudentResponse mapToStudentResponse(Student student) {
        return StudentResponse.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .date_of_birth(student.getDate_of_birth())
                .phoneNo(student.getPassword())
                .profilePic(student.getProfilePic())
                .build();

    }
}
