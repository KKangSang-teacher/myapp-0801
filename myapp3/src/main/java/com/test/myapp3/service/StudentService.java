package com.test.myapp3.service;

import java.util.List;

import com.test.myapp3.entity.Student;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student createStudent(Student student);
    Student updateStudent(Student student);
    void deleteStudent(Long id);
}
