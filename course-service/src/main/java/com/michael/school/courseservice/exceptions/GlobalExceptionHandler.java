package com.michael.school.courseservice.exceptions;

import com.michael.school.courseservice.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCourseNotFoundFoundException(CourseNotFoundException courseNotFoundException, WebRequest webRequest) {
           ErrorResponse errorResponse = new ErrorResponse(new Date(), courseNotFoundException.getMessage(), webRequest.getDescription(false));
     return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
