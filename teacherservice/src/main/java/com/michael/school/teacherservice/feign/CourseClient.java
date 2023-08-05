package com.michael.school.teacherservice.feign;


import com.michael.school.teacherservice.dto.response.CourseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//http://localhost:8080/api/v1/course/view/course/{id}
@FeignClient(name = "course", url = "http://localhost:8081/api/v1/course/")
public interface CourseClient {

        @GetMapping("/view/course/{courseId}")
      public ResponseEntity<CourseResponse>  getCourseByTeacherId(@PathVariable("courseId") Long courseId);


    @GetMapping("/view/all/courses")
    public ResponseEntity <List<CourseResponse>> viewAllCourses();



}
