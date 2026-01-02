package com.priyanshu.LearningRESTAPIs.service.impl;

import com.priyanshu.LearningRESTAPIs.dto.StudentDto;
import com.priyanshu.LearningRESTAPIs.entity.Student;
import com.priyanshu.LearningRESTAPIs.repository.StudentRepository;
import com.priyanshu.LearningRESTAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

//    @Override
//    public List<StudentDto> getAllStudents() {
//        List<Student> students=studentRepository.findAll();
//        List<StudentDto> studentDtoList=students
//                .stream() Stream<Student>
//                .map(Student student -> new StudentDto(student.getId(),student.getName(),student.getEmail())).toList();
//        return studentDtoList;
//    }

    @Override
    public List<StudentDto> getAllStudents() {

        List<Student> students = studentRepository.findAll();

        return students.stream()
                .map(student -> new StudentDto(
                        student.getId(),
                        student.getName(),
                        student.getEmail()
                ))
                .toList();
    }

}
