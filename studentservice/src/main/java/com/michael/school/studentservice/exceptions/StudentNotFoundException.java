package com.michael.school.studentservice.exceptions;

public class StudentNotFoundException extends RuntimeException {



    public StudentNotFoundException(String message) {
        super(message);
    }
}
