package com.rodin.sanitaryEngineeringShop.controllers;

import com.rodin.sanitaryEngineeringShop.model.Student;
import com.rodin.sanitaryEngineeringShop.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
