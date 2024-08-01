package com.test.myapp3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.myapp3.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
