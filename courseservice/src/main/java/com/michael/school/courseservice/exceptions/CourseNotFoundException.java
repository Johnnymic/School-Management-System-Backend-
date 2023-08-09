package com.michael.school.courseservice.exceptions;

public class CourseNotFoundException extends  RuntimeException  {


    public CourseNotFoundException(String message) {
        super(message);
    }
}
