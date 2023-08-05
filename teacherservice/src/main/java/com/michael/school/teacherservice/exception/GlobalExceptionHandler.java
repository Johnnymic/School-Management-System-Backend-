package com.michael.school.teacherservice.exception;

import com.michael.school.teacherservice.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TeacherNotFoundException.class)
    public ResponseEntity<ErrorResponse>handleTeacherNotFoundException(TeacherNotFoundException teacherNotFoundException,
                                                                       WebRequest webRequest){
         ErrorResponse errorResponse = new ErrorResponse(new Date(),teacherNotFoundException.getMessage(), webRequest.getDescription(false));
         return  new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }


}
