package com.michael.school.courseservice.services;

import com.michael.school.courseservice.dto.request.CourseRequestDto;
import com.michael.school.courseservice.dto.response.CourseResponse;

import java.util.List;

public interface CourseService {
    CourseResponse addNewCourse(CourseRequestDto courseRequestDto);

    List<CourseResponse> viewAllRegisterCourse();

    CourseResponse viewRegisterCourse(Long courseId);

    CourseResponse updateRegisterCourse(Long courseId, CourseRequestDto courseRequestDto);

    String deleteCourse(Long courseId);
}
