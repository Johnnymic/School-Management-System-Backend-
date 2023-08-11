package com.michael.school.teacherservice.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

public class CourseResponse {

    private  String courseName;

    private  String courseCode;

    private String courseDescription;

    private  Integer courseCredit;

}
