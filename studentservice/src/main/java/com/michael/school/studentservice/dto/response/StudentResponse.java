package com.michael.school.studentservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class StudentResponse {

    private String firstName;

    private  String lastName;

    private String email;


    private String date_of_birth;


    private String phoneNo;

    private String profilePic;

    private CourseResponse courseResponse;


}
