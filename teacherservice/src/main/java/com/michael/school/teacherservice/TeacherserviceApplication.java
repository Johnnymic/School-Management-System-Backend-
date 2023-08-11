package com.michael.school.teacherservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TeacherserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeacherserviceApplication.class, args);
	}

}
