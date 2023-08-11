package com.michael.school.teacherservice.feign;


import com.michael.school.teacherservice.dto.response.CourseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//http://localhost:8080/api/v1/course/view/course/{id}
@FeignClient(name = "course", url = "http://localhost:8080/api/v1/course")
public interface CourseClient {

        @GetMapping("/view/course/{courseId}")
       CourseResponse  getCourseByTeacherId(@PathVariable("courseId") Long courseId);



}
