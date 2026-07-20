package com.pratham.crud_demo.service;

import com.pratham.crud_demo.entity.Student;
import com.pratham.crud_demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq) {
        Student studentRes = studentRepository.save(studentReq);
        return studentRes;
    }

    public Student getStudent(Long id) {
        Optional<Student> studentResponse = studentRepository.findById(id);

        if(!studentResponse.isPresent())
            return null;
        return studentResponse.get();
    }

    public List<Student> getAllStudents() {
        List<Student> studentsResponse = studentRepository.findAll();
        return studentsResponse;
    }

    public Student updateStudent(Long id, Student student) {
        Optional<Student> existingStudent = studentRepository.findById(id);

        if(!existingStudent.isPresent())
            return null;

        Student updatedStudent = existingStudent.get();
//        updatedStudent.setId(id);     //reduntant as fetched student already has the same id.
        updatedStudent.setName(student.getName());
        updatedStudent.setAge(student.getAge());
        updatedStudent.setSubject(student.getSubject());
        updatedStudent.setRollNo(student.getRollNo());
        updatedStudent.setEmail(student.getEmail());

        Student studentResponse = studentRepository.save(updatedStudent);
        return studentResponse;
    }

    public boolean deleteStudent(Long id) {
        Optional<Student> studentToDelete = studentRepository.findById(id);
        if(!studentToDelete.isPresent())
            return false;

        studentRepository.deleteById(id);
        return true;
    }
}
