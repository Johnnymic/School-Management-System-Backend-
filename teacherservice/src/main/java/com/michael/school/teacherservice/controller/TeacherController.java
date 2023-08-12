package com.michael.school.teacherservice.controller;

import com.michael.school.teacherservice.dto.request.TeacherRequest;
import com.michael.school.teacherservice.dto.response.TeacherResponse;
import com.michael.school.teacherservice.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor

public class TeacherController {

    private final TeacherService teacherService;


    @PostMapping("/add/new/teacher")
    private ResponseEntity<TeacherResponse> addNewTeacher(@RequestBody TeacherRequest teacherRequest){
         TeacherResponse teacherResponse = teacherService.addNewTeacher(teacherRequest);

         return new ResponseEntity<>(teacherResponse, HttpStatus.CREATED);

    }

    @GetMapping("/view/teacher/{teacherId}")
    private ResponseEntity<TeacherResponse> fetchTeacherByCourse(@PathVariable("teacherId") Long teacherId){
        TeacherResponse teacherResponse = teacherService.viewTeacherByCourse(teacherId);

        return new ResponseEntity<>(teacherResponse, HttpStatus.CREATED);

    }


}
