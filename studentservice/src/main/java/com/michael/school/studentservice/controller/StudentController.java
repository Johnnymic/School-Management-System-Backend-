package com.michael.school.studentservice.controller;

import com.michael.school.studentservice.dto.request.StudentRequest;
import com.michael.school.studentservice.dto.response.StudentResponse;
import com.michael.school.studentservice.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class
StudentController {

    private  final StudentService studentService;

    @PostMapping
    private ResponseEntity<StudentResponse> addNewStudent(@RequestBody StudentRequest studentRequest){
        StudentResponse studentRequests =  studentService.addNewStudent(studentRequest);
       return new ResponseEntity<>(studentRequests, HttpStatus.CREATED);

    }

    @GetMapping
    private ResponseEntity<List<StudentResponse>> viewAllStudentProfile(){
        List <StudentResponse> studentProfile=  studentService.viewAllStudentProfile();
        return new ResponseEntity<>(studentProfile, HttpStatus.OK);

    }

    @GetMapping("/view/profile/{studentId}")
    private ResponseEntity <StudentResponse> viewStudentProfile(@PathVariable("studentId") Long id){
        StudentResponse studentProfile=  studentService.viewStudentProfile(id);
        return new ResponseEntity<>(studentProfile, HttpStatus.OK);

    }

}
