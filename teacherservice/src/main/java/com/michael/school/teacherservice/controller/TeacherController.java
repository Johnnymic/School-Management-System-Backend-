package com.michael.school.teacherservice.controller;

import com.michael.school.teacherservice.dto.request.TeacherRequest;
import com.michael.school.teacherservice.dto.response.TeacherResponse;
import com.michael.school.teacherservice.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {

    private TeacherService teacherService;


      @PostMapping("/add/new/teacher")
    private ResponseEntity<TeacherResponse> addNewTeacher(@RequestBody TeacherRequest teacherRequest){
         TeacherResponse teacherResponse = teacherService.addNewTeacher(teacherRequest);

         return new ResponseEntity<>(teacherResponse, HttpStatus.CREATED);

    }

    @PostMapping("/view/teacher/{teacherId}")
    private ResponseEntity<TeacherResponse> fetchTeacherByCourse(@PathVariable("teacherId") Long teacherId){
        TeacherResponse teacherResponse = teacherService.viewTeacherByCourse(teacherId);

        return new ResponseEntity<>(teacherResponse, HttpStatus.CREATED);

    }


}
