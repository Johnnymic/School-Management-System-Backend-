package com.michael.school.courseservice.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CourseRequestDto {
    private Long courseId;

    private  String courseName;

    private  String courseCode;

    private String courseDescription;

    private  Integer courseCredit;
}
