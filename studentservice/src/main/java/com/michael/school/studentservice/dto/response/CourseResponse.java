package com.michael.school.studentservice.dto.response;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
