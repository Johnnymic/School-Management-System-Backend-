package com.michael.school.studentservice.exceptions;

import com.michael.school.studentservice.dto.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    private ResponseEntity<ErrorResponse>teacherNotFound(StudentNotFoundException studentNotFoundException,
                                                         WebRequest webRequest){

        ErrorResponse errorResponse = new ErrorResponse(new Date(),studentNotFoundException.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }


}
