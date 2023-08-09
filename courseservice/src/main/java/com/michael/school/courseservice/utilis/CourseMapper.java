package com.michael.school.courseservice.utilis;

import com.michael.school.courseservice.dto.request.CourseRequestDto;
import com.michael.school.courseservice.dto.response.CourseResponse;
import com.michael.school.courseservice.models.Course;

public class CourseMapper {
    public static Course mapToCourseEntity(CourseRequestDto courseRequestDto) {
        return Course.builder()
                .courseName(courseRequestDto.getCourseName())
                .courseCode(courseRequestDto.getCourseCode())
                .courseCredit(courseRequestDto.getCourseCredit())
                .courseDescription(courseRequestDto.getCourseDescription())
                .build();

    }
    public static CourseResponse mapToCourseResponse(Course newCourse) {
        return CourseResponse.builder()
                .courseName(newCourse.getCourseName())
                .courseCode(newCourse.getCourseCode())
                .courseCredit(newCourse.getCourseCredit())
                .courseDescription(newCourse.getCourseDescription())
                .build();

    }
}
