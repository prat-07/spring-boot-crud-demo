package com.pratham.crud_demo.controller;

import com.pratham.crud_demo.entity.Student;
import com.pratham.crud_demo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    //@Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println("inside student controller");
        Student createdStudent = studentService.createStudent(student);
        System.out.println("exiting student controller");
        return ResponseEntity
                .status(HttpStatus.CREATED)     //HttpStatus.CREATED ~ 201
                .body(createdStudent);
    }
}
