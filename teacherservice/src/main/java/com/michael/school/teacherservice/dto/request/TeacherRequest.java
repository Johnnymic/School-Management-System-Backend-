package com.michael.school.teacherservice.dto.request;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeacherRequest {
    private String firstName;

    private  String lastName;

    private String email;


    private String date_of_birth;


    private String phoneNo;

    private String profilePic;
}
