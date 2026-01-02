package com.priyanshu.LearningRESTAPIs.service;

import com.priyanshu.LearningRESTAPIs.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();
}
