package com.michael.school.studentservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class StudentRequest {

    private String firstName;

    private  String lastName;

    private String email;


    private String date_of_birth;

    private  String password;


    private String phoneNo;

    private String profilePic;
}
