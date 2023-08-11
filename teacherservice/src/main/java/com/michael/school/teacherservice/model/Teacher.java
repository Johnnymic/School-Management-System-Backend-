package com.michael.school.teacherservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long teacherId;

    private  String firstName;

    private String lastName;

    private String password;

    private  String date_of_birth;

    private String phoneNo;

    private  String email;

    private String  profilePic;


}
