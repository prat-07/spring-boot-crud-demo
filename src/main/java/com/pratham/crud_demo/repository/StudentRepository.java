package com.pratham.crud_demo.repository;

import com.pratham.crud_demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
