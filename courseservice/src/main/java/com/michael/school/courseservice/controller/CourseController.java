package com.michael.school.courseservice.controller;

import com.michael.school.courseservice.dto.request.CourseRequestDto;
import com.michael.school.courseservice.dto.response.CourseResponse;
import com.michael.school.courseservice.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private  final CourseService courseService;

    @PostMapping("/add/new/course")
    private ResponseEntity<CourseResponse> addNewCourse(@RequestBody CourseRequestDto courseRequestDto){

        CourseResponse courseResponse = courseService.addNewCourse(courseRequestDto);

        return new ResponseEntity<>(courseResponse, HttpStatus.CREATED);
    }

    @GetMapping("/view/all/courses")
    private ResponseEntity <List<CourseResponse>> viewAllCourses(){

        List<CourseResponse> courseResponse = courseService.viewAllRegisterCourse();

        return new ResponseEntity<>(courseResponse, HttpStatus.CREATED);
    }

    @GetMapping("/view/course/{courseId}")

    private ResponseEntity <CourseResponse> viewAllCourses(@PathVariable("courseId") Long courseId){

        CourseResponse courseResponse = courseService.viewRegisterCourse(courseId);

        return new ResponseEntity<>(courseResponse, HttpStatus.CREATED);
    }

    @PutMapping("/edit/course/{courseId}")

    private ResponseEntity <CourseResponse> updateRegisterCourse(@PathVariable("courseId") Long courseId, @RequestBody CourseRequestDto courseRequestDto){

        CourseResponse courseResponse = courseService.updateRegisterCourse(courseId,courseRequestDto);

        return new ResponseEntity<>(courseResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/course/{courseId}")

    private ResponseEntity <String> deleteCourses(@PathVariable("courseId") Long courseId){

     String courseResponse = courseService.deleteCourse(courseId);

        return new ResponseEntity<>(courseResponse, HttpStatus.CREATED);
    }




}
