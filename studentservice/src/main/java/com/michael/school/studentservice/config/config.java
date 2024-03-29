package com.michael.school.studentservice.config;

import com.michael.school.courseservice.models.Course;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
@Configuration
public class config {

    @Bean
    public RestTemplate restTemplate(){
       return   new RestTemplate();
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }





}
