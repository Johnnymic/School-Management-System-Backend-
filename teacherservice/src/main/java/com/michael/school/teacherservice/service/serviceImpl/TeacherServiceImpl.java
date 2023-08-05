package com.michael.school.teacherservice.service.serviceImpl;

import com.michael.school.teacherservice.dto.request.TeacherRequest;
import com.michael.school.teacherservice.dto.response.CourseResponse;
import com.michael.school.teacherservice.dto.response.TeacherCourseResponse;
import com.michael.school.teacherservice.dto.response.TeacherResponse;
import com.michael.school.teacherservice.exception.TeacherNotFoundException;
import com.michael.school.teacherservice.feign.CourseClient;
import com.michael.school.teacherservice.model.Teacher;
import com.michael.school.teacherservice.repository.TeacherRepository;
import com.michael.school.teacherservice.service.TeacherService;
import com.michael.school.teacherservice.utili.TeacherMapper;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class TeacherServiceImpl  implements TeacherService {

    private final TeacherRepository teacherRepository;

    private  final CourseClient courseClient;

    private  final ModelMapper modelMapper;


    @Override
    public TeacherResponse addNewTeacher(TeacherRequest teacherRequest) {
        Teacher teacher = TeacherMapper.mapToTeacherEntity(teacherRequest);
        var newTeacher = teacherRepository.save(teacher);
        return TeacherMapper.mapToTeacherResponse(newTeacher);
    }

    @Override
    public TeacherResponse viewTeacherByCourse(Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(()-> new TeacherNotFoundException("TEACHER NOT FOUND "));
        TeacherResponse teacherResponse = modelMapper.map(teacher,TeacherResponse.class);
       ResponseEntity<CourseResponse> courseResponse = courseClient.getCourseByTeacherId(teacherId);
      CourseResponse addCourseResponse = courseResponse.getBody();
        log.info("coursReponse {}:" +courseResponse);
        teacherResponse.setCourseResponse(addCourseResponse);
        return teacherResponse;
    }

    @Override
    public TeacherCourseResponse viewAllByTeacherByCourse(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(()-> new TeacherNotFoundException("TEACHER NOT FOUND "));
        TeacherCourseResponse teacherResponse = modelMapper.map(teacher, TeacherCourseResponse.class);
        ResponseEntity<List<CourseResponse>> courseResponseResponseEntity = courseClient.viewAllCourses();
        List<CourseResponse> newCourseList = courseResponseResponseEntity.getBody();
        teacherResponse.setCourseResponses(newCourseList);
        return teacherResponse;
    }


}
