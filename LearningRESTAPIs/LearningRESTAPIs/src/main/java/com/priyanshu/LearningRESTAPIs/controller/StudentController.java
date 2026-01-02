package com.priyanshu.LearningRESTAPIs.controller;

import com.priyanshu.LearningRESTAPIs.dto.StudentDto;
import com.priyanshu.LearningRESTAPIs.entity.Student;
import com.priyanshu.LearningRESTAPIs.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/student1")
    public List<Student> getStudent(){
        return studentRepository.findAll();
    }

    @GetMapping("/student1/{id}")
    public StudentDto getStudentById(){
        return new StudentDto(5L,"Priyanshu","pj@gmail.com");
    }
}
