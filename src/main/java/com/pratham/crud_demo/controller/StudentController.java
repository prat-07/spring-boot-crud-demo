package com.pratham.crud_demo.controller;

import com.pratham.crud_demo.entity.Student;
import com.pratham.crud_demo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    //@Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    //create student
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity
                .status(HttpStatus.CREATED)     //HttpStatus.CREATED ~ 201
                .body(createdStudent);
    }

    //get one student
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student studentResponse = studentService.getStudent(id);

        if(studentResponse == null)
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentResponse);
    }

    //get all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> studentsResponse = studentService.getAllStudents();

        if(studentsResponse.isEmpty())
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentsResponse);
    }

    //update
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student){
        Student studentResponse = studentService.updateStudent(id, student);

        if(studentResponse == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.status(HttpStatus.OK).body(studentResponse);
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        boolean isDeleted = studentService.deleteStudent(id);

        if(!isDeleted)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no user found");

        return ResponseEntity.status(HttpStatus.OK).body("user deleted");
    }
}
