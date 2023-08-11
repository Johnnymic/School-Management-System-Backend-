package com.michael.school.studentservice.services.serviceImpl;

import com.michael.school.courseservice.models.Course;
import com.michael.school.studentservice.dto.request.StudentRequest;
import com.michael.school.studentservice.dto.response.CourseResponse;
import com.michael.school.studentservice.dto.response.StudentResponse;
import com.michael.school.studentservice.exceptions.StudentNotFoundException;
import com.michael.school.studentservice.models.Student;
import com.michael.school.studentservice.repository.StudentRepository;
import com.michael.school.studentservice.services.StudentService;
import com.michael.school.studentservice.utilis.Mapper;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final RestTemplate restTemplate;
    private final WebClient webClient;

    private  final ModelMapper modelMapper;




    @Override
    public StudentResponse addNewStudent(StudentRequest studentRequest) {
        Student student = Mapper.mapToStudentEntity(studentRequest);
        var newStudent = studentRepository.save(student);
        return Mapper.mapToStudentResponse(newStudent);
    }

    @Override
    public List<StudentResponse> viewAllStudentProfile() {
        List<Student> fetchAllStudent = studentRepository.findAll();
        return fetchAllStudent.stream()
                .map(Mapper::mapToStudentResponse)
                .collect(Collectors.toList());


    }
    @Override
    public StudentResponse viewStudentProfile(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("student not found"));

        StudentResponse studentResponse = modelMapper.map(student,StudentResponse.class);
        CourseResponse courseResponseMono = webClient
                .get()
                .uri("http://localhost:8081/api/v1/course/view/course/{id}", id)
                .retrieve()
                .bodyToMono(CourseResponse.class)
                .block();
        System.out.println(courseResponseMono);
        log.info("course :" + courseResponseMono);
        studentResponse.setCourseResponse(courseResponseMono);
        return studentResponse;
    }




}
