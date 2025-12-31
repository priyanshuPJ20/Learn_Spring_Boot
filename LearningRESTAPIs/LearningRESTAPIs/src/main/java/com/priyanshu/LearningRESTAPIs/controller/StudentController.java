package com.priyanshu.LearningRESTAPIs.controller;

import com.priyanshu.LearningRESTAPIs.dto.StudentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {


    @GetMapping("/student")
    public StudentDto getStudent(){
        return new StudentDto(4L,"Priyanshu","pj@gmail.com");
    }
}
