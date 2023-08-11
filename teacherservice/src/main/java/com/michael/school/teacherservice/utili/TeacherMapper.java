package com.michael.school.teacherservice.utili;

import com.michael.school.teacherservice.dto.request.TeacherRequest;
import com.michael.school.teacherservice.dto.response.TeacherResponse;
import com.michael.school.teacherservice.model.Teacher;

public class TeacherMapper {
    public static TeacherResponse mapToTeacherResponse(Teacher newTeacher) {
        return TeacherResponse.builder()
                .id(newTeacher.getTeacherId())
                .phoneNo(newTeacher.getPhoneNo())
                .email(newTeacher.getEmail())
                .lastName(newTeacher.getLastName())
                .firstName(newTeacher.getFirstName())
                .phoneNo(newTeacher.getPhoneNo())
                .build();
    }

    public static Teacher mapToTeacherEntity(TeacherRequest teacherRequest) {
        return  Teacher.builder()
                .phoneNo( teacherRequest.getPhoneNo())
                .email( teacherRequest.getEmail())
                .lastName( teacherRequest.getLastName())
                .firstName( teacherRequest.getFirstName())
                .phoneNo( teacherRequest.getPhoneNo())
                .build();


    }
}
