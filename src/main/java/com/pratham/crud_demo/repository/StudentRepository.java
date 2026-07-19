package com.pratham.crud_demo.repository;

import com.pratham.crud_demo.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {


    public Student saveStudent(Student studentReq) {
        System.out.println("inside student repository");
        Student s1 = new Student();

        s1.setId(101);
        s1.setName("Pratham");
        s1.setEmail("pratham@email.com");
        s1.setAge(20);
        s1.setRollNo(40);
        s1.setSubject("Spring Framework");

        System.out.println("exiting student repository");
        return s1;
    }
}
