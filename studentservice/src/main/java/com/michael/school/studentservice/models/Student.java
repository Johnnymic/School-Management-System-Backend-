package com.michael.school.studentservice.models;

import com.michael.school.courseservice.models.Course;
import com.michael.school.studentservice.dto.response.CourseResponse;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long studentId;

    private  String firstName;

    private String lastName;

    private String password;

    private  String date_of_birth;

    private String phoneNo;

    private  String email;

    private String  profilePic;







}
