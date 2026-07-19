package com.pratham.crud_demo.service;

import com.pratham.crud_demo.entity.Student;
import com.pratham.crud_demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq) {
        System.out.println("inside student service");
        Student studentRes = studentRepository.saveStudent(studentReq);
        System.out.println("exiting student service");
        return studentRes;
    }
}
