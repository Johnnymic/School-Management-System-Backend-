package com.michael.school.courseservice.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "course_tbl")
public class Course {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private  String courseName;

    private  String courseCode;

    private String courseDescription;

    private  Integer courseCredit;




}
