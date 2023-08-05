package com.michael.school.teacherservice.dto.response;

import lombok.*;

import java.util.List;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeacherCourseResponse {
    private  Long id;
    private String firstName;

    private  String lastName;

    private String email;


    private String date_of_birth;


    private String phoneNo;

    private String profilePic;
    private List<CourseResponse> courseResponses;
}
