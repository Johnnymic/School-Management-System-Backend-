package com.michael.school.studentservice.repository;

import com.michael.school.studentservice.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository  extends JpaRepository<Student,Long> {

}
