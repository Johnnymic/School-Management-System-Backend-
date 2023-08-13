package com.michael.school.courseservice.services.serviceImpl;

import com.michael.school.courseservice.dto.request.CourseRequestDto;
import com.michael.school.courseservice.dto.response.CourseResponse;
import com.michael.school.courseservice.exceptions.CourseNotFoundException;
import com.michael.school.courseservice.models.Course;
import com.michael.school.courseservice.repository.CourseRepository;
import com.michael.school.courseservice.services.CourseService;
import com.michael.school.courseservice.utilis.CourseMapper;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;



@Service
@RequiredArgsConstructor
public class CourseServiceImp implements CourseService {

    private final CourseRepository courseRepository;
    @Override
    public CourseResponse addNewCourse(CourseRequestDto courseRequestDto) {
        Course addCourse = CourseMapper.mapToCourseEntity(courseRequestDto);
        Course newCourse = courseRepository.save(addCourse);
        return CourseMapper.mapToCourseResponse(newCourse);
    }

    @Override
    public List<CourseResponse> viewAllRegisterCourse() {
        List<Course>viewCourses = courseRepository.findAll();
        return viewCourses.stream().
                map(CourseMapper::mapToCourseResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CourseResponse viewRegisterCourse(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(()-> new CourseNotFoundException("course not found"));
        return CourseMapper.mapToCourseResponse(course);
    }

    @Override
    public CourseResponse updateRegisterCourse(Long courseId, CourseRequestDto courseRequestDto) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(()-> new CourseNotFoundException("course not found"));
        course.setCourseName(course.getCourseName());
        course.setCourseCode(course.getCourseCode());
        course.setCourseDescription(course.getCourseDescription());
        course.setCourseCredit(course.getCourseCredit());
        var updatedCoursed = courseRepository.save(course);
        return CourseMapper.mapToCourseResponse(updatedCoursed);
    }

    @Override
    public String deleteCourse(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(()-> new CourseNotFoundException("course not found"));
        courseRepository.delete(course);
        return "course deleted successfully";
    }

    @Override
    public Page<CourseResponse> viewAllPaginatedCourse(Integer pageNo, Integer pageSize, String sortBy) {
        List<Course> fetchAllCourse = courseRepository.findAll();
        List<CourseResponse> fetchAllCourseResponse = fetchAllCourse
                .stream()
                .map(CourseMapper::mapToCourseResponse)
                .collect(Collectors.toList());
        Collections.sort(fetchAllCourseResponse, Comparator.comparing(CourseResponse::getCourseCode,Collections.reverseOrder()));
        int min = pageNo*pageSize;
        int max = Math.max(pageSize*(pageNo +1),fetchAllCourseResponse.size());
        PageRequest pageRequest = PageRequest.of(pageNo,pageSize, Sort.Direction.DESC,sortBy);
        return  new PageImpl<>(fetchAllCourseResponse.subList(min,max),pageRequest,fetchAllCourseResponse.size());
    }


}
