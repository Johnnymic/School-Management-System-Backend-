package com.michael.school.teacherservice.dto.response;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeacherResponse {
    private  Long id;
    private String firstName;

    private  String lastName;

    private String email;


    private String date_of_birth;


    private String phoneNo;

    private String profilePic;

    private  CourseResponse courseResponse;

}
